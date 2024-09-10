package ait.homework_35.sun_system;


public class Planet implements Comparable<Planet> {
    private String name;
    private double distanceToSun; // millions km
    private double mass; //*10^23 kg
    private int numberOfSatellites;

    public Planet(String name, double distanceToSun, double mass, int numberOfSatellites) {
        this.name = name;
        this.distanceToSun = distanceToSun;
        this.mass = mass;
        this.numberOfSatellites = numberOfSatellites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceToSun() {
        return distanceToSun;
    }

    public void setDistanceToSun(double distanceToSun) {
        this.distanceToSun = distanceToSun;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public void setNumberOfSatellites(int numberOfSatellites) {
        this.numberOfSatellites = numberOfSatellites;
    }

    @Override
    public String toString() {
        return String.format("Planet: Name- %s, Distance from sun- %.4fkm, Mass- %.4f*10²³ kg, Number of satellites- %d", name, distanceToSun, mass, numberOfSatellites);
    }

    @Override
    public int compareTo(Planet o) {
        return Double.compare(this.distanceToSun, o.distanceToSun);
    }
}
