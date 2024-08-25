package ait.homework_30.code.week_day;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WeekDayTest {

    @Test
    void plusDays() {
        WeekDay day = WeekDay.MON;
        assertEquals(WeekDay.THU, day.plusDays(day, 10));
    }

    @Test
    void testValues() {
        WeekDay[] expected = {WeekDay.MON, WeekDay.TUE, WeekDay.WED,
                WeekDay.THU, WeekDay.FRI, WeekDay.SAT, WeekDay.SUN};
        assertArrayEquals(expected, WeekDay.values());
        assertEquals(WeekDay.FRI, WeekDay.values()[4]);
    }

    @Test
    void testValueOf() {
        assertEquals(WeekDay.FRI, WeekDay.valueOf("FRI"));
    }

    private void display() {
        for (WeekDay day : WeekDay.values()) {
            System.out.println(day);
        }
    }
}