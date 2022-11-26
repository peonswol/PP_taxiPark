package com.taxiPark.menu.editCarData;

import com.taxiPark.menu.commands.MenuExit;
import com.taxiPark.menu.commands.MenuSelectCarByID;
import com.taxiPark.park.car.Car;
import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.addCar.addNewCar.AddingNewCarByWrite;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;
import com.taxiPark.submenu.commands.ClearSelection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class EditCarData {

    Car tempCar;

    private static final Logger logger = LoggerFactory.getLogger(EditCarData.class);

    public void execute(Scanner scanner, Car car, List<Car> cars){
        tempCar = car;
        int command;

        while(true) {
            command = chooseChange(scanner);
            changeData(scanner, command, cars);
            logger.info("Дані авто відредаговано.");
            System.out.println();
            saveChange(scanner, cars);
            System.out.println("\n");
        }
    }

    public void showMenu(){
        System.out.print("""
                \n\t [1] - mark and model
                \t [2] - year manufacture
                \t [3] - cost
                \t [4] - color
                \t [5] - max speed
                
                \t [6] - transmission
                \t [7] - drive type
                
                \t [8] - fuel type
                \t [9] - engine type
                \t[10] - engine capacity
                \t[11] - fuel consumption for 100 km
                
                \t[12] - state
                \t[13] - security types
                \t[14] - comfort types
                
                \t[15] - save changes and show all information about car
                \t[16] - general menu
                \t [0] - exit
                
                Enter command :\t""");
    }

    public int chooseChange(Scanner scanner){

        int command;

        while(true){
            System.out.println("\nSelect a editing item :");
            showMenu();
            try {
                command = Integer.parseInt(scanner.nextLine());
                System.out.println("\n");

                if (command <= 16) {
                    logger.info("Користувач ввів команду, для зміни параметру, - "+command);
                    return command;
                } else {
                    throw new Exception();
                }
            } /*catch (ConcurrentModificationException ignored) {}*/
            catch (Exception error) {
                System.out.println("try again... 0 - 16");
                logger.error("Користувач ввів некоректний тип даних або вийшов за доступні програмні межі. Помилка ", error);
            }
        }
    }

    public void changeData(Scanner scanner, int command, List<Car> cars){

        GeneralInfo generalInfo;
        TechnicInfo technicInfo;
        FuelInfo fuelInfo;
        MoreInformation moreInformation;

        if (command != 0 && command != 15 && command != 16)
            System.out.println("Enter updating data :");

        switch (command) {
            case 0 -> {
                MenuExit exit = new MenuExit();
                exit.execute(scanner, cars);
            }

            case 1 -> {
                generalInfo = GeneralInfo.builder(tempCar.getGeneralInfo())
                        .setMarkAndModel(scanner.nextLine())
                        .build();
                tempCar.setGeneralInfo(generalInfo);
            }
            case 2 -> {
                generalInfo = GeneralInfo.builder(tempCar.getGeneralInfo())
                        .setYearManufacture(Integer.parseInt(scanner.nextLine()))
                        .build();
                tempCar.setGeneralInfo(generalInfo);
            }
            case 3 -> {
                generalInfo = GeneralInfo.builder(tempCar.getGeneralInfo())
                        .setCost(Double.parseDouble(scanner.nextLine()))
                        .build();
                tempCar.setGeneralInfo(generalInfo);
            }
            case 4 -> {
                generalInfo = GeneralInfo.builder(tempCar.getGeneralInfo())
                        .setColor(scanner.nextLine())
                        .build();
                tempCar.setGeneralInfo(generalInfo);
            }
            case 5 -> {
                generalInfo = GeneralInfo.builder(tempCar.getGeneralInfo())
                        .setMaxSpeed(Double.parseDouble(scanner.nextLine()))
                        .build();
                tempCar.setGeneralInfo(generalInfo);
            }

            case 6 -> {
                technicInfo = TechnicInfo.builder(tempCar.getTechnicInfo())
                        .setTransmission(scanner.nextLine())
                        .build();
                tempCar.setTechnicInfo(technicInfo);
            }
            case 7 -> {
                technicInfo = TechnicInfo.builder(tempCar.getTechnicInfo())
                        .setDriveType(scanner.nextLine())
                        .build();
                tempCar.setTechnicInfo(technicInfo);
            }

            case 8 -> {
                fuelInfo = FuelInfo.builder(tempCar.getFuelInfo())
                        .setFuelType(scanner.nextLine())
                        .build();
                tempCar.setFuelInfo(fuelInfo);
            }
            case 9 -> {
                fuelInfo = FuelInfo.builder(tempCar.getFuelInfo())
                        .setEngineType(scanner.nextLine())
                        .build();
                tempCar.setFuelInfo(fuelInfo);
            }
            case 10 -> {
                fuelInfo = FuelInfo.builder(tempCar.getFuelInfo())
                        .setEngineCapacity(Double.parseDouble(scanner.nextLine()))
                        .build();
                tempCar.setFuelInfo(fuelInfo);
            }
            case 11 -> {
                fuelInfo = FuelInfo.builder(tempCar.getFuelInfo())
                        .setFuelConsumptionFor100km(Double.parseDouble(scanner.nextLine()))
                        .build();
                tempCar.setFuelInfo(fuelInfo);
            }

            case 12 -> {
                moreInformation = MoreInformation.builder(tempCar.getMoreInformation())
                        .setState(scanner.nextLine())
                        .build();
                tempCar.setMoreInformation(moreInformation);
            }
            case 13 -> {
                moreInformation = MoreInformation.builder(tempCar.getMoreInformation())
                        .setSecurityTypes(scanner.nextLine())
                        .build();
                tempCar.setMoreInformation(moreInformation);
            }
            case 14 -> {
                moreInformation = MoreInformation.builder(tempCar.getMoreInformation())
                        .setComfortTypes(scanner.nextLine())
                        .build();
                tempCar.setMoreInformation(moreInformation);
            }

            case 15 -> {
                MenuSelectCarByID showInfo = new MenuSelectCarByID();
                showInfo.showCarAndOption(scanner, tempCar.getCarID(), cars);
            }
            case 16 -> {
                MainMenuTaxiPark mainMenuTaxiPark = new MainMenuTaxiPark();
                mainMenuTaxiPark.openTaxiParkProgramme(scanner, cars);
            }
        }
    }

    public void saveChange(Scanner scanner, List<Car> cars){
        MenuSelectCarByID menuSelectCarByID = new MenuSelectCarByID();
        menuSelectCarByID.deleteFileCar(tempCar);

        AddingNewCarByWrite addingNewCarByWrite = new AddingNewCarByWrite();
        addingNewCarByWrite.addNewCarToFile(tempCar);
        logger.info("Зміни збережено.");


        ClearSelection clearSelection = new ClearSelection();
        clearSelection.execute(scanner, cars);
    }
}
