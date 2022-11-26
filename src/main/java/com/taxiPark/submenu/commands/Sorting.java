package com.taxiPark.submenu.commands;


import com.taxiPark.CallEnterCommandMenu;
import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.commands.MenuExit;
import com.taxiPark.park.car.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Sorting implements ISubMenu {

    private static final Logger logger = LoggerFactory.getLogger(Sorting.class);

    public void sortByYearManufacture(List<Car> cars) {
        cars.sort(Comparator.comparing(car -> car.getGeneralInfo().getYearManufacture()));
    }

    public void sortByCost(List<Car> cars) {
        cars.sort(Comparator.comparing(car -> car.getGeneralInfo().getCost()));
    }

    public void sortByMarkAndModel(List<Car> cars) {
        cars.sort(Comparator.comparing(car -> car.getGeneralInfo().getMarkAndModel()));
    }

    public void sortByMaxSpeed(List<Car> cars) {
        cars.sort(Comparator.comparing(car -> car.getGeneralInfo().getMaxSpeed()));
    }

    public void sortByFuelConsumptionFor100km(List<Car> cars) {
        cars.sort(Comparator.comparing(car -> car.getFuelInfo().getFuelConsumptionFor100km()));
    }

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        int command;

        callIntoMenu();
        CallEnterCommandMenu callEnterCommandMenu = new CallEnterCommandMenu();
        command = callEnterCommandMenu.enterCommandCheckException(scanner, sizeOfCommands());
        chooseSorting(scanner, command, cars);
        logger.info("Машини відсортовано, командою - " + command + ".");
    }

    public void chooseSorting(Scanner scanner, int command, List<Car> cars){
        switch (command) {
            case 0 -> {
                MenuExit exit = new MenuExit();
                exit.execute(scanner, cars);
            }
            case 1 -> sortByMarkAndModel(cars);
            case 2 -> sortByYearManufacture(cars);
            case 3 -> sortByCost(cars);
            case 4 -> sortByMaxSpeed(cars);
            case 5 -> sortByFuelConsumptionFor100km(cars);
            case 6 -> {
                MainMenuTaxiPark mainMenuTaxiPark = new MainMenuTaxiPark();
                mainMenuTaxiPark.openTaxiParkProgramme(scanner, cars);
            }
        }
    }

    public String showMenu() {
        return """
                                
                \t[1] - mark and model of cars
                \t[2] - year of manufacture of cars
                \t[3] - cost of cars
                \t[4] - max speed of cars
                \t[5] - fuel consumption for 100 km cars
                
                \t[6] - general menu
                \t[0] - exit
                                
                Enter command :\t""";

    }


    public void callIntoMenu(){
        //clearConsole();
        System.out.println("\nSelect a sort item :");
        System.out.println(showMenu());
    }

    public int sizeOfCommands() {
        return 6;
    }

}
