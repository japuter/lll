package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {
        controller = new Controller(this);
        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(event -> new HistoryWindow(controller).show());

        Label label = new Label("Press Ctrl-Z to undo, Ctrl-Y to redo.");
        VBox vBox = new VBox(hBox, checkBox, label, historyButton);
        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        colorBox1.setColor(convertOptionToColor(controller.getOption(1)));
        colorBox2.setColor(convertOptionToColor(controller.getOption(2)));
        colorBox3.setColor(convertOptionToColor(controller.getOption(3)));
        checkBox.setSelected(controller.getIsSelected());
    }

    private String convertOptionToColor(int option) {
        // Convert int to valid color string (e.g., using a predefined mapping)
        return String.format("#%06x", option & 0xFFFFFF); // Ensure it's a valid hex color
    }
}
