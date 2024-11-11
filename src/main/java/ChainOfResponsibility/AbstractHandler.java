package ChainOfResponsibility;

public abstract class AbstractHandler implements Handler {
    protected Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    protected void passToNextHandler(Message message) {
        if (nextHandler != null) {
            nextHandler.handleMessage(message);
        } else {
            System.out.println("No handler found for message type: " + message.getMessageType());
        }
    }
}