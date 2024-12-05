package Proxy;

public class Document implements DocumentInterface {
    private final String id;
    private final String creationDate;
    private final String content;

    public Document(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content; // No access control here; proxies handle it.
    }
}
