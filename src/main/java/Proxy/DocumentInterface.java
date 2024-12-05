package Proxy;

public interface DocumentInterface {
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
