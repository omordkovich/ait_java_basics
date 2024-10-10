package ait.homework_43.tourists;
//        Турагентство специализируется на странах Средиземноморья - Испания, Франция, Италия, Греция, Турция, Тунис.
//        Имеется таблица с данными о поездках клиентов в течение 2020-2023 годов в перечисленные страны.
//        Каждый из клиентов посетил от одной до 3 стран, причем некоторые страны по 2 и более раз. Создай 6 туристов по этой схеме

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TouristAppl {
    public static void main(String[] args) {
        List<Tourist> tourists = fillListTourists();
        //Какие страны наиболее популярны?
        printMostPopularCountries(tourists);
        //Кто из клиентов посетил наибольшее количество стран?
        printMostVisitingTourists(tourists);
    }

    private static void printMostVisitingTourists(List<Tourist> tourists) {
        System.out.println("----------------Most visiting tourists---------------");
        Map<Integer, List<Tourist>> visitingTourists = tourists.stream()
                .collect(Collectors.groupingBy(t -> t.getCountries().length));
        Integer max = visitingTourists.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(visitingTourists.get(max));
    }

    private static void printMostPopularCountries(List<Tourist> tourists) {
        System.out.println("----------------Most popular countries---------------");
        Map<String, Long> countriesFreq = tourists.stream()
                .map(Tourist::getCountries)
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Long max = countriesFreq.values().stream()
                .max(Long::compare)
                .orElse(0L);
        for (String key : countriesFreq.keySet()) {
            System.out.println(key + " was visited " + countriesFreq.get(key) + " times");
        }
        System.out.println("Most visited countries are:");
        countriesFreq.entrySet().stream()
                .filter(c -> c.getValue().equals(max))
                .forEach(c -> System.out.println(c.getKey()));
    }


    private static List<Tourist> fillListTourists() {
        return List.of(
                new Tourist("Maria", "Spain", "Greece"),
                new Tourist("John", "Italy", "Turkey", "Spain"),
                new Tourist("Anna", "Tunisia", "Tunisia", "Spain"),
                new Tourist("Michael", "Turkey", "Turkey", "Turkey"),
                new Tourist("Sophia", "France", "Italy"),
                new Tourist("James", "Spain")
        );
    }
}
