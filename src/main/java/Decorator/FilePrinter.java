package Decorator;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends PrinterDecorator {

    public FilePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(message);
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(message + "\n");
            System.out.println("Message written to file: output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
