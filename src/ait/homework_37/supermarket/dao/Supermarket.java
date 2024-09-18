package ait.homework_37.supermarket.dao;

import ait.homework_37.supermarket.model.Product;

public interface Supermarket {
    boolean addProduct(Product product);

    Product removeProduct(long barCode);

    Product findByBarCode(long barCode);

    Iterable<Product> findByCategory(String category);

    Iterable<Product> findByBrand(String brand);

    Iterable<Product> findProductsWithExpiredDate();

    int skuQuantity();

    void printAllProducts();

}
