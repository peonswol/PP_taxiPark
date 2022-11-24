package com.taxiPark.menu.commands;

import com.taxiPark.Color;
import com.taxiPark.park.car.Car;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuListCarsTest extends TestCase {

    private final PrintStream standardOut = System.out; // new PrintStream(byteArrayOutputStream);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    MenuListCars menuListCars = new MenuListCars();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void execute() {
    }

    @Test
    void setFilteredAndSortedCars() {
    }

    @Test
    public void testGetFilteredAndSortedCars() {
    }

    @Test
    public void testShowList() {
        List<Car> cars = new ArrayList<>();
        Car car = Mockito.mock(Car.class);
        cars.add(car);
        cars.add(car);

        boolean bool = menuListCars.showList(cars);
        assertNotEquals("""
                        ༼ つ ◕_◕ ༽つ
                        THE LIST OF CARS
                        | ID\t\t|\tmark and model\t| year manufacture |\t\tcost\t\t|\t\tcolor\t\t| max speed | --- |\tfuel type\t| engine capacity | fuel consumption for 100 km
                        \u001B[35m----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        \u001B[0mnull
                        \u001B[35m----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\u001B[0m
                        null
                        \u001B[35m----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\u001B[0m""",
                byteArrayOutputStream.toString().trim());
        assertTrue(bool);
    }

    @Test
    public void testShowListIsEmpty() {
        List<Car> cars = new ArrayList<>();

        boolean bool = menuListCars.showList(cars);
        assertEquals("There are no car",
                byteArrayOutputStream.toString().trim());
        assertFalse(bool);
    }

    @Test
    public void testShowIntoList() {
        menuListCars.showIntoList();
        assertNotEquals(
                "༼ つ ◕_◕ ༽つ\n" +
                "THE LIST OF CARS\n" +
                        "| ID\t\t|\tmark and model\t| year manufacture |\t\tcost\t\t|\t\tcolor\t\t| max speed | --- |\tfuel type\t| engine capacity | fuel consumption for 100 km\n"
                + Color.PURPLE+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" + Color.ANSI_RESET, byteArrayOutputStream.toString().trim());

    }
}