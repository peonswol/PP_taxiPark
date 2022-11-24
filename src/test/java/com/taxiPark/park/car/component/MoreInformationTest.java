package com.taxiPark.park.car.component;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class MoreInformationTest {
    @Mock
    MoreInformation moreInformation;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetState(){
        moreInformation = MoreInformation.builder()
                .setState("state")
                .build();

        assertEquals("state", moreInformation.getState());
    }

    @Test
    public void testSetSecurityTypes(){
        moreInformation = MoreInformation.builder()
                .setSecurityTypes("security types")
                .build();

        assertEquals("security types", moreInformation.getSecurityTypes());
    }

    @Test
    public void testSetComfortTypes(){
        moreInformation = MoreInformation.builder()
                .setComfortTypes("comfort types")
                .build();

        assertEquals("comfort types", moreInformation.getComfortTypes());
    }

    @Test
    public void testToString(){
        moreInformation = MoreInformation.builder()
                .setState("state")
                .setSecurityTypes("security types")
                .setComfortTypes("comfort types")
                .build();

        assertEquals("""

                \tstate --------------------------- state
                \tsecurity types ------------------ security types
                \tcomfort types ------------------- comfort types""", moreInformation.toString());
    }

    @Test
    public void testBuild(){
        MoreInformation newMoreInformation = MoreInformation
                .builder(moreInformation)
                .build();

        assertEquals(moreInformation, newMoreInformation);
    }
}
