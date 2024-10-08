package ait.homework_33.myarray_iterator.model;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {
    private Integer[] array;
    private int index;
    private int length;

    public MyArrayIterator(Integer[] array) {
        this.array = array;
        this.length = array.length;
    }


    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public Integer next() {
        Integer current = array[index];
        index++;
        return current;
    }

    @Override
    public void remove() {
        for (int i = index - 1; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        length--;
        index--;
    }
}
