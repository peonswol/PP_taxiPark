package com.taxiPark.park.car.component;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class FuelInfoBuilderTest {

    @Mock
    FuelInfo fuelInfo;

    private final double delta = 1e-5;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetFuelType(){
        fuelInfo = FuelInfo.builder()
                .setFuelType("fuel type")
                .build();

        assertEquals("fuel type", fuelInfo.getFuelType());
    }

    @Test
    public void testSetEngineType(){
        fuelInfo = FuelInfo.builder()
                .setEngineType("engine type")
                .build();
        assertEquals("engine type", fuelInfo.getEngineType());
    }

    @Test
    public void testSetEngineCapacity(){
        fuelInfo = FuelInfo.builder()
                .setEngineCapacity(1.1)
                .build();

        assertEquals(1.1, fuelInfo.getEngineCapacity(), delta);
    }

    @Test
    public void testSetFuelConsumptionFor100km(){
        fuelInfo = FuelInfo.builder()
                .setFuelConsumptionFor100km(1.1)
                .build();

        assertEquals(1.1, fuelInfo.getFuelConsumptionFor100km(), delta);
    }

    @Test
    public void testToString(){
        fuelInfo = FuelInfo.builder()
                .setFuelType("fuel type")
                .setEngineType("engine type")
                .setEngineCapacity(1.1)
                .setFuelConsumptionFor100km(1.1)
                .build();

        assertEquals("""

                \tfuel type ----------------------- fuel type
                \tengine type --------------------- engine type
                \tengine capacity ----------------- 1.1
                \tfuel consumption for 100 km ----- 1.1""", fuelInfo.toString());

    }

    @Test
    public void testToListString(){
        fuelInfo = FuelInfo.builder()
                .setFuelType("fuel type")
                .setEngineCapacity(1.1)
                .setFuelConsumptionFor100km(1.1)
                .build();

        assertEquals(String.format("| %-12s| %-16.2f| %-17.2f", "fuel type", 1.1, 1.1), fuelInfo.toListString());
    }

    @Test
    public void testBuild(){
        FuelInfo newFuelInfo = FuelInfo
                .builder(fuelInfo)
                .build();

        assertEquals(fuelInfo, newFuelInfo);
    }
}
