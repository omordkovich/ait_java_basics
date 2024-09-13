package ait.homework_36.germany;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GermanyAppl {
    public static void main(String[] args) {
        List<String> capitalCities = new LinkedList<>();
        capitalCities.add("Stuttgart");
        capitalCities.add("Muenchen");
        capitalCities.add("Berlin");
        capitalCities.add("Potsdam");
        capitalCities.add("Bremen");
        capitalCities.add("Wiesbaden");
        capitalCities.add("Schwerin");
        capitalCities.add("Hannover");
        capitalCities.add("Duesseldorf");
        capitalCities.add("Mainz");
        capitalCities.add("Saarbruecken");
        capitalCities.add("Dresden");
        capitalCities.add("Magdeburg");
        capitalCities.add("Kiel");
        capitalCities.add("Erfurt");

        printList(capitalCities);
        System.out.println("Length of list is: " + capitalCities.size());
        addToMiddle(capitalCities, "=>Hamburg<=");  // adds Hamburg at the middle of list
        addAsFirst(capitalCities, "=>Hamburg<=");  // adds Hamburg at the beginning of list
        printList(capitalCities);
        System.out.println("Length of list is: " + capitalCities.size());
        int index = capitalCities.indexOf("Berlin");
        System.out.println("Index of Berlin is: " + index);
        index = capitalCities.indexOf("=>Hamburg<=");
        int indexLast = capitalCities.lastIndexOf("=>Hamburg<=");
        System.out.println("Index of Hamburg is: " + index + " and " + indexLast);
        capitalCities.removeIf(n -> n.charAt(0) == 'S'); //remove all cities starting with "S"
        printList(capitalCities);
        System.out.println("Length of list is: " + capitalCities.size());
    }

    //prints Lists
    private static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
        System.out.println("======================================");
    }

    //adds element to the middle of list;
    private static void addToMiddle(List<String> list, String element) {
        int middlePosition = list.size() / 2;
        list.add("");
        List<String> tmpList = new ArrayList<>(list.subList(middlePosition, list.size()));
        list.set(middlePosition, element);

        for (int i = middlePosition + 1, j = 0; i < list.size() && j < tmpList.size(); i++, j++) {
            list.set(i, tmpList.get(j));
        }
    }

    private static void addAsFirst(List<String> list, String element) {
        list.add("");
        List<String> tmpList = new ArrayList<>(list.subList(0, list.size()));
        list.set(0, element);

        for (int i = 1, j = 0; i < list.size() && j < tmpList.size(); i++, j++) {
            list.set(i, tmpList.get(j));
        }
    }
}
