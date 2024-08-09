package ait.supermarket.model;


import java.time.LocalDate;
import java.util.Objects;

public class Food extends Product {
    private LocalDate expDate;

    public Food(String barcode, String name, double price, LocalDate expDate) {
        super(barcode, name, price);
        this.expDate = expDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", expDate: " + expDate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Food food)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(expDate, food.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expDate);
    }
}
