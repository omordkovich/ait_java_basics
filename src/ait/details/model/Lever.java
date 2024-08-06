package ait.details.model;

public class Lever extends Detail{
    private double power;

    public Lever(long barCode, double size, String material, String vendor, double weight, double power) {
        super(barCode, size, material, vendor, weight);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lever{");
        sb.append("power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
