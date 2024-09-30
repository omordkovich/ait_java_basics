package ait.homework_40;

import java.util.Map;
import java.util.TreeMap;

//Задание 1. Соберите в структуру Map порядка 20 стран, по несколько страны из
// разных континентов Земли. Подсчитайте количество стран на континентах из полученного списка.
public class CountriesContinents {
    public static void main(String[] args) {

        //creating tree map for countries(keys) and continents (values)
        Map<String, String> countries = new TreeMap<>();
        countries.put("Russia", "Europe");
        countries.put("Germany", "Europe");
        countries.put("Mexico", "North America");
        countries.put("Canada", "North America");
        countries.put("China", "Asia");
        countries.put("Brazil", "South America");
        countries.put("Argentina", "South America");
        countries.put("Australia", "Australia");
        countries.put("India", "Asia");
        countries.put("Japan", "Asia");
        countries.put("France", "Europe");
        countries.put("Italy", "Europe");
        countries.put("United States", "North America");
        countries.put("South Africa", "Africa");
        countries.put("Egypt", "Africa");
        countries.put("Nigeria", "Africa");
        countries.put("United Kingdom", "Europe");
        countries.put("Saudi Arabia", "Asia");
        countries.put("New Zealand", "Australia");
        countries.put("Chile", "South America");

        //creating new tree map for continents (keys) and number of countries pro continent (value)
        Map<String, Integer> continent = new TreeMap<>();
        for (String c : countries.values()) {
            if (!continent.containsKey(c)) {
                continent.put(c, 1);
            } else {
                continent.put(c, continent.get(c) + 1);
            }
        }
        //print continents map with countries count
        for (String s : continent.keySet()) {
            System.out.println(s + ": " + continent.get(s));
        }
    }
}