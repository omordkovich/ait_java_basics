package ait.homework_33.iterator_fibonacci.ait.fibonacci;

import ait.homework_33.iterator_fibonacci.ait.fibonacci.model.Fibonacci;

import java.util.Iterator;

public class FibonacciAppl {
    public static void main(String[] args) {
        int quantity = 8;
        Fibonacci fibonacci = new Fibonacci(quantity);

        int count = 0;
        Iterator<Integer> iterator = fibonacci.iterator();
        // print all numbers: 1, 1, 2, 3, 5, 8, 13, 21;  calculate sum
        int sum = 0;
        while (count < quantity) {
            Integer i = iterator.next();
            System.out.print(i + "| ");
            count++;
            sum += i;
        }
        System.out.println();
        System.out.println("sum = " + sum);


    }
}
