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

class FilterByYearTest extends TestCase {

    FilterByYear filterByYear = new FilterByYear();

    @Test
    void filter() {
        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2007)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2010)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2017)
                        .build(), null, null, null)
        );


        filterByYear.cars = new ArrayList<>(actualCars);
        filterByYear.setStart(2010);
        filterByYear.setEnd(2020);

        filterByYear.filter();

        assertEquals(2, filterByYear.cars.size());
    }

    @Test
    void enterLimitation() {
        String enteredCommand = "2010\n2020\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        filterByYear.enterLimitation(new Scanner(System.in));
        assertEquals(2010, filterByYear.getStart());
        assertEquals(2020, filterByYear.getEnd());
    }
}