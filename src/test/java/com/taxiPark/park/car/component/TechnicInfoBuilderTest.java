package com.taxiPark.park.car.component;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class TechnicInfoBuilderTest {
    @Mock
    TechnicInfo technicInfo;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetTransmission(){
        technicInfo = TechnicInfo.builder()
                .setTransmission("transmission")
                .build();

        assertEquals("transmission", technicInfo.getTransmission());
    }

    @Test
    public void testSetDriveType(){
        technicInfo = TechnicInfo.builder()
                .setDriveType("drive type")
                .build();
        assertEquals("drive type", technicInfo.getDriveType());
    }

    @Test
    public void testToString(){
        technicInfo = TechnicInfo.builder()
                .setTransmission("transmission")
                .setDriveType("drive type")
                .build();

        assertEquals("""

                \ttransmission -------------------- transmission
                \tdrive type ---------------------- drive type""", technicInfo.toString());
    }

    @Test
    public void testBuild(){
        TechnicInfo newTechnicInfo = TechnicInfo
                .builder(technicInfo)
                .build();

        assertEquals(technicInfo, newTechnicInfo);
    }
}
