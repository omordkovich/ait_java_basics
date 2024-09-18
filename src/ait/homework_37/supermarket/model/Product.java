package ait.homework_37.supermarket.model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private long barCode;
    private String name;
    private String category;
    private String brand;
    private double price;
    private LocalDate date;

    public Product(long barCode, String name, String category, String brand, double price, LocalDate date) {
        this.barCode = barCode;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return barCode == product.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barCode);
    }

    public long getBarCode() {
        return barCode;
    }


    public String getCategory() {
        return category;
    }


    public String getBrand() {
        return brand;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("barCode=").append(barCode);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
