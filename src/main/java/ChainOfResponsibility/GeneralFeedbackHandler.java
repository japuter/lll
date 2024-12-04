package ChainOfResponsibility;

import java.util.Objects;

public class GeneralFeedbackHandler extends AbstractHandler {
    @Override
    public void handleMessage(Message message) {
        if (Objects.equals(message.getMessageType(), String.valueOf(Message.Type.GENERAL_FEEDBACK))) {
            System.out.println("Analyzing and responding to general feedback: " + message);
            // Additional logic for responding to general feedback can go here
        } else {
            passToNextHandler(message);
        }
    }
}
