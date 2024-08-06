package ait.details.test;

import ait.details.dao.Stock;
import ait.details.dao.StockImpl;
import ait.details.model.Detail;
import ait.details.model.Gear;
import ait.details.model.Lever;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockImplTest {
    Stock stock;
    Detail[] details;
    double size1 = 45;
    double size2 = 60;

    @BeforeEach
    void setUp() {
        stock = new StockImpl(4);
        details = new Detail[4];
        details[0] = new Gear(11111112L, 50.0, "Metal", "NA", 100, 50, 200);
        details[1] = new Detail(11111113L, 40, "Plastic", "NA", 50);
        details[2] = new Lever(11111114L, 150, "Metal", "NA", 100, 200);

        for (int i = 0; i < details.length; i++) {
            stock.addDetail(details[i]);
        }
    }

    @Test
    void addDetail() {
        assertFalse(stock.addDetail(null));
        assertFalse(stock.addDetail(details[1]));
        Detail detail = new Detail(11111115L, 40, "Plastic", "NA", 50);
        assertTrue(stock.addDetail(detail));
        detail = new Detail(11111116L, 40, "Plastic", "NA", 50);
        assertFalse(stock.addDetail(detail));
    }

    @Test
    void findByBarCode() {
        assertEquals(details[2], stock.findByBarCode(11111114L));
        assertNull(stock.findByBarCode(11111119L));
    }

    @Test
    void updateDetail() {
        Detail updatedDetail = new Gear(11111112L, 50.0, "Metal", "NA", 100, 50, 100);
        assertEquals(details[0], stock.updateDetail(updatedDetail));
        updatedDetail = new Gear(0000002L, 50, "Metal", "NA", 100, 50, 190);
        assertNull(stock.updateDetail(updatedDetail));
    }

    @Test
    void removeDetail() {
        Detail detailVictim = stock.removeDetail(11111112L);
        assertEquals(details[0], detailVictim);
        assertNull(stock.removeDetail(000000001L));
    }


    @Test
    void totalWeight() {
        assertEquals(250.0, stock.totalWeight());
    }

    @Test
    void averageWeight() {
        assertEquals(83.33333333333333, stock.averageWeight());

    }

    @Test
    void findByCustomSize() {
        Detail[] expected = {details[0]};
        Detail[] actual = stock.findByCustomSize(size1, size2);
        assertArrayEquals(expected, actual);
    }
}