package ait.homework_29.car_garage_v2.dao;

import ait.homework_29.car_garage_v2.model.Car;

public interface Garage {
    boolean addCar(Car car);

    Car removeCar(String regNumber);

    Car findCarByRegNumber(String regNumber);

    Car[] findCarByModel(String model);

    Car[] findCarByCompany(String company);

    Car[] findCarByEngine(double min, double max);

    Car[] findCarByColor(String color);

    Car[] sortByCompany();

    Car[] sortByModel();

    Car[] sortByColor();

}
