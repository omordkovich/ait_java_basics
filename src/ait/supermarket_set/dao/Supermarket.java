package ait.supermarket_set.dao;

import ait.supermarket_set.model.Product;

import java.time.LocalDate;

public interface Supermarket {
    boolean addProduct(Product product);

    Product removeProduct(String barcode);

    Product findProductByBarcode(String barcode);

    Product updateProduct(String barcode, double price);

    Iterable<Product> findProductByExpirationDate(LocalDate date);

    double totalCost();

    double averageCost();

    Iterable<Product> findOutOfDate(LocalDate date);

    int size();
}


