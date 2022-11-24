package com.taxiPark.menu.addCar.addNewCar;

import com.taxiPark.WorkWithFile;
import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;
import com.taxiPark.submenu.commands.ClearSelection;

import java.util.List;
import java.util.Scanner;

public class AddingNewCarByWrite {

    protected String markAndModel;
    protected int yearManufacture;
    protected double cost;
    protected String color;
    protected double maxSpeed;

    protected String transmission; //коробка передач
    protected String driveType; //тип приводу

    protected String fuelType; // тип пального

    protected String engineType; //тип двигуна
    protected double engineCapacity; //об'єм баку
    protected double fuelConsumptionFor100km; // витрати пального

    protected String state; //стан
    protected String securityTypes; //other information
    protected String comfortTypes;

    protected WorkWithFile workWithFile = new WorkWithFile();
    protected ClearSelection clearSelection = new ClearSelection();

    public void add(Scanner scanner, List<Car> cars){

        initCarData(scanner);
        Car car = createNewCar();

        callAddingCarToFileAndList(scanner, cars, car);
    }

    public void callAddingCarToFileAndList(Scanner scanner, List<Car> cars, Car car){
        cars.add(car);
        addNewCarToFile(car);

        clearSelection.execute(scanner, cars);
    }
    protected void initCarData(Scanner scanner){
        initGeneralInfo(scanner);
        initTechnicInfo(scanner);
        initFuelInfo(scanner);
        initMoreInformation(scanner);
    }
    protected void initGeneralInfo(Scanner scanner){
        System.out.print("\n* Entering general information *");

        System.out.print("\n\tEnter car's mark and model :\n\t\t");
        markAndModel = scanner.nextLine();

        System.out.print("\n\tEnter car's year graduation :\n\t\t");
        yearManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("\n\tEnter car's cost :\n\t\t");
        cost = Double.parseDouble(scanner.nextLine());

        System.out.print("\n\tEnter car's color :\n\t\t");
        color = scanner.nextLine();

        System.out.print("\n\tEnter car's max speed :\n\t\t");
        maxSpeed = Double.parseDouble(scanner.nextLine());}
    protected void initTechnicInfo(Scanner scanner){
        System.out.print("\n* Entering technical information *");
        System.out.print("\n\tEnter car's transmission :\n\t\t");
        transmission = scanner.nextLine();
        System.out.print("\n\tEnter car's drive type :\n\t\t");
        driveType = scanner.nextLine();
    }
    protected void initFuelInfo(Scanner scanner){
        System.out.print("\n* Entering fuel information *");
        System.out.print("\n\tEnter car's fuel type :\n\t\t");
        fuelType = scanner.nextLine();
        System.out.print("\n\tEnter car's engine type :\n\t\t");
        engineType = scanner.nextLine();
        System.out.print("\n\tEnter car's engine capacity :\n\t\t");
        engineCapacity = Double.parseDouble(scanner.nextLine());
        System.out.print("\n\tEnter car's fuel consumption for 100 km :\n\t\t");
        fuelConsumptionFor100km = Double.parseDouble(scanner.nextLine());
    }
    protected void initMoreInformation(Scanner scanner){
        System.out.print("\n* Entering more information *");
        System.out.print("\n\tEnter car's state :\n\t\t");
        state = scanner.nextLine();
        System.out.print("\n\tEnter car's security types :\n\t\t");
        securityTypes = scanner.nextLine();

        System.out.print("\n\tEnter car's comfortTypes :\n\t\t");
        comfortTypes = scanner.nextLine();
    }

    protected GeneralInfo createNewGeneralInfo(){

        return GeneralInfo.builder()
                .setMarkAndModel(markAndModel)
                .setYearManufacture(yearManufacture)
                .setCost(cost)
                .setColor(color)
                .setMaxSpeed(maxSpeed)
                .build();
    }

    protected TechnicInfo createNewTechnicInfo(){
        return TechnicInfo.builder()
                .setTransmission(transmission)
                .setDriveType(driveType)
                .build();
    }

    protected FuelInfo createNewFuelInfo(){
        return FuelInfo.builder()
                .setFuelType(fuelType)
                .setEngineType(engineType)
                .setEngineCapacity(engineCapacity)
                .setFuelConsumptionFor100km(fuelConsumptionFor100km)
                .build();
    }

    protected MoreInformation createNewMoreInformation(){
        return MoreInformation.builder()
                .setState(state)
                .setSecurityTypes(securityTypes)
                .setComfortTypes(comfortTypes)
                .build();
    }

    protected Car createNewCar() {

        GeneralInfo generalInfo = createNewGeneralInfo();

        TechnicInfo technicInfo = createNewTechnicInfo();

        FuelInfo fuelInfo = createNewFuelInfo();

        MoreInformation moreInformation = createNewMoreInformation();

        return new Car(generalInfo, technicInfo, fuelInfo, moreInformation);
    }

    public void addNewCarToFile(Car car){
        workWithFile.writeObjToFile(car, car.getCarID());
    }
}
