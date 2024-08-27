package ait.homework_31.ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {
    //реализовать метод getAge, принимающий дату рождения в виде стринга, и возвращающий возраст
    public static int getAge(String birthDate) {
        LocalDate bD = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        LocalDate localDate = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(bD, localDate);
    }

    //реализовать метод sortStringDates, принимающий массив дат в виде массива стрингов,
    // и возвращающий отсортированный массив стрингов-дат.
    public static String[] sortStringDates(String[] dates) {
        Comparator<String> localDateComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                LocalDate day1 = LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
                LocalDate day2 = LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
                return day1.compareTo(day2);
            }
        };
        Arrays.sort(dates, localDateComparator);
        return dates;
    }
}
