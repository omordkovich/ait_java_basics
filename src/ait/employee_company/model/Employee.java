package ait.employee_company.model;
/*
- создать дочерние классы practice.model.Manager, practice.model.SalesManager и Worker, реализовать в них методы начисления зарплаты:
    - practice.model.Manager: base + grade*hours
    - practice.model.SalesManager: salesValue * percent
    - Worker: grade*hours
 */

import java.util.Objects;

public abstract class Employee {
    protected static double minWage = 13; // euro per hour
    protected int id;
    protected String firstname;
    protected String lastname;
    protected double hours;



    protected int age;


    public Employee(int id, String firstname, String lastname, double hours, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hours = hours;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static double getMinWage() {
        return minWage;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public static void setMinWage(double minWage) {
        if (minWage > Employee.minWage) {
            Employee.minWage = minWage;
        }
    }

    //protect from mistake in salary department
    protected double ensureSalary(double salary) {
        if (salary < hours * minWage) {
            salary = hours * minWage;
        }
        return salary;
    }

    public abstract double salary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", hours=").append(hours);
        sb.append('}');
        return sb.toString();
    }

}
