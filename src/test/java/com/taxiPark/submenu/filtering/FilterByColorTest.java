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
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class FilterByColorTest extends TestCase {

    FilterByColor filterByColor = new FilterByColor();

    @Test
    public void testEnterLimitation() {
        String enteredCommand = "a c\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByColor.enterLimitation(new Scanner(System.in));
        assertArrayEquals(new String[]{"a", "c"}, filterByColor.getColorsCars());
    }

    @Test
    public void testFilter() {

        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setColor("a")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setColor("b")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setColor("c")
                        .build(), null, null, null)
        );


        filterByColor.cars = new ArrayList<>(actualCars);
        filterByColor.setColorsCars(new String[]{"a", "c"});

        filterByColor.filter();

        assertEquals(2, filterByColor.cars.size());
    }
}