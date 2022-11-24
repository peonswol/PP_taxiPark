package com.taxiPark.submenu.filtering;

import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.FuelInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class FilterByFuelTypeTest extends TestCase {

    FilterByFuelType filterByFuelType = new FilterByFuelType();

    @Test
    public void testEnterLimitation() {
        String enteredCommand = "a c\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByFuelType.enterLimitation(new Scanner(System.in));
        assertArrayEquals(new String[]{"a", "c"}, filterByFuelType.getFuelTypes());

    }

    @Test
    public void testFilter() {
        List<Car> actualCars = asList(
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelType("a")
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelType("b")
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelType("c")
                                .build(), null)
        );


        filterByFuelType.cars = new ArrayList<>(actualCars);
        filterByFuelType.setFuelTypes(new String[]{"k", "a"});

        filterByFuelType.filter();

        assertEquals(1, filterByFuelType.cars.size());
    }
}