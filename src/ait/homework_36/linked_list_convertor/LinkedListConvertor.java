package ait.homework_36.linked_list_convertor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListConvertor {
    private static final Random random = new Random();

    public static void main(String[] args) {
        LinkedListConvertor convertor = new LinkedListConvertor(); //create convertor object
        List<Integer> list = new ArrayList<>();     //create arrayList of Integer
        for (int i = 0; i < 10; i++) {              //fill arrayList with random numbers
            list.add(random.nextInt(0, 10));
        }
        printList(list);  //print list
        List<Integer> newList = convertor.toRevertedLinkedList(list); //convert ArrayList to reverted LinkedList
        printList(newList);  //print new list

        //creating ArrayList of strings
        List<String> stringList = new ArrayList<>();
        //filling ArrayList with names
        stringList.add("Jack");
        stringList.add("John");
        stringList.add("Nick");
        printList(stringList);  //print list
        List<Integer> newStringList = convertor.toRevertedLinkedList(stringList); //convert ArrayList to reverted LinkedList
        printList(newStringList);  //print new list
    }

    //converts Lists to reverted LinkedList
    public <E> LinkedList toRevertedLinkedList(List<E> list) {
        List<E> linkedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            linkedList.add(list.get(i));
        }
        return (LinkedList) linkedList;
    }

    //prints Lists
    private static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.print(element + "\t");
        }
        System.out.println();
        System.out.println("======================================");
    }
}
