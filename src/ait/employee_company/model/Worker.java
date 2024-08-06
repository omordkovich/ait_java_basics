package ait.employee_company.model;

public class Worker extends Employee {
    private double wage;

    public Worker(int id, String firstname, String lastname, double hours, int age, double wage) {
        super(id, firstname, lastname, hours, age);
        this.wage = wage;
    }


    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double salary() {
        double salary = wage * hours; //calculate salary
        return ensureSalary(salary); //check salary
    }
}
