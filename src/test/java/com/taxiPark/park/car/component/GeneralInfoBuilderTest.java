package com.taxiPark.park.car.component;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class GeneralInfoBuilderTest {
    @Mock
    GeneralInfo generalInfo;

    private final double delta = 1e-5;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetMarkAndModel(){
        generalInfo = GeneralInfo.builder()
                .setMarkAndModel("mark and model")
                .build();

        assertEquals("mark and model", generalInfo.getMarkAndModel());
    }

    @Test
    public void testSetYearManufacture(){
        generalInfo = GeneralInfo.builder()
                .setYearManufacture(2022)
                .build();

        assertEquals(2022, generalInfo.getYearManufacture());
    }

    @Test
    public void testSetCost(){
        generalInfo = GeneralInfo.builder()
                .setCost(1.1)
                .build();

        assertEquals(1.1, generalInfo.getCost(), delta);
    }

    @Test
    public void testSetColor(){
        generalInfo = GeneralInfo.builder()
                .setColor("color")
                .build();

        assertEquals("color", generalInfo.getColor());
    }

    @Test
    public void testSetMaxSpeed(){
        generalInfo = GeneralInfo.builder()
                .setMaxSpeed(1.1)
                .build();

        assertEquals(1.1, generalInfo.getMaxSpeed(), delta);
    }

    @Test
    public void testToString(){

        generalInfo = GeneralInfo.builder()
                .setMarkAndModel("mark and model")
                .setYearManufacture(2022)
                .setCost(1.1)
                .setColor("color")
                .setMaxSpeed(1.1)
                .build();

        assertEquals("""

                \tmark and model ------------------ mark and model
                \tyear manufacture ---------------- 2022
                \tcost ---------------------------- 1.1
                \tcolor --------------------------- color
                \tmax speed ----------------------- 1.1""", generalInfo.toString());
    }

    @Test
    public void testToListString(){
        generalInfo = GeneralInfo.builder()
                .setMarkAndModel("mark and model")
                .setYearManufacture(2022)
                .setCost(1.1)
                .setColor("color")
                .setMaxSpeed(1.1)
                .build();

        assertEquals(String.format(" %-18s| %-17d| %-19.2f| %-18s| %-10.2f| --- ", "mark and model", 2022, 1.1, "color", 1.1), generalInfo.toListString());
    }

    @Test
    public void testBuild(){
        GeneralInfo newGeneralInfo = GeneralInfo
                .builder(generalInfo)
                .build();

        assertEquals(generalInfo, newGeneralInfo);
    }
}
