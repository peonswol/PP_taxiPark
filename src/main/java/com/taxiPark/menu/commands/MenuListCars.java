package com.taxiPark.menu.commands;

import com.taxiPark.submenu.filtering.ATypeFiltering;
import com.taxiPark.Color;
import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.SubMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuListCars extends ATypeFiltering implements IMenuExecute {

    private static List<Car> filteredAndSortedCars = new ArrayList<>(AutoPark.getCars());

    private static final Logger logger = LoggerFactory.getLogger(MenuListCars.class);

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        SubMenu subMenu = new SubMenu();
        while (true){
            if (showList(filteredAndSortedCars)) {
                subMenu.openSubMenu(subMenu, scanner, filteredAndSortedCars);
            }
            else {
                MainMenuTaxiPark menu = new MainMenuTaxiPark();
                menu.openTaxiParkProgramme(scanner, filteredAndSortedCars);
            }
        }
    }

    public static void setFilteredAndSortedCars(List<Car> filteredAndSortedCars) {
        MenuListCars.filteredAndSortedCars = filteredAndSortedCars;
    }

    public static List<Car> getFilteredAndSortedCars() {
        return filteredAndSortedCars;
    }

    public boolean showList(List<Car> cars){

        if(!cars.isEmpty()){
            showIntoList();
            for (Car car : cars){
                System.out.println(car.toListString());
                System.out.println(Color.PURPLE+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + Color.ANSI_RESET);
            }
            logger.info("Існуючі машини виведено.");
            return true;
        }
        System.out.print("\nThere are no car\n\n");
        logger.info("Машин немає для виведення.");
        return false;
    }

    public void showIntoList(){
        System.out.println("\t\t\t༼ つ ◕_◕ ༽つ\n" +
                "THE LIST OF CARS");
        System.out.print("| ID\t\t|\tmark and model\t| year manufacture |\t\tcost\t\t|\t\tcolor\t\t| max speed | --- |\tfuel type\t| engine capacity | fuel consumption for 100 km\n");
        System.out.print(Color.PURPLE+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" + Color.ANSI_RESET);
    }
}
