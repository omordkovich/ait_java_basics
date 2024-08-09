package ait.computer_shop.dao;

import ait.computer_shop.model.Computer;

public interface Shop {
    boolean addComputer(Computer computer);

    Computer removeComputer(long serialNumber);

    Computer findComputer(long serialNumber);

    Computer updateComputer(Computer computer);

    Computer[] findBlackFriday();
}
