package ait.homework_35.computers;

public class Smartphone extends Laptop {
    private int cameraResolution;
    private long imei;

    public Smartphone(String cpu, int ram, int ssd, String brand, double price, long serialNumber, double displaySize, double weight, int batteryCapacity, int cameraResolution, long imei) {
        super(cpu, ram, ssd, brand, price, serialNumber, displaySize, weight, batteryCapacity);
        this.cameraResolution = cameraResolution;
        this.imei = imei;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Smartphone{");
        sb.append(super.toString());
        sb.append("cameraResolution=").append(cameraResolution);
        sb.append(", imei=").append(imei);
        sb.append('}');
        return sb.toString();
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
