package ait.homework_36.countries;

import java.util.Objects;

/*
Задача 3. Создайте класс Country со следующими полями:

-название;
-население(в млн.);
-континент
 */
public class Country implements Comparable<Country> {
    private String name;
    private int population;
    private String continent;

    public Country(String name, int population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country country)) return false;
        return population == country.population && Objects.equals(name, country.name) && Objects.equals(continent, country.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, continent);
    }

    @Override
    public String toString() {
        return String.format("Country name: %s; continent: %s; population: %d", name, continent, population);
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }
}
