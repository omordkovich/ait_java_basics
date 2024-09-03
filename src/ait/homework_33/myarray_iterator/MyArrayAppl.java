package ait.homework_33.myarray_iterator;

import ait.homework_33.myarray_iterator.model.MyArray;

import java.util.Iterator;

public class MyArrayAppl {
    public static void main(String[] args) {
        Integer[] array = {-1, 1, 5, 3, 6, 6, 8, -5, -10};
        MyArray myArray = new MyArray(array);
        System.out.println(myArray);
        Iterator<Integer> iterator = myArray.iterator();

        //print negative elements
        System.out.println("=============Negative values============");
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i * -1 + "| ");
        }
        System.out.println();

        iterator = myArray.iterator(); //reset index

        //square all elements
        System.out.println("=============Square all================");

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i * i + "| ");
        }
        System.out.println();

        iterator = myArray.iterator(); //reset index

        //removes even numbers from array
        System.out.println("=============Remove even numbers================");

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i % 2 == 0) {
                iterator.remove();
            }
        }
        for (Integer i : myArray) {
            if (i != null) {
                System.out.print(i + "| ");
            }
        }
    }
}
