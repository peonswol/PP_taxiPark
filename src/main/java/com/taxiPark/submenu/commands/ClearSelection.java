package com.taxiPark.submenu.commands;


import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.commands.MenuListCars;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClearSelection implements ISubMenu {

    private static final Logger logger = LoggerFactory.getLogger(ClearSelection.class);

    @Override
    public void execute(Scanner scanner, List<Car> cars){

        cars.clear();
        cars.addAll(AutoPark.getCars());
        logger.info("Очищено заклик машин від сортування і фільтрації.");
    }
}
