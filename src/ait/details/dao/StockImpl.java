package ait.details.dao;

import ait.details.model.Detail;

public class StockImpl implements Stock{
    private Detail[] details;
    private  int size;

    public StockImpl(int capacity) {
        this.details = new Detail[capacity];
        this.size = 0;
    }

    @Override
    public boolean addDetail(Detail detail) {
        if (detail == null || size == details.length || findByBarCode(detail.getBarCode()) != null) {
            return false;
        } else {
            details[size] = detail;
            size++;
            return true;
        }
    }

    @Override
    public Detail findByBarCode(long barCode) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == barCode) {
                return details[i];
            }
        }
        return null;
    }

    @Override
    public Detail updateDetail(Detail detail) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == detail.getBarCode()) {
                details[i] = detail;
                return detail;
            }
        }
        return null;
    }


    @Override
    public Detail removeDetail(long barCode) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == barCode) {
                Detail victim = details[i];
                details[i] = details[size - 1];
                details[size - 1] = null;
                size--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public double totalWeight() {
        double sum= 0;
        for (int i = 0; i < size; i++) {
            sum+=details[i].getWeight();
        }
        return sum;
    }

    @Override
    public double averageWeight() {
        double sum= 0;
        for (int i = 0; i < size; i++) {
            sum+=details[i].getWeight();
        }
        return sum/size;
    }

    @Override
    public Detail[] findByCustomSize(double size1, double size2) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (details[i].getSize() > size1 && details[i].getSize() < size2) {
                count++;
            }
        }
        Detail[] res = new Detail[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (details[i].getSize() > size1 && details[i].getSize() < size2) {
                res[j++] = details[i];
            }
        }
        return res;
    }
}
