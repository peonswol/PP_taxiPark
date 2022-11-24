package com.taxiPark.menu.commands;

import com.taxiPark.park.car.Car;

import java.util.List;
import java.util.Scanner;

public interface IMenuExecute {

    void execute(Scanner scanner, List<Car> cars);
}
