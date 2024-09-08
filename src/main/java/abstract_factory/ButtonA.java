package abstract_factory;

// Concrete class for ButtonA

public class ButtonA extends Button{
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[Button A: ]: " + text + "]");
    }
}
