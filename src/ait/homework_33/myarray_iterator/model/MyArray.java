package ait.homework_33.myarray_iterator.model;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray implements Iterable<Integer>{
    Integer[] myArray;

    public MyArray(Integer[] myArray) {
        this.myArray = myArray;
    }

    public void setMyArray(Integer[] myArray) {
        this.myArray = myArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(myArray);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(myArray);
    }
}
