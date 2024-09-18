package ait.homework_37.supermarket.dao;

import ait.homework_37.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {
    private Collection<Product> products;

    public SupermarketImpl() {
        this.products = new ArrayList<>();
    }
    public Collection<Product> getProducts() {
        return products;
    }
    @Override
    public boolean addProduct(Product product) {
        if (product == null || products.contains(product)) {
            return false;
        }
        return products.add(product);
    }


    @Override
    public Product removeProduct(long barCode) {
        Product product = findByBarCode(barCode);
        products.remove(product);
        return product;
    }

    @Override
    public Product findByBarCode(long barCode) {
        for (Product p : products) {
            if (p.getBarCode() == barCode) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findByPredicate(p -> p.getCategory().equals(category));
    }

    private Iterable<Product> findByPredicate(Predicate<Product> predicate) {
        List<Product> res = new ArrayList<>();
        for (Product p : products) {
            if (predicate.test(p)) {
                res.add(p);
            }
        }
        return res;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findByPredicate(p-> p.getBrand().equals(brand));
    }

    @Override
    public Iterable<Product> findProductsWithExpiredDate() {
        return findByPredicate(p-> p.getDate().isBefore(LocalDate.now()));
    }

    @Override
    public int skuQuantity() {
        return products.size();
    }

    @Override
    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("There is no products available!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
