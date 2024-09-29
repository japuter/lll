package Composite;

public abstract class OrganizationComponent {

    //concrete method: An abstract class can also have concrete methods
    // that provide a default implementation. These methods can be inherited by subclasses
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }


    public abstract String getName();

    public abstract double getSalary();

    //Abstract method that subclasses must implement
    public abstract double getTotalSalary();

    //Abstract method that subclasses must implement
    public abstract void printStructure();
}
