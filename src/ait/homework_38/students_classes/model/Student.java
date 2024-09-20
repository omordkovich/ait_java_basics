package ait.homework_38.students_classes.model;

import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String lastName;
    private int year;
    private List<Classes> classes;

    public Student(int id, String name, String lastName, int year, List<Classes> classes) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.year = year;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return String.format("id: %d; %s, %s; year: %d", id, lastName, name, year);
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
