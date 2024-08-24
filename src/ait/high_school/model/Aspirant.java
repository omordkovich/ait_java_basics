package ait.high_school.model;

import java.time.LocalDate;

public class Aspirant extends SchoolStaff {
    private String specification;
    private String aspirationTheme;
    private double gpa;
    private String applicationStatus;

    public Aspirant(int id, String title, String name, String surname, LocalDate birthDay, String specification, String aspirationTheme, double gpa, String applicationStatus) {
        super(id, title, name, surname, birthDay);
        this.specification = specification;
        this.aspirationTheme = aspirationTheme;
        this.gpa = gpa;
        this.applicationStatus = applicationStatus;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getAspirationTheme() {
        return aspirationTheme;
    }

    public void setAspirationTheme(String aspirationTheme) {
        this.aspirationTheme = aspirationTheme;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| specification: %s| aspiration theme: %s| GPA: %.1f| application status: %s", specification, aspirationTheme, gpa, applicationStatus);
    }
}
