package ait.supermarket.dao;

import ait.supermarket.model.Product;

import java.time.LocalDate;

public interface Supermarket {
    boolean addProduct(Product product);

    Product removeProduct(String barcode);

    Product findProductByBarcode(String barcode);

    Product updateProduct(String barcode, double price);

    Product[] findProductByExpirationDate(LocalDate date);

    double totalCost();

    double averageCost();

    Product[] findOutOfDate(LocalDate date);
}
