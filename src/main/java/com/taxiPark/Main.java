package com.taxiPark;

import com.taxiPark.menu.MainMenuTaxiPark;
import com.taxiPark.menu.addCar.addCarFromFile.AddingCarsFromFile;
import com.taxiPark.park.AutoPark;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        Scanner scanner = new Scanner(System.in);

        AddingCarsFromFile addCarsFromFile = new AddingCarsFromFile();
        addCarsFromFile.addCarsFromFile(AutoPark.getCars());

        MainMenuTaxiPark taxiPark = new MainMenuTaxiPark();
        taxiPark.openTaxiParkProgramme(scanner, AutoPark.getCars());
    }
}
