package ait.homework_27.cars_sorting;

import java.util.Objects;

//бренд, цвет, стоимость, год выпуска
public class Car implements Comparable<Car> {
    private String brand;
    private String color;
    private double price;
    private int yearOfRegistration;

    public Car(String brand, String color, double price, int yearOfRegistration) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(int yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car car)) return false;
        return Double.compare(price, car.price) == 0 && yearOfRegistration == car.yearOfRegistration && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price, yearOfRegistration);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", price=").append(price);
        sb.append(", yearOfRegistration=").append(yearOfRegistration);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Car o) {
        if (this.getYearOfRegistration() == o.getYearOfRegistration()) {
            return Double.compare (this.getPrice(), o.getPrice());
        } else {
            return this.getYearOfRegistration() - o.getYearOfRegistration();
        }
    }
}
