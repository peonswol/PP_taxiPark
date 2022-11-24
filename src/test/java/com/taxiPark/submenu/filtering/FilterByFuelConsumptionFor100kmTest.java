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

class FilterByFuelConsumptionFor100kmTest extends TestCase {

    FilterByFuelConsumptionFor100km filterByFuelConsumptionFor100km = new FilterByFuelConsumptionFor100km();

    @Test
    void filter() {
        List<Car> actualCars = asList(
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(7)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(10)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(17)
                                .build(), null)
        );

        filterByFuelConsumptionFor100km.cars = new ArrayList<>(actualCars);
        filterByFuelConsumptionFor100km.setStart(17);
        filterByFuelConsumptionFor100km.setEnd(20);

        filterByFuelConsumptionFor100km.filter();

        assertEquals(1, filterByFuelConsumptionFor100km.cars.size());

    }

    @Test
    void enterLimitation() {
        String enteredCommand = "18\n20\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByFuelConsumptionFor100km.enterLimitation(new Scanner(System.in));
        assertEquals(18.0, filterByFuelConsumptionFor100km.getStart());
        assertEquals(20.0, filterByFuelConsumptionFor100km.getEnd());
    }
}