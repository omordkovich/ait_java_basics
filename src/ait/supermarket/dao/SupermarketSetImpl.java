package ait.supermarket.dao;

import ait.supermarket.model.Product;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SupermarketSetImpl implements Supermarket {
    Set<Product> products;

    public SupermarketSetImpl() {
        this.products = new HashSet<>();
    }

    public SupermarketSetImpl(Set<Product> products) {
        this();
        products.forEach(this::addProduct);
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null || findProductByBarcode(product.getBarcode()) != null) {
            return false;
        }
        products.add(product);
        return true;
    }

    @Override
    public Product removeProduct(String barcode) {

        return null;
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        return null;
    }

    @Override
    public Product updateProduct(String barcode, double price) {
        return null;
    }

    @Override
    public Product[] findProductByExpirationDate(LocalDate date) {
        return new Product[0];
    }

    @Override
    public double totalCost() {
        return 0;
    }

    @Override
    public double averageCost() {
        return 0;
    }

    @Override
    public Product[] findOutOfDate(LocalDate date) {
        return new Product[0];
    }
}
