package Memento;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox {
    private final int index;
    private final Controller controller;
    private final Rectangle rectangle;

    public ColorBox(int index, Controller controller) {
        this.index = index;
        this.controller = controller;
        this.rectangle = new Rectangle(100, 100, Color.WHITE); // Default color

        rectangle.setOnMouseClicked(event -> {
            // Toggle between WHITE and BLUE
            String currentColor = convertOptionToColor(controller.getOption(index));
            String newColor = currentColor.equals("WHITE") ? "BLUE" : "WHITE";
            controller.setOption(index, String.valueOf(newColor.hashCode())); // Store as hash code
            setColor(newColor);
        });
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setColor(String color) {
        rectangle.setFill(Color.web(color)); // Set the rectangle's color
    }

    // Convert the stored option (int) back into a color string
    private String convertOptionToColor(int option) {
        return option == "WHITE".hashCode() ? "WHITE" : "BLUE";
    }
}
