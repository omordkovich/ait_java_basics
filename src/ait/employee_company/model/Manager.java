package ait.employee_company.model;

public class Manager extends Employee {
    private double baseSalary;
    private int grade;

    public Manager(int id, String firstname, String lastname, double hours, int age, double baseSalary, int grade) {
        super(id, firstname, lastname, hours, age);
        this.baseSalary = baseSalary;
        this.grade = grade;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public double salary() {
        double salary = baseSalary + hours * grade;
        return ensureSalary(salary);
    }
}
