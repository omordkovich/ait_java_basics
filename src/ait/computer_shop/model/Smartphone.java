package ait.computer_shop.model;

public class Smartphone extends Laptop {
    private int cameraResolution;
    private long imei;

    public Smartphone(boolean blackFriday, String cpu, int ram, int ssd, String brand, double price, long serialNumber, double displaySize, double weight, int batteryCapacity, int cameraResolution, long imei) {
        super(blackFriday, cpu, ram, ssd, brand, price, serialNumber, displaySize, weight, batteryCapacity);
        this.cameraResolution = cameraResolution;
        this.imei = imei;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Camera resolution: " + cameraResolution + "MP\n" +
                "IMEI: " + imei + "\n";
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }
}
