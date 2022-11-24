package com.taxiPark.menu.addCar.addCarFromFile;

import com.taxiPark.WorkWithFile;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddingCarsFromFileTest extends TestCase {

    AddingCarsFromFile addingCarsFromFile = new AddingCarsFromFile();

    private final PrintStream standardOut = System.out; // new PrintStream(byteArrayOutputStream);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }
    /*@Test
    void addCarsFromFile() {
    }*/

    @Test
    void add() {
        addingCarsFromFile.workWithFile = Mockito.mock(WorkWithFile.class);

        doNothing().when(addingCarsFromFile.workWithFile).addCars(null);

        addingCarsFromFile.add(null);

        verify(addingCarsFromFile.workWithFile, times(1)).addCars(null);
    }

    @Test
    void downloadCars() {
    }
}