package com.taxiPark.menu;

import com.taxiPark.CallEnterCommandMenu;
import com.taxiPark.menu.commands.*;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ISubMenu;

import java.util.*;

public class MainMenuTaxiPark implements ISubMenu {

    private final List<IMenuExecute> menu = new ArrayList<>();

    public MainMenuTaxiPark(){
        menu.add(new MenuExit());
        menu.add(new MenuAddNewCar());
        menu.add(new MenuListCars());
        menu.add(new MenuSelectCarByID());
        menu.add(new MenuCostAllCars());
    }

    public int sizeOfCommands() {
        return menu.size();
    }

    public void execute(int command, Scanner scanner, List<Car> cars) {
        menu.get(command).execute(scanner, cars);
    }

    public void openTaxiParkProgramme(Scanner scanner, List<Car> cars){

        MainMenuTaxiPark menu = new MainMenuTaxiPark();
        int command;

        while (true) {

            callIntoMenu();
            CallEnterCommandMenu callEnterCommandMenu = new CallEnterCommandMenu();
            command = callEnterCommandMenu.enterCommandCheckException(scanner, sizeOfCommands());
            menu.execute(command, scanner, cars);
        }
    }

    public void callIntoMenu(){
        System.out.println("\nWelcome to TAXI PARK :");
        showMenu();
    }

    public void showMenu(){
        System.out.print("""
                
                \t[1] - add new car
                \t[2] - show list
                \t[3] - select car by id
                \t[4] - cost of autopark
                \t[0] - exit
                
                Enter command :\t""");
    }

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        openTaxiParkProgramme(scanner, cars);
    }
}


