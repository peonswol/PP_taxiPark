package com.taxiPark.submenu.commands;

import com.taxiPark.menu.commands.MenuListCars;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ClearSelectionTest extends TestCase {
    ClearSelection clearSelection = new ClearSelection();

    @Mock
    Car car;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        AutoPark.getCars().clear();
        AutoPark.getCars().add(car);
        AutoPark.getCars().add(car);

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        clearSelection.execute(new Scanner(System.in), cars);

        assertArrayEquals((new List[]{AutoPark.getCars()}), new List[]{cars});
    }
}