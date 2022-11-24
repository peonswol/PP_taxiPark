package com.taxiPark.submenu.commands;

import com.taxiPark.menu.commands.IMenuExecute;
import com.taxiPark.park.car.Car;

import java.util.List;
import java.util.Scanner;

public interface ISubMenu extends IMenuExecute {
    void execute(Scanner scanner, List<Car> cars);
}
