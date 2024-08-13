package ait.homework_27.cars_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CarTest {
    Car[] cars;

    @BeforeEach
    void setUp() {
        cars = new Car[5];
        cars[0] = new Car("Brand1", "Green", 15000, 2017);
        cars[1] = new Car("Brand2", "Black", 25000, 2024);
        cars[2] = new Car("Brand3", "Grey", 7000, 2009);
        cars[3] = new Car("Brand1", "Metallic", 12000, 2017);
        cars[4] = new Car("Brand2", "White", 15000, 2010);
    }

    @Test
    void sortCarsByYearThanPrice() {
        printArray(cars);
        Arrays.sort(cars);
        printArray(cars);
    }

    @Test
    void sortCarsByPriceThanYear() {
        printArray(cars);

        Comparator<Car> comparatorByPriceThanYear = new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getPrice() == o2.getPrice()) {
                    return o1.getYearOfRegistration() - o2.getYearOfRegistration();
                } else {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            }
        };
        Arrays.sort(cars, comparatorByPriceThanYear);
        printArray(cars);

    }

    @Test
    void sortCarsByBrandThanColor() {
        printArray(cars);

        Comparator<Car> comparatorByBrandThanColor = new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getBrand().equals(o2.getBrand())) {
                    return o1.getColor().compareTo(o2.getColor());
                }
                return o1.getBrand().compareTo(o2.getBrand());
            }
        };
        Arrays.sort(cars, comparatorByBrandThanColor);
        printArray(cars);

    }

    private void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------------------------------------------------------------------------");
    }
}