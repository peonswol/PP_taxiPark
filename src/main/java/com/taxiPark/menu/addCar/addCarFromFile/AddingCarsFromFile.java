package com.taxiPark.menu.addCar.addCarFromFile;

import com.taxiPark.Color;
import com.taxiPark.WorkWithFile;
import com.taxiPark.park.car.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AddingCarsFromFile {

    private static final Logger logger = LoggerFactory.getLogger(AddingCarsFromFile.class);

    WorkWithFile workWithFile = new WorkWithFile();
    public void addCarsFromFile(List<Car> cars){
        downloadCars();
        add(cars);
    }

    protected void add(List<Car> cars){
        workWithFile.addCars(cars);
        logger.info("Додано машини з файлів, якщо такі існують.");
    }

    protected void downloadCars(){
        System.out.println("Please wait, we are loading cars from the database");
        //for (int i = 0; i < 10; i++){
        System.out.print(Color.GREEN+"----------"+Color.ANSI_RESET);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        //}
    }
}
