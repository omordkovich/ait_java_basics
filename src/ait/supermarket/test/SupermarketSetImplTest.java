package ait.supermarket.test;

import ait.supermarket.dao.Supermarket;
import ait.supermarket.dao.SupermarketSetImpl;
import ait.supermarket.model.Food;
import ait.supermarket.model.MeatFood;
import ait.supermarket.model.MilkFood;
import ait.supermarket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class SupermarketSetImplTest {
    Supermarket supermarket;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketSetImpl(
                Set.of(
                        new MeatFood("11111111111111111111", "Beef", 5.99, LocalDate.of(2024, 10, 10), "Young bull"),
                        new MilkFood("11111111111111111112", "Milk", 1.59, LocalDate.of(2024, 8, 9), "Vollmilch", 3.8),
                        new Food("11111111111111111113", "Apples", 2.99, LocalDate.of(2024, 8, 9)),
                        new Product("11111111111111111114", "Batman action figure", 13.99))
        );
    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(new Product("11111111111111111114", "Batman action figure", 13.99)));
        Product product = new Product("11111111111111111115", "Heman action figure", 13.99);
        assertTrue(supermarket.addProduct(product));
        product = new Product("11111111111111111118", "Videogame", 25.99);

        assertFalse(supermarket.addProduct(product));
    }

    @Test
    void removeProduct() {
        Product victim = supermarket.removeProduct("11111111111111111112");
      //  assertEquals(products[1], victim);
        assertNull(supermarket.removeProduct("11111111111110000000"));
    }


    @Test
    void findProductByBarcode() {
       // assertEquals(products[1], supermarket.findProductByBarcode("11111111111111111112"));
        assertNull(supermarket.findProductByBarcode("11111111111110000002"));
    }

    @Test
    void updateProduct() {
        supermarket.updateProduct("11111111111111111114", 10.90);
     //   assertEquals(10.90, products[3].getPrice());
    }

    @Test
    void findProductByExpirationDate() {
      //  Product[] expected = {products[1], products[2]};
        Product[] actual = supermarket.findProductByExpirationDate(LocalDate.of(2024, 8, 9));
      //  assertArrayEquals(expected, actual);
    }

    @Test
    void totalCost() {
        assertEquals(24.560000000000002, supermarket.totalCost());
    }

    @Test
    void averageCost() {
        assertEquals(6.140000000000001, supermarket.averageCost());
    }

    @Test
    void findOutOfDate() {
    //    Product[] expected = {products[1], products[2]};
        Product[] actual = supermarket.findOutOfDate(LocalDate.of(2024, 9, 9));
     //   assertArrayEquals(expected, actual);
    }
}