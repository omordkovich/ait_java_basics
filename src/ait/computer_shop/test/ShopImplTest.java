package ait.computer_shop.test;

import ait.computer_shop.dao.Shop;
import ait.computer_shop.dao.ShopImpl;
import ait.computer_shop.model.Computer;
import ait.computer_shop.model.Laptop;
import ait.computer_shop.model.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {
    Shop shop;
    Computer[] computers;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(8);
        computers = new Computer[7];
        computers[0] = new Computer(true, "Core i7", 8, 512, "HP", 1200, 152452156854521L);
        computers[1] = new Computer(false, "Core i5", 4, 256, "Asus", 1000, 514535179525469L);
        computers[2] = new Computer(false, "Core i9", 16, 512, "Acer", 1500, 658954565812356L);
        computers[3] = new Laptop(true, "M2", 16, 1024, "Apple", 3000, 654852321489254L, 15.1, 2.6, 10); //upper casting
        computers[4] = new Laptop(false, "M1", 8, 512, "Apple Air", 1500, 876554212144452L, 15.1, 1.6, 12);
        computers[5] = new Smartphone(false, "Snapdragon 865+", 8, 64, "Xiaomi", 900, 658951115812356L, 10, 0.3, 48, 8, 2154121515223541L);
        computers[6] = new Smartphone(true, "A3", 8, 64, "iPhone", 1400, 658951115812222L, 10, 0.6, 20, 16, 566321515123L);

        for (int i = 0; i < computers.length; i++) {
            shop.addComputer(computers[i]);
        }
    }

    @Test
    void addComputer() {
        assertFalse(shop.addComputer(null));
        assertFalse(shop.addComputer(computers[0]));
        Computer computer = new Computer(false, "Core i9", 16, 512, "Acer", 1500, 658954565833356L);
        assertTrue(shop.addComputer(computer));
        computer = new Computer(false, "Core i9", 16, 512, "Acer", 1500, 333954565812356L);
        assertFalse(shop.addComputer(computer));
    }

    @Test
    void removeComputer() {
        Computer victim = shop.removeComputer(514535179525469L);
        assertEquals(computers[1], victim);
        assertNull(shop.removeComputer(514535179522222L));
    }

    @Test
    void findComputer() {
        assertEquals(computers[1], shop.findComputer(514535179525469L));
        assertNull(shop.findComputer(100035179525469L));
    }

    @Test
    void updateComputer() {
        Computer computer = new Computer(true, "Core i7", 8, 512, "HP", 700, 152452156854521L);

        assertEquals(computers[0], shop.updateComputer(computer));
        computer = new Computer(false, "Core i5", 4, 256, "Asus", 1000, 514535179525568L);
        assertNull(shop.updateComputer(computer));
    }

    @Test
    void findBlackFriday() {
        Computer[] excepted = {computers[0], computers[3], computers[6]};
        Computer[] actual = shop.findBlackFriday();
        assertArrayEquals(excepted, actual);
    }
}