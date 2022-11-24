package com.taxiPark.menu.commands;

import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ISubMenu;
import com.taxiPark.submenu.filtering.ATypeFiltering;

import java.util.List;
import java.util.Scanner;

public class MenuExit implements IMenuExecute, ISubMenu {

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        System.out.println("Bye, bye ... ಥ_ಥ");
        System.exit(0);
    }
}
