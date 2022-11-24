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
import static org.junit.jupiter.api.Assertions.*;

class FilterByMarkTest extends TestCase {

    FilterByMark filterByMark = new FilterByMark();

    @Test
    void enterLimitation() {
        String enteredCommand = "a c\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByMark.enterLimitation(new Scanner(System.in));
        assertArrayEquals(new String[]{"a", "c"}, filterByMark.getMarksCars());
    }

    @Test
    void filter() {
        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("a")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("b")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("c")
                        .build(), null, null, null)
        );

        filterByMark.cars = new ArrayList<>(actualCars);
        filterByMark.setMarksCars(new String[]{"a", "b"});

        filterByMark.filter();

        assertEquals(2, filterByMark.cars.size());
    }
}