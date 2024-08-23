package ait.pet_hotel.model;

public final class Dog extends Pet {
    private String breed;
    private double size;
    private double weight;

    public Dog(int id, String kind, int age, String name, String breed, double size, double weight) {
        super(id, kind, age, name);
        this.breed = breed;
        this.size = size;
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + ", breed: " + breed +
                ", size: " + size +
                "cm, weight: " + weight + "kg";
    }

    public String voice() {
        return getName() + " says Wuf-Wuf!";
    }

    public String walking() {
        return getName() + " is going for a walk.";
    }

}
