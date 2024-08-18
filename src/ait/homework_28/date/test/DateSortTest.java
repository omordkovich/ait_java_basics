package ait.homework_28.date.test;
//Задание 2.(*) В классе DateSortTest (см. код занятия), реализовать компаратор в методе setUp, чтобы тест был верный.
// Просьба не использовать Java Time API.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
            if (s1.substring(6).equals(s2.substring(6))) {
                if (s1.substring(3, 4).equals(s2.substring(3, 4))) {
                    return Integer.compare(Integer.parseInt(s1.substring(0, 1)), Integer.parseInt(s2.substring(0, 1)));
                } else {
                    return Integer.compare(Integer.parseInt(s1.substring(3, 4)), Integer.parseInt(s2.substring(3, 4)));
                }
            }
            return Integer.compare(Integer.parseInt(s1.substring(6)), Integer.parseInt(s2.substring(6)));
        };
    }

    @Test
    void testDateSort() {
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970"
        };
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010"
        };
        Arrays.sort(dates, comparator);
        assertArrayEquals(expected, dates);
    }
}