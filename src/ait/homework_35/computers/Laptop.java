package ait.homework_35.computers;


public class Laptop extends Computer {
    private double displaySize;
    private double weight;
    private int batteryCapacity;

    public Laptop(String cpu, int ram, int ssd, String brand, double price, long serialNumber, double displaySize, double weight, int batteryCapacity) {
        super(cpu, ram, ssd, brand, price, serialNumber);
        this.displaySize = displaySize;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append(super.toString());
        sb.append("displaySize=").append(displaySize);
        sb.append(", weight=").append(weight);
        sb.append(", batteryCapacity=").append(batteryCapacity);
        sb.append('}');
        return sb.toString();
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

