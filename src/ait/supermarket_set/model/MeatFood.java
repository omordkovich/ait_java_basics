package ait.supermarket_set.model;

import java.time.LocalDate;
import java.util.Objects;

public class MeatFood extends Food {
    private String meatType;

    public MeatFood(String barcode, String name, double price, LocalDate expDate, String meatType) {
        super(barcode, name, price, expDate);
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", meatType: " + meatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeatFood meatFood)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(meatType, meatFood.meatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meatType);
    }
}
