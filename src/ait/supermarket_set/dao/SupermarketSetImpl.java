package ait.supermarket_set.dao;

import ait.supermarket_set.model.Food;
import ait.supermarket_set.model.Product;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupermarketSetImpl implements Supermarket {
    Set<Product> products;

    public SupermarketSetImpl() {
        this.products = new HashSet<>();
    }

    public SupermarketSetImpl(List<Product> products) {
        this();
        products.forEach(this::addProduct);
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null || products.contains(product)) {
            return false;
        }
        products.add(product);
        return true;
    }

    @Override
    public Product removeProduct(String barcode) {
        Product victim = findProductByBarcode(barcode);
        if (products.contains(victim) && victim != null) {
            products.remove(victim);
            return victim;
        } else {
            return null;
        }
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        return products.stream()
                .filter(p -> p.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product updateProduct(String barcode, double price) {
        return products.stream()
                .filter(p -> p.getBarcode().equals(barcode))
                .findFirst()
                .map(p -> {
                    p.setPrice(price);
                    return p;
                })
                .orElse(null);
    }

    @Override
    public Iterable<Product> findProductByExpirationDate(LocalDate date) {
        return products.stream()
                .filter(p -> p instanceof Food && ((Food) p).getExpDate().equals(date))
                .toList();
    }


    @Override
    public double totalCost() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .summaryStatistics()
                .getSum();
    }

    @Override
    public double averageCost() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .summaryStatistics()
                .getAverage();
    }

    @Override
    public Iterable<Product> findOutOfDate(LocalDate date) {
        return products.stream()
                .filter(p -> p instanceof Food && ((Food) p).getExpDate().isBefore(date))
                .toList();
    }


    @Override
    public int size() {
        return products.size();
    }
}
