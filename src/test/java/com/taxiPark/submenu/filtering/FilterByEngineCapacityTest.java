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

class FilterByEngineCapacityTest extends TestCase {

    FilterByEngineCapacity filterByEngineCapacity = new FilterByEngineCapacity();

    @Test
    public void testFilter() {
        List<Car> actualCars = asList(
                new Car(null, null,
                        FuelInfo.builder()
                                .setEngineCapacity(7)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setEngineCapacity(10)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setEngineCapacity(17)
                                .build(), null)
        );

        filterByEngineCapacity.cars = new ArrayList<>(actualCars);
        filterByEngineCapacity.setStart(1);
        filterByEngineCapacity.setEnd(20);

        filterByEngineCapacity.filter();

        assertEquals(3, filterByEngineCapacity.cars.size());
    }

    @Test
    public void testEnterLimitation() {
        String enteredCommand = "1\n20\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByEngineCapacity.enterLimitation(new Scanner(System.in));
        assertEquals(1.0, filterByEngineCapacity.getStart());
        assertEquals(20.0, filterByEngineCapacity.getEnd());
    }
}