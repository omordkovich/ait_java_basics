package ait.high_school.model;

import java.time.LocalDate;
import java.util.Objects;

public class SchoolStaff {
    private int id;
    private String title;
    private String name;
    private String surname;
    private LocalDate birthDay;

    public SchoolStaff(int id, String title, String name, String surname, LocalDate birthDay) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SchoolStaff that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d| name: %s %s| birth date: ", id, name, surname) + birthDay.toString();
    }
}
