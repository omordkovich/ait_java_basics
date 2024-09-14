package ait.homework_36.countries;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Создайте связный список, содержащий 11 стран из разных континентов. Получите списки этих стран, отсортированные по:
-алфавиту;
-по размеру населения в стандартном и обратном порядках;
-принадлежности континенту и размеру населения в порядке от большего к меньшему.
 */
public class CountryAppl {
    public static void main(String[] args) {
        List<Country> countriesList = new LinkedList<>();
        countriesList.add(new Country("Germany", 83100000, "Europe"));
        countriesList.add(new Country("USA", 331000000, "North America"));
        countriesList.add(new Country("Brazil", 213000000, "South America"));
        countriesList.add(new Country("India", 1380000000, "Asia"));
        countriesList.add(new Country("Japan", 125800000, "Asia"));
        countriesList.add(new Country("Australia", 25690000, "Australia"));
        countriesList.add(new Country("Egypt", 104000000, "Africa"));
        countriesList.add(new Country("Canada", 38000000, "North America"));
        countriesList.add(new Country("Russia", 146000000, "Asia"));
        countriesList.add(new Country("Nigeria", 206000000, "Africa"));
        countriesList.add(new Country("Argentina", 45100000, "South America"));

        System.out.println("====================Original list=====================");
        printList(countriesList);
        countriesList.sort(Country::compareTo);
        System.out.println("====================Alphabetic sort=====================");
        printList(countriesList);
        countriesList.sort(Comparator.comparing(Country::getPopulation));
        System.out.println("====================Sort by population (ascending)=====================");
        printList(countriesList);
        Comparator<Country> comparatorPopulationDescending = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Integer.compare(o2.getPopulation(), o1.getPopulation());
            }
        };
        countriesList.sort(comparatorPopulationDescending);
        System.out.println("====================Sort by population(descending)=====================");
        printList(countriesList);
        System.out.println("====================Sort by continent, then by population(descending)=====================");
        countriesList.sort(Comparator.comparing(Country::getContinent).thenComparing(comparatorPopulationDescending));
        printList(countriesList);
    }

    private static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
    }
}

