package com.taxiPark.menu.editCarData;

import com.taxiPark.park.car.Car;
import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class EditCarDataTest extends TestCase {

    EditCarData editCarData = new EditCarData();

    @BeforeEach
    public void setUp(){
        editCarData.tempCar = new Car(new GeneralInfo(), new TechnicInfo(), new FuelInfo(), new MoreInformation());
    }

    @Test
    void testChooseChangeMark() {
        String enteredCommand = "2\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        int actualCommand = editCarData.chooseChange(new Scanner(System.in));
        assertEquals(2, actualCommand);
    }

    @Test
    public void testChangeDataMark() {

        String enteredCommand = "mark\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 1, null);
        assertEquals("mark", editCarData.tempCar.getGeneralInfo().getMarkAndModel());
    }

    @Test
    public void testChangeDataYear() {

        String enteredCommand = "1\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 2, null);
        assertEquals(1, editCarData.tempCar.getGeneralInfo().getYearManufacture());
    }

    @Test
    public void testChangeDataCost() {

        String enteredCommand = "1.1\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 3, null);
        assertEquals(1.1, editCarData.tempCar.getGeneralInfo().getCost());
    }

    @Test
    public void testChangeDataColor() {

        String enteredCommand = "color\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 4, null);
        assertEquals("color", editCarData.tempCar.getGeneralInfo().getColor());
    }

    @Test
    public void testChangeDataMaxSpeed() {

        String enteredCommand = "1.1\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 5, null);
        assertEquals(1.1, editCarData.tempCar.getGeneralInfo().getMaxSpeed());
    }

    @Test
    public void testChangeDataTransmission() {

        String enteredCommand = "transmission\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 6, null);
        assertEquals("transmission", editCarData.tempCar.getTechnicInfo().getTransmission());
    }

    @Test
    public void testChangeDataDriveType() {

        String enteredCommand = "driveType\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 7, null);
        assertEquals("driveType", editCarData.tempCar.getTechnicInfo().getDriveType());
    }

    @Test
    public void testChangeDataFuelType() {

        String enteredCommand = "fuelType\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 8, null);
        assertEquals("fuelType", editCarData.tempCar.getFuelInfo().getFuelType());
    }

    @Test
    public void testChangeDataEngineType() {

        String enteredCommand = "engineType\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 9, null);
        assertEquals("engineType", editCarData.tempCar.getFuelInfo().getEngineType());
    }

    @Test
    public void testChangeDataEngineCapacity() {

        String enteredCommand = "1.1\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 10, null);
        assertEquals(1.1, editCarData.tempCar.getFuelInfo().getEngineCapacity());
    }

    @Test
    public void testChangeDataFuelConsumptionFor100km() {

        String enteredCommand = "1.1\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 11, null);
        assertEquals(1.1, editCarData.tempCar.getFuelInfo().getFuelConsumptionFor100km());
    }

    @Test
    public void testChangeDataState() {

        String enteredCommand = "state\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 12, null);
        assertEquals("state", editCarData.tempCar.getMoreInformation().getState());
    }

    @Test
    public void testChangeDataSecurityTypes() {

        String enteredCommand = "securityTypes\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 13, null);
        assertEquals("securityTypes", editCarData.tempCar.getMoreInformation().getSecurityTypes());
    }

    @Test
    public void testChangeDataComfortTypes() {

        String enteredCommand = "comfortTypes\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));

        editCarData.changeData(new Scanner(System.in), 14, null);
        assertEquals("comfortTypes", editCarData.tempCar.getMoreInformation().getComfortTypes());
    }

    @Test
    public void testSaveChange() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testShowMenu() {
    }
}