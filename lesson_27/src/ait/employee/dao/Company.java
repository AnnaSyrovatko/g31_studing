package ait.employee.dao;

import ait.employee.model.Employee;

public interface Company {

    public abstract boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quality();

    double totalSalary();

    double avgSalary();

    double totalSales();

    void printEmployees();

    Employee[] findEmployeeHoursGreaterThan(int hours);

    Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary);



}
