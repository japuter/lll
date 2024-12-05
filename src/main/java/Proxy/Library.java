package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String creationDate, String content) {
        documents.put(id, new Document(id, creationDate, content));
    }

    public void addProtectedDocument(String id, String creationDate, String content) {
        Document document = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(document);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
