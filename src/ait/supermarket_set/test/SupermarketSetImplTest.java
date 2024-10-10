package ait.supermarket_set.test;

import ait.supermarket_set.dao.Supermarket;
import ait.supermarket_set.dao.SupermarketSetImpl;
import ait.supermarket_set.model.Food;
import ait.supermarket_set.model.MeatFood;
import ait.supermarket_set.model.MilkFood;
import ait.supermarket_set.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketSetImplTest {
    Supermarket supermarket;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketSetImpl(
                List.of(
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
        assertEquals(4, supermarket.size());
        assertTrue(supermarket.addProduct(product));
        assertEquals(5, supermarket.size());
    }

    @Test
    void removeProduct() {
        assertEquals(4, supermarket.size());
        supermarket.removeProduct("11111111111111111112");
        assertEquals(3, supermarket.size());
        assertNull(supermarket.removeProduct("11111111111110000000"));
    }


    @Test
    void findProductByBarcode() {
        Product toFind = new Product("11111111111111111114", "Batman action figure", 13.99);
        assertEquals(toFind, supermarket.findProductByBarcode("11111111111111111114"));
        assertNull(supermarket.findProductByBarcode("11111111111110000002"));
    }

    @Test
    void updateProduct() {
        supermarket.updateProduct("11111111111111111114", 10.90);
        //   assertEquals(10.90, products[3].getPrice());
    }

    @Test
    void findProductByExpirationDate() {
        //Product[] expected = {products[1], products[2]};
        //System.out.println(products);
        //Product[] actual = supermarket.findProductByExpirationDate(LocalDate.of(2024, 8, 9));
        //assertArrayEquals(expected, actual);*/
    }

    @Test
    void totalCost() {
        assertEquals(24.56, supermarket.totalCost(), 0.01);
    }

    @Test
    void averageCost() {
        assertEquals(6.14, supermarket.averageCost(), 0.01);
    }

    @Test
    void findOutOfDate() {
        Product product1 = new MilkFood("11111111111111111112", "Milk", 1.59, LocalDate.of(2024, 8, 9), "Vollmilch", 3.8);
        Product product2 = new Food("11111111111111111113", "Apples", 2.99, LocalDate.of(2024, 8, 9));
        Product[] expected = {product2, product1};
        Iterable<Product> productIterable = supermarket.findOutOfDate(LocalDate.of(2024, 9, 9));
        List<Product> productList = new ArrayList<>();
        productIterable.forEach(productList::add);
        Product[] actual = productList.toArray(new Product[2]);
        assertArrayEquals(expected, actual);
    }
}