package Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }
    
    @Override
    public void add(OrganizationComponent component) {
        components.add(component); // add either employee or sub-department
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        // Loop through all components (employees or departments) and sum up their salaries
        for (OrganizationComponent component : components) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    public void printStructure() {
        System.out.println("<Department name=\"" + this.name + "\">");
                for (OrganizationComponent component : components) {
                    component.printStructure(); // Call each component to print its structure
                }
                System.out.println("</Department>");
    }
}
