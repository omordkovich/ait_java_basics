package ait.supermarket.test;


import ait.supermarket.dao.Supermarket;
import ait.supermarket.dao.SupermarketImpl;
import ait.supermarket.model.Food;
import ait.supermarket.model.MeatFood;
import ait.supermarket.model.MilkFood;
import ait.supermarket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplTest {
    Supermarket supermarket;
    Product[] products;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketImpl(5);
        products = new Product[4];
        products[0] = new MeatFood("11111111111111111111", "Beef", 5.99, LocalDate.of(2024, 10, 10), "Young bull");
        products[1] = new MilkFood("11111111111111111112", "Milk", 1.59, LocalDate.of(2024, 8, 9), "Vollmilch", 3.8);
        products[2] = new Food("11111111111111111113", "Apples", 2.99, LocalDate.of(2024, 8, 9));
        products[3] = new Product("11111111111111111114", "Batman action figure", 13.99);

        for (int i = 0; i < products.length; i++) {
            supermarket.addProduct(products[i]);
        }
    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(products[0]));
        Product product = new Product("11111111111111111115", "Heman action figure", 13.99);
        assertTrue(supermarket.addProduct(product));
        product = new Product("11111111111111111118", "Videogame", 25.99);

        assertFalse(supermarket.addProduct(product));
    }

    @Test
    void removeProduct() {
    }

    @Test
    void findProductByBarcode() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void findProductByExpirationDate() {
        Product[] expected = {products[1], products[2]};
        System.out.println(products);
        Product[] actual = supermarket.findProductByExpirationDate(LocalDate.of(2024, 8, 9));
        assertArrayEquals(expected, actual);
    }

    @Test
    void totalCost() {
    }

    @Test
    void averageCost() {
    }
}