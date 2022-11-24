package com.taxiPark.submenu.filtering;

import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.GeneralInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

class FilterByCostTest extends TestCase {

    FilterByCost filterByCost = new FilterByCost();

    @Test
    public void testFilter() {
        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setCost(7000)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setCost(10000)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setCost(17000)
                        .build(), null, null, null));


        filterByCost.cars = new ArrayList<>(actualCars);
        filterByCost.setStart(5000);
        filterByCost.setEnd(10000);

        filterByCost.filter();

        assertEquals(2, filterByCost.cars.size());
    }

    @Test
    public void testEnterLimitation() {

        String enteredCommand = "5000\n10000\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByCost.enterLimitation(new Scanner(System.in));
        assertEquals(5000.0, filterByCost.getStart());
        assertEquals(10000.0, filterByCost.getEnd());
    }
}