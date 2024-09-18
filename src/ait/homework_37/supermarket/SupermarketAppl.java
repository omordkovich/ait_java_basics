package ait.homework_37.supermarket;

import ait.homework_37.supermarket.dao.Supermarket;
import ait.homework_37.supermarket.dao.SupermarketImpl;
import ait.homework_37.supermarket.model.Product;

import java.time.LocalDate;

public class SupermarketAppl {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        Supermarket myMarket = new SupermarketImpl();
        Product[] products = new Product[5];
        products[0] = new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5));
        products[1] = new Product(222222, "ChokoMilk", "Dairy", "MilkLand", 13, now.minusDays(3));
        products[2] = new Product(333333, "Cheese Gauda", "Dairy", "Farmer", 22.5, now.plusDays(50));
        products[3] = new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85));
        products[4] = new Product(555555, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));

        for (Product product : products) {
            myMarket.addProduct(product);
        }
        System.out.println();
        myMarket.printAllProducts();
        System.out.println("Products by Brand: ");
        Iterable<Product> res = myMarket.findByBrand("MilkLand");
        for (Product p : res) {
            System.out.println(p);
        }

        System.out.println("Products by Category: ");
        res = myMarket.findByCategory("Bread");
        System.out.println(res);

        System.out.println("Products with expired date: ");
        res = myMarket.findProductsWithExpiredDate();
        for (Product p : res) {
            System.out.println(p);
        }
    }
}
