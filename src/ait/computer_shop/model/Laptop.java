package ait.computer_shop.model;


public class Laptop extends Computer {
    private double displaySize;
    private double weight;
    private int batteryCapacity;

    public Laptop(boolean blackFriday, String cpu, int ram, int ssd, String brand, double price, long serialNumber, double displaySize, double weight, int batteryCapacity) {
        super(blackFriday, cpu, ram, ssd, brand, price, serialNumber);
        this.displaySize = displaySize;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +

                "Display size: " + displaySize + "\n" +
                "Weight: " + weight + "g\n" +
                "Battery capacity: " + batteryCapacity + "h\n";
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}

