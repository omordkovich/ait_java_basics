package ait.homework_29.car_garage_v2.dao;

import ait.homework_29.car_garage_v2.model.Car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        this.cars = new Car[capacity];
        this.size = 0;
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
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
                System.arraycopy(cars, i + 1, cars, i, size - i - 1);
                cars[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarByModel(String model) {
        return findCarByPredicate(car -> model.equals(car.getModel()));
    }

    @Override
    public Car[] findCarByCompany(String company) {
        return findCarByPredicate(car -> company.equals(car.getCompany()));

    }

    @Override
    public Car[] findCarByEngine(double min, double max) {
        return findCarByPredicate(car -> car.getEngine() > min && car.getEngine() < max);
    }

    @Override
    public Car[] findCarByColor(String color) {
        return findCarByPredicate(car -> color.equals(car.getColor()));

    }


    private Car[] findCarByPredicate(Predicate<Car> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

    @Override
    public Car[] sortByCompany() {
        Arrays.sort(cars, Comparator.nullsLast((c1, c2) -> c1.getCompany().compareTo(c2.getCompany())));
        return cars;
    }

    @Override
    public Car[] sortByModel() {
        Arrays.sort(cars, Comparator.nullsLast((c1, c2) -> c1.getModel().compareTo(c2.getModel())));
        return cars;
    }

    @Override
    public Car[] sortByColor() {
        Arrays.sort(cars, Comparator.nullsLast((c1, c2) -> c1.getColor().compareTo(c2.getColor())));
        return cars;
    }
}
