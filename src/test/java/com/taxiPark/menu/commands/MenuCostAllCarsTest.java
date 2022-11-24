package com.taxiPark.menu.commands;

import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.GeneralInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;

class MenuCostAllCarsTest extends TestCase {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    MenuCostAllCars menuCostAllCars = new MenuCostAllCars();

    @BeforeEach
    public void setUp(){
        //menuCostAllCars.subMenu = mock(SubMenu.class);
        System.setOut(new PrintStream(byteArrayOutputStream));
    }


   /* @Test
    void testExecute() {
        Scanner scanner = new Scanner(System.in);

        doNothing().when(menuCostAllCars.subMenu).openSubMenu(scanner, null);

        menuCostAllCars.execute(scanner, null);
        assertEquals("total cost of the fleet ($ˍ$) - 0", byteArrayOutputStream.toString().trim());

    }*/

    @Test
    public void testSumPriceCars() {
        List<Car> cars = asList(
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

        assertEquals(34000.0, menuCostAllCars.sumPriceCars(cars));
    }
}