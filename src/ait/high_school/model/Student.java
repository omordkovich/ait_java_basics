package ait.high_school.model;

import java.time.LocalDate;
import java.util.Arrays;

public final class Student extends SchoolStaff {
    private String specialisation;
    private int[] points;
    private double gpa;


    public Student(int id, String title, String name, String surname, LocalDate birthDay, String specialisation, int[] points) {
        super(id, title, name, surname, birthDay);
        this.specialisation = specialisation;
        this.points = points;
        this.gpa = calculateGpa();
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private double calculateGpa() {
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            res += points[i];
        }
        return res / points.length;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| specification: %s| gpa: %.1f| points: ", specialisation, gpa) + Arrays.toString(points);
    }
}
