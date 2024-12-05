package Builder;

// Builds a high-performance gaming computer
public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i9 12900K");
    }

    @Override
    public void buildRam() {
        computer.setRam(32); // 32GB RAM
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1TB NVMe SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4090");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}
