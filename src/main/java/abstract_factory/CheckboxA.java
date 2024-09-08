package abstract_factory;

//Concrete class for CheckboxA
public class CheckboxA extends Checkbox {
    public CheckboxA (String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[Checkbox A: " + text + "]");
    }
}
