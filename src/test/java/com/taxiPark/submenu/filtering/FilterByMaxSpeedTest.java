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

class FilterByMaxSpeedTest extends TestCase {

    FilterByMaxSpeed filterByMaxSpeed = new FilterByMaxSpeed();

    @Test
    public void testFilter() {
        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(70)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(100)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(170)
                        .build(), null, null, null)
        );


        filterByMaxSpeed.cars = new ArrayList<>(actualCars);
        filterByMaxSpeed.setStart(90);
        filterByMaxSpeed.setEnd(110);

        filterByMaxSpeed.filter();

        assertEquals(1, filterByMaxSpeed.cars.size());
    }

    @Test
    public void testEnterLimitation() {
        String enteredCommand = "90\n110\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByMaxSpeed.enterLimitation(new Scanner(System.in));
        assertEquals(90.0, filterByMaxSpeed.getStart());
        assertEquals(110.0, filterByMaxSpeed.getEnd());
    }
}