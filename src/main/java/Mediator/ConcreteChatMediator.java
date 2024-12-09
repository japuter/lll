package Mediator;

import java.util.ArrayList; // Import ArrayList
import java.util.List;      // Import List

public class ConcreteChatMediator implements ChatMediator {
    private List<ChatClient> clients; // Use List from java.util

    public ConcreteChatMediator() {
        this.clients = new ArrayList<>(); // Initialize with ArrayList
    }

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        for (ChatClient client : clients) {
            if (client.getUsername().equals(recipient) || recipient.equals("All")) {
                client.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void addClient(ChatClient client) {
        this.clients.add(client);
    }
}
