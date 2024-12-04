package ChainOfResponsibility;

public class Message {
    private String messageType;
    private String messageContent;
    private String senderEmail;

    public enum Type {
        COMPENSATION_CLAIMS,
        CONTACT_REQUESTS,
        DEVELOPMENT_SUGGESTIONS,
        GENERAL_FEEDBACK
    }

    public Message(Type messageType, String messageContent, String senderEmail) {
        this.messageType = String.valueOf(messageType);
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }
    public String getSenderEmail() {
        return senderEmail;
    }

}
