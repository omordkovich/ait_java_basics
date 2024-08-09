package ait.supermarket.model;

import java.time.LocalDate;
import java.util.Objects;

public class MilkFood extends Food {
    private String milkType;
    private double fat;

    public MilkFood(String barcode, String name, double price, LocalDate expDate, String milkType, double fat) {
        super(barcode, name, price, expDate);
        this.milkType = milkType;
        this.fat = fat;
    }

    public String getMilkType() {
        return milkType;
    }

    public double getFat() {
        return fat;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", milkType: " + milkType+
                ", fat: " + fat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilkFood milkFood)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(fat, milkFood.fat) == 0 && Objects.equals(milkType, milkFood.milkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milkType, fat);
    }
}
