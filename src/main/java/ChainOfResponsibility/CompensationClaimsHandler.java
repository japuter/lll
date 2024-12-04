package ChainOfResponsibility;

import java.util.Objects;

public class CompensationClaimsHandler extends AbstractHandler{

    @Override
    public  void handleMessage(Message message) {
        if (Objects.equals(message.getMessageType(), String.valueOf(Message.Type.COMPENSATION_CLAIMS))){
            System.out.println("Processing compensation claim: " + message);
        } else {
            passToNextHandler(message);
        }
    }

}
