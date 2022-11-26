package com.taxiPark.submenu;

import com.taxiPark.menu.commands.MenuExit;
import com.taxiPark.menu.commands.MenuSelectCarByID;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ClearSelection;
import com.taxiPark.submenu.commands.Filtering;
import com.taxiPark.submenu.commands.ISubMenu;
import com.taxiPark.submenu.commands.Sorting;
import com.taxiPark.CallEnterCommandMenu;
import com.taxiPark.menu.MainMenuTaxiPark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenu {
    protected List<ISubMenu> menu = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(SubMenu.class);

    protected CallEnterCommandMenu callEnterCommandMenu = new CallEnterCommandMenu();
    public SubMenu(){

        menu.add(new MenuExit());
        menu.add(new Sorting());
        menu.add(new Filtering());
        menu.add(new ClearSelection());
        menu.add(new MenuSelectCarByID());
        menu.add(new MainMenuTaxiPark());
    }

    protected void execute(int command, Scanner scanner, List<Car> cars){
        logger.info("Викликано команду підменю - "+menu.get(command).getClass().getSimpleName());
        menu.get(command).execute(scanner, cars);
    }

    public void openSubMenu(SubMenu subMenu, Scanner scanner, List<Car> cars) {

        int command;

        subMenu.callIntoMenu();
        command = callEnterCommandMenu.enterCommandCheckException(scanner, sizeOfCommands());
        subMenu.execute(command, scanner, cars);

    }

    protected void callIntoMenu(){
        System.out.println("\nWelcome to submenu :");
        showMenu();
    }

    protected void showMenu(){
        System.out.print("""
                \n\t[1] - sorting
                \t[2] - filtering
                \t[3] - clear previous selection
                \t[4] - search for car by ID
                
                \t[5] - general menu
                \t[0] - exit
                
                Enter command :\t""");
    }

    protected int sizeOfCommands() {
        return menu.size();
    }
}
