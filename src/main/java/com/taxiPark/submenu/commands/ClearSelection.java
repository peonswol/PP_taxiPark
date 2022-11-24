package com.taxiPark.submenu.commands;


import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.commands.MenuListCars;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClearSelection implements ISubMenu {

    @Override
    public void execute(Scanner scanner, List<Car> cars){

        cars.clear();
        cars.addAll(AutoPark.getCars());
    }
}
