package ait.homework_35.computers;

import java.util.Objects;

public class Computer implements Comparable<Computer> {
    public static final int SNR_LENGTH = 15;
    private String cpu;
    private int ram;
    private int ssd;
    private String brand;
    private double price;
    private long serialNumber;

    public Computer(String cpu, int ram, int ssd, String brand, double price, long serialNumber) {
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
        this.price = price;
        this.serialNumber = checkSNr(serialNumber);
    }


    public long checkSNr(long serialNumber) {
        if (countDigits(serialNumber) == SNR_LENGTH) {
            return serialNumber;
        }
        return -1;
    }

    public int countDigits(long serialNumber) {
        int count = 0;
        while (serialNumber != 0) {
            count++;
            serialNumber /= 10;
        }
        return count;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Computer computer)) return false;
        return serialNumber == computer.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serialNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("cpu='").append(cpu).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", ssd=").append(ssd);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Computer o) {
        return this.getBrand().compareTo(o.getBrand());
    }
}
