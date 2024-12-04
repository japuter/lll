package Memento;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class HistoryWindow extends Stage {
    private final Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;

        // ListView to display the undo history
        ListView<Controller.Memento> historyList = new ListView<>();
        historyList.getItems().addAll(controller.getUndoHistory());

        // Restore state when a user clicks an item
        historyList.setOnMouseClicked(event -> {
            Controller.Memento selected = historyList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.restoreFromHistory(selected); // Restore selected state
                this.close(); // Close the history window
            }
        });

        Scene scene = new Scene(historyList, 300, 400);
        this.setScene(scene);
        this.setTitle("History");
    }
}
