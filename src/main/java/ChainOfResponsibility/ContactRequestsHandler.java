package ChainOfResponsibility;

import java.util.Objects;

public class ContactRequestsHandler extends AbstractHandler {
    @Override
    public void handleMessage(Message message) {
        if (Objects.equals(message.getMessageType(), String.valueOf(Message.Type.CONTACT_REQUESTS))) {
            System.out.println("Forwarding contact request to appropriate department: " + message);
        } else {
            passToNextHandler(message);
        }
    }
}
