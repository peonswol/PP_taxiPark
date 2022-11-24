package com.taxiPark.submenu.filtering;

import java.util.Scanner;

public class FilterByYear extends ATypeFiltering {

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void filter() {

        cars.removeIf(car -> car.getGeneralInfo().getYearManufacture() > end
                || car.getGeneralInfo().getYearManufacture() < start);
    }

    @Override
    public void enterLimitation(Scanner scanner) {
        System.out.println("\nEnter year limits cars for filtering :\n");

        System.out.print("Enter start :\t");
        start = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter end :\t");
        end = Integer.parseInt(scanner.nextLine());
    }
}
