package ChainOfResponsibility;

public interface Handler {
    void setNextHandler(Handler handler);
    void handleMessage(Message message);
}