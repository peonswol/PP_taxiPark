package com.taxiPark.submenu.commands;

import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.filtering.*;
import com.taxiPark.CallEnterCommandMenu;
import com.taxiPark.menu.commands.MenuListCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filtering implements ISubMenu {

    private final List<ATypeFiltering> menu = new ArrayList<>();

    public Filtering(){

        menu.add(new FilterByMark());
        menu.add(new FilterByYear());
        menu.add(new FilterByCost());
        menu.add(new FilterByColor());
        menu.add(new FilterByMaxSpeed());
        menu.add(new FilterByEngineCapacity());
        menu.add(new FilterByFuelType());
        menu.add(new FilterByFuelConsumptionFor100km());
        menu.add(new MenuListCars());
    }

    @Override
    public void execute(Scanner scanner, List<Car> cars){

        Filtering filtering = new Filtering();
        int command;

        while (true) {
            callIntoMenu();
            CallEnterCommandMenu callEnterCommandMenu = new CallEnterCommandMenu();
            command = callEnterCommandMenu.enterCommandCheckException(scanner, sizeOfCommands());
            filtering.execute(command, scanner, cars);
        }
    }

    public void execute(int command, Scanner scanner, List<Car> cars){
        menu.get(command).execute(scanner, cars);
    }

    public int sizeOfCommands() {
        return menu.size();
    }

    public void callIntoMenu(){
        System.out.println("\nSelect a filtering item :");
        showMenu();
    }

    public void showMenu(){
        System.out.print("""
                \n\t[0] - mark
                \t[1] - year manufacture
                \t[2] - cost
                \t[3] - color
                \t[4] - max speed
                \t[5] - engine capacity
                \t[6] - fuel type
                \t[7] - fuel consumption for 100 km
                
                \t[8] - show cars
                
                Enter command :\t""");
    }
}

