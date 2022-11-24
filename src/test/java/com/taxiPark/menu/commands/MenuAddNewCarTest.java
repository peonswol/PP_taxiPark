package com.taxiPark.menu.commands;

import com.taxiPark.menu.addCar.addNewCar.AddingNewCarByWrite;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuAddNewCarTest extends MenuAddNewCar {

    MenuAddNewCar menuAddNewCar = new MenuAddNewCar();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        menuAddNewCar.newCar = mock(AddingNewCarByWrite.class);
    }

    @Test
    void testExecute() {
        Scanner scanner = new Scanner(System.in);

        doNothing().when(menuAddNewCar.newCar).add(scanner, null);
        menuAddNewCar.execute(scanner, null);
        verify(menuAddNewCar.newCar, timeout(1)).add(scanner, null);
    }
}