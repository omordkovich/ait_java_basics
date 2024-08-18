package ait.homework_28.sun_system;

import java.util.Objects;

public class Planet implements Comparable<Planet>{
    private int id;
    private String name;
    private int radius;  //km
    private double mass; //*10^23 kg

    public Planet(int id, String name, int radius, double mass) {
        this.id = id;
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Planet planet)) return false;
        return id == planet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("Planer: ID- %d, Name- %s, Radius- %dkm, Mass- %.4f*10²³ kg", id, name, radius, mass);
    }

    @Override
    public int compareTo(Planet o) {
        return -Integer.compare(this.radius,o.radius);
    }
}
