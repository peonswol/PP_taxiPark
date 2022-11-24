package com.taxiPark.submenu.filtering;

import com.taxiPark.park.car.Car;

import java.util.List;
import java.util.Scanner;

public abstract class ATypeFiltering {

    public List<Car> cars;

    public void execute(Scanner scanner, List<Car> cars) {
        this.cars = cars;
        enterLimitation(scanner);
        filter();
    }

    public void enterLimitation(Scanner scanner){

    }

    public void filter(){

    }
}
