package ait.homework_41;

import java.util.TreeSet;

/*
Задание 1. TreeSet - методы floor, cellar.
Создайте список известных вам фруктов (стран, городов и т.п.) и поместите его в TreeSet.
Апробируйте использование методов floor и cellar на полученной структуре.
 */
public class FloorsAndCeilings {
    public static void main(String[] args) {
        TreeSet<String> countries = new TreeSet<>();
        countries.add("Russia");
        countries.add("Germany");
        countries.add("Mexico");
        countries.add("Canada");
        countries.add("China");
        countries.add("Brazil");
        countries.add("Argentina");
        countries.add("Australia");
        countries.add("India");
        System.out.println("=======================Countries=========================");
        System.out.println(countries);
        System.out.println("Floor fo 'Ukraine' is: " + countries.floor("Ukraine"));
        System.out.println("Ceiling fo 'Ukraine' is: " + countries.ceiling("Ukraine"));

        TreeSet<String> fruits = new TreeSet<>();
        fruits.add("Grapes");
        fruits.add("Mango");
        fruits.add("Watermelon");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Pineapple");
        fruits.add("Strawberry");
        fruits.add("Apple");
        fruits.add("Peach");
        System.out.println("==========================Fruits=========================");
        System.out.println(fruits);
        String fruitsCeiling = fruits.ceiling("O");
        String fruitsFloor = fruits.floor("O");
        System.out.printf("Ceiling of 'O' is %s, and floor of 'O' is %s\n", fruitsCeiling, fruitsFloor);
        System.out.println("First in set is: " + fruits.first());
        System.out.println("Last in set is: " + fruits.last());
        System.out.println("Set contains 'Kiwi': " + fruits.contains("Kiwi"));
        System.out.println("Set contains 'Peach': " + fruits.contains("Peach"));

    }
}
