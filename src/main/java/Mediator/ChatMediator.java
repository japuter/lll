package Mediator;

import java.util.ArrayList;
import java.util.List;

public interface ChatMediator {
    void sendMessage(String message, String sender, String recipient);
    void addClient(ChatClient client);
}
