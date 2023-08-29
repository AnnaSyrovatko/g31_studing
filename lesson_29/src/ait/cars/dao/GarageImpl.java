package ait.cars.dao;

import ait.cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {

    private Car [] cars;

    private int size;

    public GarageImpl(int capacity){
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || findCarByRegNumber(car.getRegNumber()) != null || cars.length == size){
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car victim = cars[i];
                cars[i] = cars[--size];
                cars[size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)){
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        Predicate<Car> predicate = new ModelsPredicate(model);
        return findEmployeesByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getCompany().equals(company);
            }
        };
        return findEmployeesByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getEngine() >= min && car.getEngine() < max;
            }
        };
        return findEmployeesByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        Predicate<Car> predicate = car -> car.getColor().equals(color);
        return findEmployeesByPredicate(predicate);
    }

    private Car[] findEmployeesByPredicate(Predicate<Car> predicate){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(cars[i])){
                count++;
            }
        }
        Car [] res = new Car [count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if(predicate.test(cars[i])){
                res[j] = cars[i];
                j++;
            }
        }
        return res;
    }
}
