package com.taxiPark.menu.addCar.addNewCar;

import com.taxiPark.WorkWithFile;
import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;
import com.taxiPark.submenu.commands.ClearSelection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddingNewCarByWriteTest extends AddingNewCarByWrite{

    AddingNewCarByWrite addingNewCarByWrite = new AddingNewCarByWrite();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        addingNewCarByWrite.workWithFile = Mockito.mock(WorkWithFile.class);
        addingNewCarByWrite.clearSelection = Mockito.mock(ClearSelection.class);
    }

    @Test
    void testCallAddingCarToFileAndList() {
        List<Car> cars = new ArrayList<>();

        Car car = Mockito.mock(Car.class);

        doNothing().when(addingNewCarByWrite.clearSelection).execute(new Scanner(System.in), cars);
        when(addingNewCarByWrite.workWithFile.writeObjToFile(car, car.getCarID())).thenReturn(true);

        addingNewCarByWrite.callAddingCarToFileAndList(new Scanner(System.in), cars, car);

        assertEquals(1, cars.size());
    }

    @Test
    void testInitGeneralInfo() {
        System.setIn(new ByteArrayInputStream("mark\n1\n1.1\ncolor\n1.1\n".getBytes()));
        addingNewCarByWrite.initGeneralInfo(new Scanner(System.in));

        assertEquals("mark", addingNewCarByWrite.markAndModel);
        assertEquals(1, addingNewCarByWrite.yearManufacture);
        assertEquals(1.1, addingNewCarByWrite.cost);
        assertEquals("color", addingNewCarByWrite.color);
        assertEquals(1.1, addingNewCarByWrite.maxSpeed);

    }

    @Test
    void testInitTechnicInfo() {
        System.setIn(new ByteArrayInputStream("transmission\ndriveType\n".getBytes()));
        addingNewCarByWrite.initTechnicInfo(new Scanner(System.in));

        assertEquals("transmission", addingNewCarByWrite.transmission);
        assertEquals("driveType", addingNewCarByWrite.driveType);
    }

    @Test
    void testInitFuelInfo() {
        System.setIn(new ByteArrayInputStream("fuelType\nengineType\n1.1\n1.1\n".getBytes()));
        addingNewCarByWrite.initFuelInfo(new Scanner(System.in));

        assertEquals("fuelType", addingNewCarByWrite.fuelType);
        assertEquals("engineType", addingNewCarByWrite.engineType);
        assertEquals(1.1, addingNewCarByWrite.engineCapacity);
        assertEquals(1.1, addingNewCarByWrite.fuelConsumptionFor100km);
    }

    @Test
    void testInitMoreInformation() {
        System.setIn(new ByteArrayInputStream("state\nsecurityTypes\ncomfortTypes\n".getBytes()));
        addingNewCarByWrite.initMoreInformation(new Scanner(System.in));

        assertEquals("state", addingNewCarByWrite.state);
        assertEquals("securityTypes", addingNewCarByWrite.securityTypes);
        assertEquals("comfortTypes", addingNewCarByWrite.comfortTypes);
    }

    @Test
    void testCreateNewGeneralInfo() {

        GeneralInfo generalInfoActual = addingNewCarByWrite.createNewGeneralInfo();
        assertEquals("GeneralInfo", generalInfoActual.getClass().getSimpleName());
    }

    @Test
    void testCreateNewTechnicInfo() {

        TechnicInfo technicInfoActual = addingNewCarByWrite.createNewTechnicInfo();
        assertEquals("TechnicInfo", technicInfoActual.getClass().getSimpleName());
 }

    @Test
    void testCreateNewFuelInfo() {
        FuelInfo fuelInfoActual = addingNewCarByWrite.createNewFuelInfo();
        assertEquals("FuelInfo", fuelInfoActual.getClass().getSimpleName());
    }

    @Test
    void testCreateNewMoreInformation() {

        MoreInformation moreInformationActual = addingNewCarByWrite.createNewMoreInformation();
        assertEquals("MoreInformation", moreInformationActual.getClass().getSimpleName());
    }

    @Test
    void testCreateNewCar() {

        Car actualCar = createNewCar();

        assertEquals("GeneralInfo", actualCar.getGeneralInfo().getClass().getSimpleName());
        assertEquals("TechnicInfo", actualCar.getTechnicInfo().getClass().getSimpleName());
        assertEquals("FuelInfo", actualCar.getFuelInfo().getClass().getSimpleName());
        assertEquals("MoreInformation", actualCar.getMoreInformation().getClass().getSimpleName());
    }

    @Test
    void testAddNewCarToFile() {
        //todo
        //verify(workWithFile, times(1).writeObjToFile);
    }

    @Test
    void testInitCarData() {
    }
}