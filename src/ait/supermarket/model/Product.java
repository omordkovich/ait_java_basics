package ait.supermarket.model;

import java.util.Objects;

public class Product {
    public static final int BARCODE_LENGTH = 20;
    private final String barcode;
    private final String name;
    private double price;

    public Product(String barcode, String name, double price) {
        this.barcode = checkBarcode(barcode);
        this.name = name;
        this.price = price;
    }

    private String checkBarcode(String barcode) {
        if (barcode.length() == BARCODE_LENGTH) {
            return barcode;
        }
        return "-1";
    }


    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product product)) return false;
        return Objects.equals(barcode, product.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barcode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append(", barcode: ").append(barcode).append(", price: ").append(price).append("€");
        return sb.toString();
    }
}