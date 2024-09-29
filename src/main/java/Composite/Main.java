package Composite;

public class Main {
    public static void main(String[] args) {
        //Create Employee
        Employee emp1 = new Employee("Jasper", 100);
        Employee emp2 = new Employee("Kaira", 250);
        Employee emp3 = new Employee("Konsta", 500);

        //Create departments

        Department engineering = new Department("Engineering");
        Department hr = new Department("HR");

        //add employees to departments
        engineering.add(emp1);
        engineering.add(emp3);
        hr.add(emp2);

        //Create Head department and add sub departments
        Department headOffice = new Department("Head Office");
        headOffice.add(engineering);
        headOffice.add(hr);


        // Display the organizational structure in XML format
        System.out.println("Organizational Structure in XML: ");
        headOffice.printStructure();

        //Display total salary
        System.out.println("\nTotal Salary of Organization: $" + headOffice.getTotalSalary());

    }
}
