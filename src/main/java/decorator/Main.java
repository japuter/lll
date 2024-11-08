package decorator;

public class Main {
    public static void main(String[] args) {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World!");

        Printer filePrinter = new FilePrinter(new BasicPrinter());
        filePrinter.print("Hello File!"); // Writes to "output.txt" and prints to console.

        Printer encryptedPrinter = new EncryptedPrinter(new BasicPrinter());
        encryptedPrinter.print("Hello Encrypted!"); // Prints encrypted text to console.

        Printer combinedPrinter = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        combinedPrinter.print("Hello File and Encrypted!"); // Writes encrypted message to file and prints encrypted message to console.
    }
}
