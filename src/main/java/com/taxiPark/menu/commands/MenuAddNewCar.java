package com.taxiPark.menu.commands;

import com.taxiPark.menu.addCar.addNewCar.AddingNewCarByWrite;
import com.taxiPark.park.car.Car;

import java.util.List;
import java.util.Scanner;

public class MenuAddNewCar implements IMenuExecute {

    protected AddingNewCarByWrite newCar = new AddingNewCarByWrite();

    @Override
    public void execute(Scanner scanner, List<Car> cars){
        System.out.println("Here you can add new car ᓚᘏᗢ");
        newCar.add(scanner, cars);
    }
}
