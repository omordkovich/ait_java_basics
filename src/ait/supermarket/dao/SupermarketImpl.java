package ait.supermarket.dao;

import ait.supermarket.model.Food;
import ait.supermarket.model.Product;

import java.time.LocalDate;

public class SupermarketImpl implements Supermarket {
    Product[] products;
    int size;

    public SupermarketImpl(int capacity) {
        this.products = new Product[capacity];
    }


    @Override
    public boolean addProduct(Product product) {
        if (product == null || size == products.length || findProductByBarcode(product.getBarcode()) != null) {
            return false;
        }
        products[size++] = product;
        return true;
    }

    @Override
    public Product removeProduct(String barcode) {
        Product victim = null;
        for (int i = 0; i < size; i++) {
            if (products[i].getBarcode().equals(barcode)) {
                victim = products[i];
                products[size - 1] = null;
                size--;
                break;
            }
        }
        return victim;
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarcode().equals(barcode)) {
                return products[i];
            }
        }
        return null;

    }

    @Override
    public Product updateProduct(String barcode, double price) {
        Product update = null;
        for (int i = 0; i < size; i++) {
            if (products[i].getBarcode().equals(barcode)) {
                products[i].setPrice(price);
                update = products[i];
            }
        }
        return update;
    }

    @Override
    public Product[] findProductByExpirationDate(LocalDate date) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] instanceof Food food) {
                if (food.getExpDate().equals(date)) {
                    count++;
                }
            }
        }
        Product[] myProducts = new Product[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (products[i] instanceof Food food) {
                if (food.getExpDate().equals(date)) {
                    myProducts[j++] = products[i];
                }
            }
        }
        return myProducts;
    }

    @Override
    public double totalCost() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            res += products[i].getPrice();
        }
        return res;
    }

    @Override
    public double averageCost() {
        return totalCost() / size;
    }
}
