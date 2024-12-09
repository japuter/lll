package Mediator;

import javafx.scene.control.TextArea;

public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private TextArea chatDisplay;

    public ChatClient(String username, ChatMediator mediator, TextArea chatDisplay) {
        this.username = username;
        this.mediator = mediator;
        this.chatDisplay = chatDisplay;
        mediator.addClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(message, username, recipient);
    }

    public void receiveMessage(String message, String sender) {
        chatDisplay.appendText(sender + ": " + message + "\n");
    }
}
