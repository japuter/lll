package Proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");

        // Add documents
        library.addUnprotectedDocument("doc1", "2023-01-01", "Unprotected content of doc1");
        library.addProtectedDocument("doc2", "2023-02-01", "Protected content of doc2");

        // Grant access
        acs.grantAccess("doc2", "alice");

        // Test access
        try {
            System.out.println("Alice accessing doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("Alice accessing doc2: " + library.getDocument("doc2").getContent(alice));
            System.out.println("Bob accessing doc2: " + library.getDocument("doc2").getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
