package com.taxiPark.menu.commands;

import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ISubMenu;
import com.taxiPark.submenu.filtering.ATypeFiltering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class MenuExit implements IMenuExecute, ISubMenu {

    private static final Logger logger = LoggerFactory.getLogger(MenuExit.class);

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        System.out.println("Bye, bye ... ಥ_ಥ");
        logger.info("Програму завершено.");
        System.exit(0);
    }
}
