package ait.homework_45.titanic_statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitanicAppl {
    public static void main(String[] args) {
        try {
            //loading data
            List<String[]> str = loadData("src/ait/homework_45/titanic_statistics/train.csv");
            //total fates statistics
            TitanicStatistics statistics = new TitanicStatisticsImpl(str);
            System.out.printf("Total fates: %.2f$\n", statistics.totalFares());
            //average Fare by class of cabin
            Map<String, Double> avgStatistics = statistics.avgFaresByClasses();
            avgStatistics.forEach((key, value) -> System.out.printf("Class: %s average fare: %.2f$\n", key, value));
            //total survives and dies statistics
            Map<String, Long> countStatistic = statistics.totalSurvived();
            for (String s : countStatistic.keySet()) {
                if (s.equals("0")) {
                    System.out.println("Dead: " + countStatistic.get(s));
                } else if (s.equals("1")) {
                    System.out.println("Survived: " + countStatistic.get(s));
                }
            }
            //survived by gender
            countStatistic = statistics.totalSurvivedByGender();
            countStatistic.forEach((key, value) -> System.out.println(key + " survived: " + value));
            //children < 18y survives and dies statistic
            countStatistic = statistics.totalSurvivedChildren();
            for (String s : countStatistic.keySet()) {
                if (s.equals("0")) {
                    System.out.println("Children died: " + countStatistic.get(s));
                } else if (s.equals("1")) {
                    System.out.println("Children survived: " + countStatistic.get(s));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //loads data from file and converts it to list of Strings[]
    public static List<String[]> loadData(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());
        }
    }
}
