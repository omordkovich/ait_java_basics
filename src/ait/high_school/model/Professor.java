package ait.high_school.model;

import java.time.LocalDate;

public class Professor extends SchoolStaff {
    private String subject;
    private double rating;
    private int experienceYears;

    public Professor(int id, String title, String name, String surname, LocalDate birthDay, String subject, double rating, int experienceYears) {
        super(id, title, name, surname, birthDay);
        this.subject = subject;
        this.rating = rating;
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| subject: %s| rating: %.1f| years of experience: ");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
