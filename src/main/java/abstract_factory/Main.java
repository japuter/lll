package abstract_factory;

public class Main {
    public static void main(String[] args) {
        // Create a factory for Style A
        UIFactory styleAFactory = new StyleAFactory();

        Button buttonA = styleAFactory.createButton("Click me");
        TextField textFieldA = styleAFactory.createTextField("Enter text");
        Checkbox checkboxA = styleAFactory.createCheckbox("Accept Terms");

        buttonA.display();
        textFieldA.display();
        checkboxA.display();


        // Using Style B factory to create UI elements
        UIFactory styleBFactory = new StyleBFactory();
        Button buttonB = styleBFactory.createButton("Submit");
        TextField textFieldB = styleBFactory.createTextField("input");

        buttonB.display();
        textFieldB.display();
    }


}
