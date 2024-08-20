package ait.homework_29.country.model;

import java.util.Objects;

public class Country implements Comparable<Country> {
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("Country name: %s, population: %d", name, population);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country country)) return false;
        return population == country.population && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int compareTo(Country o) {
        return Integer.compare(this.population, o.population);
    }
}
