package ChainOfResponsibility;


import java.util.Objects;

public class DevelopmentSuggestionsHandler extends AbstractHandler {
    @Override
    public void handleMessage(Message message) {
        if (Objects.equals(message.getMessageType(), String.valueOf(Message.Type.DEVELOPMENT_SUGGESTIONS))) {
            System.out.println("Logging development suggestion for prioritization: " + message);
            // Additional logic for logging suggestions can go here
        } else {
            passToNextHandler(message);
        }
    }
}