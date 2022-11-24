package com.taxiPark.park;

import com.taxiPark.park.car.Car;

import java.util.ArrayList;
import java.util.List;

public class AutoPark {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> getCars(){
        return cars;
    }
}
