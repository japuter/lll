package Composite;

public class Employee extends OrganizationComponent {
    private String name;
    private double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public double getTotalSalary() {
        return this.salary; // Employee's total salary is just their own salary
    }

    @Override
    public void printStructure() {
        System.out.println("<Employee name=\"" + this.name + "\" salary=\"" + this.salary + "\" />");
    }
}
