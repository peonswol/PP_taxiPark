package com.taxiPark.menu.commands;

import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.SubMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class MenuCostAllCars implements IMenuExecute {

    private static final Logger logger = LoggerFactory.getLogger(MenuCostAllCars.class);

    @Override
    public void execute(Scanner scanner, List<Car> cars){
        System.out.println("total cost of the fleet ($ˍ$) - "+ sumPriceCars(cars));
        SubMenu subMenu = new SubMenu();
        subMenu.openSubMenu(subMenu, scanner, cars);
        logger.info("Сумарність вартості машин виведено.");
    }

    public double sumPriceCars(List<Car> cars){
        double totalSum = 0F;

        for (Car car : cars){
            totalSum += car.getGeneralInfo().getCost();
        }

        logger.info("Обраховано вартість всіх машин.");

        return totalSum;
    }
}
