package Builder;

// Demonstrates building different types of computers
public class Main {
    public static void main(String[] args) {
        // Create a gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        Computer gamingComputer = director.constructComputer();
        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);

        // Create an office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);
        Computer officeComputer = director.constructComputer();
        System.out.println("\nOffice Computer Configuration:");
        System.out.println(officeComputer);
    }
}
