package com.taxiPark.menu.commands;


import com.taxiPark.submenu.commands.ISubMenu;
import com.taxiPark.Color;
import com.taxiPark.WorkWithFile;
import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.editCarData.EditCarData;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ClearSelection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class MenuSelectCarByID implements IMenuExecute, ISubMenu {

    protected Car car;

    protected WorkWithFile workWithFile = new WorkWithFile();

    private static final Logger logger = LoggerFactory.getLogger(MenuSelectCarByID.class);

    @Override
    public void execute(Scanner scanner, List<Car> cars) {
        System.out.println("Here you can see complete information about the car by ID /ᐠ｡ꞈ｡ᐟ\\");

        int id = enterID(scanner);
        showCarAndOption(scanner, id, cars);
    }

    public void showCarAndOption(Scanner scanner, int id, List<Car> cars){
        car = searchAndShowCarByID(id, cars);
        additionalOptions(scanner, car, cars);
    }

    protected Car searchAndShowCarByID(int id, List<Car> cars){
        for (Car car: cars){
            if (car.getCarID() == id){
                System.out.println(car);
                logger.info("Знайдено і показано машину з ID - "+id+".");
                return car;
            }
        }
        logger.info("Бажаної машини не знайдено.");
        return null;
    }

    protected int enterID(Scanner scanner){
        System.out.print("Enter ID ---> ");

        int id;

        while (true){
            try {
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("\n");

                logger.info("Користувач ввів бажане id авто - "+id+".");

                return id;
            } catch (Exception error) {
                System.out.println("try again...");
                logger.error("Користувач ввів некоректний тип даних. Помилка ", error);
            }
        }
    }

    protected int enterCommand(Scanner scanner){

        int choosing;

        while (true){
            System.out.println("\nSelect a next step executing programme :");
            showMenu();
            try {
                choosing = Integer.parseInt(scanner.nextLine());
                System.out.println("\n");

                if (choosing <= 3) {
                    return choosing;
                } else {
                    throw new Exception();
                }
            } catch (Exception error) {
                System.out.println("try again... 0 - 3");
                logger.error("Користувач ввів некоректний тип даних або вийшов за доступні програмні межі. Помилка ", error);
            }
        }
    }

    protected void showMenu(){
        System.out.print("""
                                
                \t[1] - edit the car data
                \t[2] - delete car
                
                \t[3] - general menu
                \t[0] - exit
                                
                Enter command :\t""");

    }

    protected void chooseCommand(int choosing, Scanner scanner, List<Car> cars){

            switch (choosing) {
                case 0 -> {
                    MenuExit exit = new MenuExit();
                    exit.execute(scanner, cars);
                    logger.info("Користувач вибрав команду - вихід.");
                }
                case 1 -> {
                    editCarData(scanner, cars);
                    logger.info("Користувач вибрав команду - редагувати дані.");
                }

                case 2 -> {
                    deleteCar(cars);
                    logger.info("Користувач вибрав команду - видалити авто.");
                }

                case 3 -> {
                    MainMenuTaxiPark mainMenuTaxiPark = new MainMenuTaxiPark();
                    mainMenuTaxiPark.openTaxiParkProgramme(scanner, cars);
                    logger.info("Користувач вибрав команду - показати головне меню.");
                }
            }
    }

    protected void deleteCar(List<Car> cars){
        cars.remove(car);
        MenuListCars.getFilteredAndSortedCars().remove(car);
        Car.setKstCar(Car.getKstCar()-1);
        deleteFileCar(car);
    }

    public void deleteFileCar(Car car){


        if (workWithFile.deleteFileCar(car)){
            System.out.println("File deleted successfully");
        } else {
            System.out.println("There was a problem deleting the file!!");
        }
    }

    protected void editCarData(Scanner scanner, List<Car> cars){
        EditCarData editCarData = new EditCarData();
        editCarData.execute(scanner, car, cars);
    }

    protected void additionalOptions(Scanner scanner, Car car, List<Car> cars){
        if (car != null){
            int choosing = enterCommand(scanner);
            chooseCommand(choosing, scanner, cars);

            ClearSelection clearSelection = new ClearSelection();
            clearSelection.execute(scanner, cars);
        }
        else {
            System.out.println(Color.RED+"\nThere is no car with this id, try clearing previous search queries (sorting and filtering)\n"+Color.ANSI_RESET);
        }
    }


}
