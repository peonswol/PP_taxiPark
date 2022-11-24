package com.taxiPark;

import com.taxiPark.park.AutoPark;
import com.taxiPark.park.car.Car;

import java.io.*;
import java.util.List;

public class WorkWithFile {

    private final File appFolder = new File((new File(System.getProperty("user.home") + "\\AppData\\Local\\TaxiPark")).getAbsolutePath());
    private final File[] files = appFolder.listFiles();

    public boolean writeObjToFile(Object obj, long ID) {

        try {

            if (!appFolder.exists()){
                if (appFolder.mkdir()){
                    System.out.println("Folder successful created");
                }
            }

            File fileWrite = new File(String.format(appFolder.getAbsolutePath() + "\\Car%d.dat", ID));

            if (fileWrite.createNewFile()) {
                System.out.println("File created: " + fileWrite.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileOutputStream fileOut = new FileOutputStream(fileWrite);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("The Car was successfully written to a file");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Car readObjFromFile(File file) {

        Car car;
        try {

            FileInputStream fileRead = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileRead);
            car = (Car) objectInputStream.readObject();

            objectInputStream.close();
            fileRead.close();
        } catch (Exception exception) {
            System.out.println("\nError reading file\n\n");
            return null;
        }
        return car;
    }

    public void addCars(List<Car> cars){
        if (files == null){
            System.out.println("\nThe folder cannot be found\n\n");
            return ;
        }

        int kstFiles = 0;
        for (File file : files)
            if (file.isFile()) kstFiles++;

        if (kstFiles == 0){
            System.out.println("\nNo files found\n\n");
            return ;
        }

        for (File file: files){
            if(file.isFile()){
                Car car = readObjFromFile(file);
                if (car != null) {
                    cars.add(car);
                    Car.setKstCar(Car.getKstCar()+1);
                }
            }
        }
    }

    public boolean deleteFileCar(Car car){
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(String.format("Car%d.dat", car.getCarID()))) {
                    return file.delete();
                }
            }
        }
        return false;
    }
}

