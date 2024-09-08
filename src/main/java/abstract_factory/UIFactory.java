package abstract_factory;


// Abstract factory that defines methods for creating UI elements

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract Checkbox createCheckbox(String text);
    public abstract TextField createTextField(String text);

}
