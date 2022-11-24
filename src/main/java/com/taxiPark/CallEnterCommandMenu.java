package com.taxiPark;

import java.util.Scanner;

public class CallEnterCommandMenu {

    public int enterCommandCheckException(Scanner scanner, int size) {
        while (true) {
            try {
                return enterCommand(scanner, size);

            } catch (NumberFormatException error) {
                System.out.println("try again... 0 - " + size);
            }
        }
    }

    public int enterCommand(Scanner scanner, int size){

        int command = Integer.parseInt(scanner.nextLine());
        System.out.println("\n");

        if (command < size) {
            return command;
        }

        else throw new NumberFormatException();
    }


}
