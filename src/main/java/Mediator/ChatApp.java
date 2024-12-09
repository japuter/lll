package Mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private ConcreteChatMediator mediator;

    @Override
    public void start(Stage primaryStage) {
        mediator = new ConcreteChatMediator();

        // Create three chat clients
        createChatClient("User1");
        createChatClient("User2");
        createChatClient("User3");
    }

    private void createChatClient(String username) {
        Stage stage = new Stage();
        stage.setTitle(username);

        // Chat display area
        TextArea chatDisplay = new TextArea();
        chatDisplay.setEditable(false);
        chatDisplay.setPrefHeight(300);

        // Message input area
        TextField messageInput = new TextField();
        messageInput.setPromptText("Type your message here...");

        // Recipient selection
        ComboBox<String> recipientSelection = new ComboBox<>();
        recipientSelection.getItems().addAll("All", "User1", "User2", "User3");
        recipientSelection.setValue("All");

        // Send button
        Button sendButton = new Button("Send");

        // Chat client
        ChatClient client = new ChatClient(username, mediator, chatDisplay);

        // Send button action
        sendButton.setOnAction(e -> {
            String message = messageInput.getText();
            String recipient = recipientSelection.getValue();
            if (!message.isEmpty()) {
                client.sendMessage(message, recipient);
                chatDisplay.appendText("Me: " + message + "\n");
                messageInput.clear();
            }
        });

        // Layout
        VBox layout = new VBox(10, chatDisplay, new HBox(10, recipientSelection, messageInput, sendButton));
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
