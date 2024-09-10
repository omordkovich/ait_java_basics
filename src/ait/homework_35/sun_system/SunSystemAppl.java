package ait.homework_35.sun_system;
/*
Задача 2. Занести планеты солнечной системы в список, содержащий:
наименование;
расстояние до Солнца;
массу;
количество спутников.
Вывести список планет отсортированный по:
порядку расположения в солнечной системе;
алфавиту;
массе;
количеству спутников.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SunSystemAppl {
    public static void main(String[] args) {
        //
        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Mars", 227.9, 0.64191, 2));
        planets.add(new Planet("Uranus", 2872, 86.86, 27));
        planets.add(new Planet("Mercury", 57.9, 0.3302, 0));
        planets.add(new Planet("Neptune", 4495, 102.4, 14));
        planets.add(new Planet("Earth", 149.6, 5.9742, 1));
        planets.add(new Planet("Jupiter", 778.5, 1899, 95));
        planets.add(new Planet("Saturn", 1433, 568.8, 146));
        planets.add(new Planet("Venus", 108.2, 4.869, 0));

        printPlanets(planets);
        System.out.println("-----------------------sort by distance to sun-------------------------");
        planets.sort(Planet::compareTo);
        printPlanets(planets);

        System.out.println("---------------------------sort by mass-----------------------------");
        planets.sort(Comparator.comparing(Planet::getMass));
        printPlanets(planets);

        System.out.println("---------------------------sort by number of satellites-----------------------------");
        planets.sort(Comparator.comparing(Planet::getNumberOfSatellites).thenComparing(Planet::getName));
        printPlanets(planets);

        System.out.println("---------------------------sort by alphabet-----------------------------");
        planets.sort(Comparator.comparing(Planet::getName).thenComparing(Planet::getDistanceToSun));
        printPlanets(planets);


    }

    public static void printPlanets(List<Planet> planets) {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
}
