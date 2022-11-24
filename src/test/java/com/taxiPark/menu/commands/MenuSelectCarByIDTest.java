package com.taxiPark.menu.commands;

import com.taxiPark.WorkWithFile;
import com.taxiPark.park.car.Car;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

class MenuSelectCarByIDTest extends TestCase {

    MenuSelectCarByID menuSelectCarByID = new MenuSelectCarByID();

    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testDeleteCar() {
        menuSelectCarByID.workWithFile = Mockito.mock(WorkWithFile.class);

        Car car = Mockito.mock(Car.class);
        Car car1 = Mockito.mock(Car.class);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car);

        Car.setKstCar(3);

        menuSelectCarByID.car = car1;
        MenuListCars.setFilteredAndSortedCars(cars);
        when(menuSelectCarByID.workWithFile.deleteFileCar(car)).thenReturn(true);

        menuSelectCarByID.deleteCar(cars);
        assertEquals(2, cars.size());
        assertEquals(2, Car.getKstCar());
    }

    @Test
    public void testDeleteFileCar() {
        menuSelectCarByID.workWithFile = Mockito.mock(WorkWithFile.class);

        Car car = Mockito.mock(Car.class);
        when(menuSelectCarByID.workWithFile.deleteFileCar(car)).thenReturn(true);

        menuSelectCarByID.deleteFileCar(car);

        assertTrue(menuSelectCarByID.workWithFile.deleteFileCar(car));
        assertEquals("File deleted successfully", byteArrayOutputStream.toString().trim());
    }

    @Test
    public void testSearchAndShowCarByID() {
        Car.setKstCar(0);
        assertEquals(2, menuSelectCarByID.searchAndShowCarByID(2, asList(new Car(), new Car(), new Car())).getCarID());
    }

    @Test
    public void testEnterCommand() {
        String enteredCommand = "2\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        int actualCommand = menuSelectCarByID.enterCommand(new Scanner(System.in));
        assertEquals(2, actualCommand);
    }

    @Test
    public void testEnterID() {
        String enteredID = "4\n";
        System.setIn(new ByteArrayInputStream(enteredID.getBytes()));

        int actualID = menuSelectCarByID.enterID(new Scanner(System.in));
        assertEquals(4, actualID);
    }

    @Test
    public void testEditCarData() {
    }

    @Test
    public void testAdditionalOptions() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testShowCarAndOption() {
    }

    @Test
    public void testChooseCommand() {
    }
}