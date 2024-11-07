package decorator;

public class EncryptedPrinter implements Printer{
    private Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        printer.print(encryptedMessage);
    }
}
