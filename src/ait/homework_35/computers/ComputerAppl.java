package ait.homework_35.computers;
/*
Задача 1. На основе класса Computer:

создать собственный ArrayList;
добавить в него не менее 6 элементов;
отсортировать список по бренду;
отсортировать список по размеру RAM, затем размеру SSD при равенстве RAM;
подсчитать общий суммарный объем и среднее значение SSD.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComputerAppl {
    public static void main(String[] args) {

        //creating ArrayList
        List<Computer> computerList = new ArrayList<>();
        //adding 6 elements
        computerList.add(new Computer("Core i7", 8, 512, "HP", 1200, 152452156854521L));
        computerList.add(new Computer("Core i5", 4, 256, "Asus", 1000, 514535179525469L));
        computerList.add(new Computer("Core i9", 16, 512, "Acer", 1500, 658954565812356L));
        computerList.add(new Laptop("M2", 16, 1024, "Apple", 3000, 654852321489254L, 15.1, 2.6, 10));
        computerList.add(new Laptop("M1", 8, 512, "Apple Air", 1500, 876554212144452L, 15.1, 1.6, 12));
        computerList.add(new Smartphone("Snapdragon 865+", 8, 64, "Xiaomi", 900, 658951115812356L, 10, 0.3, 48, 8, 2154121515223541L));
        printList(computerList);
        //sort by brand
        computerList.sort(Computer::compareTo);
        printList(computerList);
        //sort by ram, then by ssd
        computerList.sort(Comparator.comparing(Computer::getRam).thenComparing(Computer::getSsd));
        printList(computerList);
        System.out.println("Total volume of ssd: " + totalSsd(computerList));
        System.out.println("Average volume of ssd: " + avgSsd(computerList));
    }

    private static void printList(List<Computer> computerList) {
        for (Computer computer : computerList) {
            System.out.println(computer);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    private static double totalSsd(List<Computer> computerList) {
        double res = 0;
        for (Computer computer : computerList) {
            res += computer.getSsd();
        }
        return res;
    }

    private static double avgSsd(List<Computer> computerList) {
        return totalSsd(computerList) / computerList.size();
    }
}
