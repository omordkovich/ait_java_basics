package ait.homework_28.sun_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class PlanetTest {
    Planet[] planets;

    @BeforeEach
    void setUp() {
        planets = new Planet[]{
                new Planet(1, "Mercury", 2440, 0.3302),
                new Planet(2, "Venus", 6052, 4.869),
                new Planet(3, "Earth", 6371, 5.9742),
                new Planet(4, "Mars", 3389, 0.64191),
                new Planet(5, "Jupiter", 69911, 1899),
                new Planet(6, "Saturn", 58232, 568.8),
                new Planet(7, "Uranus", 25362, 86.86),
                new Planet(8, "Neptune", 24622, 102.4),
        };
    }

    @Test
    void sortPlanetsByRadius() {
        printArray(planets);
        Arrays.sort(planets);
        Planet pattern = new Planet(0, null, 3389, 0);
        int index = Arrays.binarySearch(planets, pattern);
        printArray(planets);
        System.out.println("Index of planet with radius " + pattern.getRadius() + " km is " + index);

    }

    @Test
    void sortPlanetsByName() {
        printArray(planets);
        Arrays.sort(planets, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        Planet pattern = new Planet(0, "Earth", 0, 0);
        int index = Arrays.binarySearch(planets, pattern, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(planets);
        System.out.println("Index of " + pattern.getName() + " is " + index);
    }

    @Test
    void sortPlanetsByMass() {
        printArray(planets);
        Comparator<Planet> comparatorByMass = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
             return Double.compare(o1.getMass(), o2.getMass());
            }
        };
        Arrays.sort(planets, comparatorByMass);
        printArray(planets);
        Planet pattern = new Planet(0, null, 0, 4.869);
        int index = Arrays.binarySearch(planets, pattern, comparatorByMass);
        System.out.println("Index of planet with mass of " + pattern.getMass() + "*10²³ kg is " + index);

    }

    public void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}