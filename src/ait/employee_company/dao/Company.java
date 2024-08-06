package ait.employee_company.dao;


import ait.employee_company.model.Employee;

public interface Company {
    //only abstract methods for Employee and children
    //CRUD methods - Create, Read, Update, Delete

    //create
    boolean addEmployee(Employee employee);

    //search employee
    Employee findEmployee(int id);

    //update employee
    Employee updateEmployee(Employee employee);

    //delete employee
    Employee removeEmployee(int id);

    //print
    void printEmployee();

    //number of employees
    int quantity();

    //salary
    double totalSalary();

    //sales
    int totalSales();


    //
    Employee[] findEmployeeGrateHoursThan(double hours);
}
