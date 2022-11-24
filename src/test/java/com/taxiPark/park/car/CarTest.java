package com.taxiPark.park.car;

import com.taxiPark.park.car.component.FuelInfo;
import com.taxiPark.park.car.component.GeneralInfo;
import com.taxiPark.park.car.component.MoreInformation;
import com.taxiPark.park.car.component.TechnicInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class CarTest extends TestCase {

    Car car;

    private final PrintStream standardOut = System.out; // new PrintStream(byteArrayOutputStream);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
        Car.setKstCar(0);
        car = new Car(new GeneralInfo(), new TechnicInfo(), new FuelInfo(), new MoreInformation());

    }

    @Test
    public void toListString() {

        assertEquals("| №1     \t| null              | 0                | 0,00               | null              | 0,00      | --- | null        | 0,00            | 0,00             ", car.toListString());
    }

    @Test
    public void testConstructor(){
        assertEquals(1, Car.getKstCar());
    }
}