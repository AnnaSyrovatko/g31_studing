package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyImpl;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company;

    Employee [] employees;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        employees = new Employee[4];
        employees[0] = new Manager(1000,"John", "Smith", 160, 3000, 5);
        employees[1] = new WageEmployee(2000,"Mary", "Smith", 160, 15);
        employees[2] = new SalesManager(3000,"Peter", "Jackson", 160, 20000, 0.1);
        employees[3] = new SalesManager(4000,"Rabindranante", "Anand", 80, 30000, 0.1);
        for (int i = 0; i < employees.length; i++) {
            company.addEmployee(employees[i]);

        }
    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertFalse(company.addEmployee(employees[1]));
        Employee employee =  new SalesManager(5000,"Rabindranante", "Anand", 80, 30000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quality());
        assertFalse(company.addEmployee(employee));
    }

    @org.junit.jupiter.api.Test
    void removeEmployee() {
        int id = 1000;
        assertEquals(employees[0],company.removeEmployee(id));
        assertEquals(3, company.quality());
        assertNull(company.removeEmployee(id));
    }

    @org.junit.jupiter.api.Test
    void findEmployee() {
        int id = 3000;
        assertEquals(employees[2], company.findEmployee(id));
        assertNull(company.findEmployee(5000));
    }

    @org.junit.jupiter.api.Test
    void quality() {
        assertEquals(4, company.quality());
    }

    @org.junit.jupiter.api.Test
    void totalSalary() {
        assertEquals(11200.0, company.totalSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void avgSalary() {
        assertEquals((double) 11200 / 4, company.avgSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void totalSales() {
        assertEquals(50_000.0, company.totalSales(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void printEmployees() {
        company.printEmployees();
    }

    @Test
    void findEmployeeHoursGreaterThan(){
        Employee[] actual = company.findEmployeeHoursGreaterThan(100);
        Employee[] expected = {employees[0], employees[1], employees[2]};
        assertArrayEquals(expected, actual);
    }
    @Test
    void findEmployeesSalaryRange(){
        Employee[] actual = company.findEmployeesSalaryRange(2000, 2500);
        Employee[] expected = {employees[1], employees[2]};
        assertArrayEquals(expected, actual);
    }
}