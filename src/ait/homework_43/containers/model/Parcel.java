package ait.homework_43.containers.model;

/*
Создайте класс Parcel (посылка) с полем double weight - вес посылки.
 */
public class Parcel {
    private double weight;

    public Parcel(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Parcel{");
        sb.append("weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
