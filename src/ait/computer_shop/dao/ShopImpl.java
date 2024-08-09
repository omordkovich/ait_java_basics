package ait.computer_shop.dao;

import ait.computer_shop.model.Computer;

public class ShopImpl implements Shop {
    Computer[] computers;
    int size;

    public ShopImpl(int capacity) {
        this.computers = new Computer[capacity];
    }

    @Override
    public boolean addComputer(Computer computer) {
        if (computer == null || size == computers.length || findComputer(computer.getSerialNumber()) != null) {
            return false;
        }
        computers[size++] = computer;
        return true;
    }

    @Override
    public Computer removeComputer(long serialNumber) {
        Computer victim = null;
        for (int i = 0; i < size; i++) {
            if (computers[i].getSerialNumber() == serialNumber) {
                victim = computers[i];
                computers[size - 1] = null;
                size--;
                break;
            }
        }
        return victim;
    }

    @Override
    public Computer findComputer(long serialNumber) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getSerialNumber() == serialNumber) {
                return computers[i];
            }
        }
        return null;
    }


    @Override
    public Computer updateComputer(Computer computer) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getSerialNumber() == computer.getSerialNumber()) {
                computers[i] = computer;
                return computer;
            }
        }
        return null;
    }

    @Override
    public Computer[] findBlackFriday() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (computers[i].isBlackFriday()) {
                count++;
            }
        }
        Computer[] bFComputers = new Computer[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (computers[i].isBlackFriday()) {
                bFComputers[j++] = computers[i];
            }

        }
        return bFComputers;
    }
}
