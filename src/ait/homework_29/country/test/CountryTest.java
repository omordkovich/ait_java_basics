package ait.homework_29.country.test;

import ait.homework_29.country.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CountryTest {
    Country[] countries;

    @BeforeEach
    void setUp() {
        countries = new Country[6];
        countries[0] = new Country("Russia", 144100000);
        countries[1] = new Country("Germany", 83000000);
        countries[2] = new Country("China", 1402000000);
        countries[3] = new Country("France", 67000000);
        countries[4] = new Country("Mexico", 126000000);
        countries[5] = new Country("South Korea", 51700000);
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("===============" + title + "===============");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testComparable() {
        printArray(countries, "Source array");
        Arrays.sort(countries);
        printArray(countries, "Natural order");
        Country pattern = new Country(null, 85000000);
        int index = Arrays.binarySearch(countries, pattern);
        System.out.println(index);
    }

    @Test
    void testComparator() {
        Comparator<Country> comparatorByName = ((o1, o2) -> o1.getName().compareTo(o2.getName()));
        Arrays.sort(countries, comparatorByName);
        printArray(countries, "Sort by name");
        Country pattern = new Country("Russia", 0);
        int index = Arrays.binarySearch(countries, pattern, comparatorByName);
        System.out.println(index);
    }

    @Test
    void testArrayCopy() {
        Comparator<Country> comparatorByName = Comparator.nullsLast((o1, o2) -> o1.getName().compareTo(o2.getName()));
        Country[] countriesCopy = Arrays.copyOf(countries, countries.length * 2);
        printArray(countriesCopy, "Countries copy before sort");
        Arrays.sort(countriesCopy, comparatorByName);
        printArray(countriesCopy, "Countries after sort");
        Country pattern = new Country("Japan", 125000000);
        int index = Arrays.binarySearch(countriesCopy, 0, countries.length, pattern, comparatorByName);
        System.out.println(index);
    }

    @Test
    void testKeepSorted() {
        Arrays.sort(countries);
        printArray(countries, "Natural order");
        Country country = new Country("Japan", 125000000);
        Country[] countriesCopy = Arrays.copyOf(countries, countries.length + 1);
        printArray(countriesCopy, "Test");
        int index = Arrays.binarySearch(countriesCopy, 0, countriesCopy.length - 1, country);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(countriesCopy, index, countriesCopy, index + 1, countriesCopy.length - index - 1);
        countriesCopy[index] = country;
        countries = countriesCopy;
        printArray(countries, "Natural order after adding new country");
    }

    @Test
    void testSystemArrayCopy() {
        Country[] countriesCopy = new Country[countries.length + 2];
        System.arraycopy(countries, 2, countriesCopy, 2, 3);
        printArray(countries, "Source array");
        printArray(countriesCopy, "New array with copy of range");
    }

    @Test
    void testCopyOfRange() {
        Country[] countriesCopy = Arrays.copyOfRange(countries, 3, 5);
        printArray(countries, "Source array");
        printArray(countriesCopy, "Copy of range");
    }
}