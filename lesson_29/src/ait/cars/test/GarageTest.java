package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    Garage garage;
    Car[] cars;


    @BeforeEach
    void setUp() {
        garage = new GarageImpl(4);
        cars = new Car[3];
        cars[0] = new Car("BD51SMR", "Qashqai", "Nissan", 116, "black");
        cars[1] = new Car("OJ11BML", "M2", "BMW", 460, "black");
        cars[2] = new Car("MF39PTV", "Mustang", "Ford", 351, "red");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);

        }

    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[1]));
        Car car =  new Car("FM93PTV", "Mustang", "Ford", 351, "blue");
        assertTrue(garage.addCar(car));
        assertEquals(4, garage.quantity());
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        assertEquals(cars[1], garage.removeCar("OJ11BML"));
        assertEquals(2, garage.quantity());
        assertNull(garage.removeCar("OJ11BML"));
    }

    @Test
    void findCarByRegNumber() {
        assertEquals(cars[2], garage.findCarByRegNumber("MF39PTV"));
        assertNull(garage.findCarByRegNumber("MM88TTT"));
    }

    @Test
    void findCarsByModel() {
        Car[] actual = garage.findCarsByModel("Mustang");
        Car[] expected = {cars[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByCompany() {
        Car[] actual = garage.findCarsByCompany("BMW");
        Car[] expected = {cars[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] actual = garage.findCarsByEngine(200, 470);
        Car[] expected = {cars[1], cars[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        Car[] actual = garage.findCarsByColor("black");
        Car[] expected = {cars[0], cars[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void quantity(){
        assertEquals(3, garage.quantity());
    }
}