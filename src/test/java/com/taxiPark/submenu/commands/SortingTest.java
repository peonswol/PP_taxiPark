package com.taxiPark.submenu.commands;

import com.taxiPark.menu.commands.MenuListCars;
import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Arrays.asList;

class SortingTest extends TestCase {

    @InjectMocks
    Sorting sortingMock;

    Sorting sorting = new Sorting();

    @Mock
    List<Car> actualCars;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSortByYearManufacture() {

         actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2010)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2007)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setYearManufacture(2017)
                        .build(), null, null, null)
        );

        sorting.sortByYearManufacture(actualCars);

        assertEquals(2007, actualCars.get(0).getGeneralInfo().getYearManufacture());
        assertEquals(2010, actualCars.get(1).getGeneralInfo().getYearManufacture());
        assertEquals(2017, actualCars.get(2).getGeneralInfo().getYearManufacture());
    }

    @Test
    public void testSortByCost() {
        actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setCost(10000)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setCost(7000)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setCost(17000)
                        .build(), null, null, null)
        );

        sorting.sortByCost(actualCars);

        assertEquals(7000.0, actualCars.get(0).getGeneralInfo().getCost());
        assertEquals(10000.0, actualCars.get(1).getGeneralInfo().getCost());
        assertEquals(17000.0, actualCars.get(2).getGeneralInfo().getCost());
    }

    @Test
    public void testSortByMarkAndModel() {

        actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("b")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("a")
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMarkAndModel("c")
                        .build(), null, null, null)
        );

        sorting.sortByMarkAndModel(actualCars);

        assertEquals("a", actualCars.get(0).getGeneralInfo().getMarkAndModel());
        assertEquals("b", actualCars.get(1).getGeneralInfo().getMarkAndModel());
        assertEquals("c", actualCars.get(2).getGeneralInfo().getMarkAndModel());
    }

    @Test
    public void testSortByMaxSpeed() {

        List<Car> actualCars = asList(
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(100)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(70)
                        .build(), null, null, null),
                new Car(GeneralInfo.builder()
                        .setMaxSpeed(170)
                        .build(), null, null, null)
        );

        sorting.sortByMaxSpeed(actualCars);

        assertEquals(70.0, actualCars.get(0).getGeneralInfo().getMaxSpeed());
        assertEquals(100.0, actualCars.get(1).getGeneralInfo().getMaxSpeed());
        assertEquals(170.0, actualCars.get(2).getGeneralInfo().getMaxSpeed());
    }

    @Test
    public void testSortByFuelConsumptionFor100km() {

        List<Car> actualCars = asList(
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(10)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(7)
                                .build(), null),
                new Car(null, null,
                        FuelInfo.builder()
                                .setFuelConsumptionFor100km(17)
                                .build(), null)
        );

        sorting.sortByFuelConsumptionFor100km(actualCars);

        assertEquals(7.0, actualCars.get(0).getFuelInfo().getFuelConsumptionFor100km());
        assertEquals(10.0, actualCars.get(1).getFuelInfo().getFuelConsumptionFor100km());
        assertEquals(17.0, actualCars.get(2).getFuelInfo().getFuelConsumptionFor100km());

    }

    @Test
    public void testShowMenu() {
        assertEquals("""
                                
                \t[1] - mark and model of cars
                \t[2] - year of manufacture of cars
                \t[3] - cost of cars
                \t[4] - max speed of cars
                \t[5] - fuel consumption for 100 km cars
                
                \t[6] - general menu
                \t[0] - exit
                                
                Enter command :\t""", sorting.showMenu());
    }

    @Test
    public void testSizeOfCommands() {
        assertEquals(6, sorting.sizeOfCommands());
    }

    @Test
    public void testCallIntoMenu() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testChooseSorting() {

    }
}