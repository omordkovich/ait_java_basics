package ait.pet_hotel.model;

public final class Cat extends Pet {
    private String breed;
    private double size;
    private double weight;

    public Cat(int id, String kind, int age, String name, String breed, double size, double weight) {
        super(id, kind, age, name);
        this.breed = breed;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", breed: " + breed +
                ", size: " + size +
                "cm, weight: " + weight + "kg";
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

    public String voice() {
        return getName() + " says Mow-Mow!";
    }
    public String washing() {
        return getName() + " is washing itself.";
    }
}
