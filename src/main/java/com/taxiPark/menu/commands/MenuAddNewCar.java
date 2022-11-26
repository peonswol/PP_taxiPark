package com.taxiPark.menu.commands;

import com.taxiPark.menu.addCar.addNewCar.AddingNewCarByWrite;
import com.taxiPark.park.car.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class MenuAddNewCar implements IMenuExecute {

    protected AddingNewCarByWrite newCar = new AddingNewCarByWrite();

    private static final Logger logger = LoggerFactory.getLogger(MenuAddNewCar.class);


    @Override
    public void execute(Scanner scanner, List<Car> cars){
        System.out.println("Here you can add new car ᓚᘏᗢ");
        newCar.add(scanner, cars);
        logger.info("Нове авто додано.");

    }
}
