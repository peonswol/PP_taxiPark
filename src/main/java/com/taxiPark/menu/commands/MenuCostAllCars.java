package com.taxiPark.menu.commands;

import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.SubMenu;

import java.util.List;
import java.util.Scanner;

public class MenuCostAllCars implements IMenuExecute {


    @Override
    public void execute(Scanner scanner, List<Car> cars){
        System.out.println("total cost of the fleet ($ˍ$) - "+ sumPriceCars(cars));
        SubMenu subMenu = new SubMenu();
        subMenu.openSubMenu(subMenu, scanner, cars);
    }

    public double sumPriceCars(List<Car> cars){
        double totalSum = 0F;

        for (Car car : cars){
            totalSum += car.getGeneralInfo().getCost();
        }

        return totalSum;
    }
}
