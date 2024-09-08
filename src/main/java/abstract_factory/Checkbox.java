package abstract_factory;


// Abstract class for TextField
public abstract class Checkbox {
    protected String text;

    public Checkbox(String text) {
        this.text = text;
    }
    public abstract void display();
}
