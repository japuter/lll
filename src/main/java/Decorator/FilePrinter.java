package decorator;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer{
    private Printer printer;

    public FilePrinter(Printer printer){
        this.printer = printer;
    }

    @Override
    public void print(String message){
        try(FileWriter writer = new FileWriter("output.txt, true")) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
