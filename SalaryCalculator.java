package com.example.demo.unsolid;

public class SalaryCalculator {

    private EmployeeManager em;

    public SalaryCalculator(EmployeeManager employeeManager) {
        this.em = employeeManager;
    }

    public double calculateSalary(String name) {
        return this.em.calculateSalary(name);
    }
}