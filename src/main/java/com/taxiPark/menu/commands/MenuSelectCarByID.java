package com.taxiPark.menu.commands;


import com.taxiPark.submenu.commands.ISubMenu;
import com.taxiPark.Color;
import com.taxiPark.WorkWithFile;
import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.editCarData.EditCarData;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.submenu.commands.ClearSelection;

import java.util.List;
import java.util.Scanner;

public class MenuSelectCarByID implements IMenuExecute, ISubMenu {

    protected Car car;
    protected WorkWithFile workWithFile = new WorkWithFile();

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
                return car;
            }
        }
        return null;
    }

    protected int enterID(Scanner scanner){
        System.out.print("Enter ID ---> ");

        int id;

        while (true){
            try {
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("\n");
                return id;
            } catch (Exception error) {
                System.out.println("try again...");
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
                }
                case 1 -> editCarData(scanner, cars);
                case 2 -> deleteCar(cars);

                case 3 -> {
                    MainMenuTaxiPark mainMenuTaxiPark = new MainMenuTaxiPark();
                    mainMenuTaxiPark.openTaxiParkProgramme(scanner, cars);
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
