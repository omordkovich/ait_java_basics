package ait.homework_33.iterator_fibonacci.ait.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int currentIndex = 1;
    private int nextIndex = 1;
    private int curPose = 0;
    private final int quantity;

    public FibonacciIterator(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean hasNext() {
        return curPose < quantity;
    }

    @Override
    public Integer next() {
        int tmp = currentIndex;
        currentIndex = nextIndex;
        nextIndex = tmp + nextIndex;
        curPose++;
        return tmp;
    }
}
