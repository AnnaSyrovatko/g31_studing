package ait.cars.dao;

import ait.cars.model.Car;

import java.util.function.Predicate;

public class ModelsPredicate implements Predicate<Car> {

    private String model;

    public ModelsPredicate(String model) {
        this.model = model;
    }

    @Override
    public boolean test(Car car) {
        return car.getModel().equals(model);
    }
}
