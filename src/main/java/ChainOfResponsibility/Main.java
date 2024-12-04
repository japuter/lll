package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        // Instantiate handlers
        Handler compensationHandler = new CompensationClaimsHandler();
        Handler contactHandler = new ContactRequestsHandler();
        Handler developmentHandler = new DevelopmentSuggestionsHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        // Set up the chain of handlers
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(feedbackHandler);

        // Create sample feedback messages
        Message claimMessage = new Message(Message.Type.COMPENSATION_CLAIMS, "Requesting compensation for a defective product", "customer1@example.com");
        Message contactMessage = new Message(Message.Type.CONTACT_REQUESTS, "Need information about product availability", "customer2@example.com");
        Message suggestionMessage = new Message(Message.Type.DEVELOPMENT_SUGGESTIONS, "Suggesting a new feature for your application", "customer3@example.com");
        Message feedbackMessage = new Message(Message.Type.GENERAL_FEEDBACK, "Great job on the recent update!", "customer4@example.com");

        // Process each message
        System.out.println("Processing messages:\n");
        compensationHandler.handleMessage(claimMessage);
        compensationHandler.handleMessage(contactMessage);
        compensationHandler.handleMessage(suggestionMessage);
        compensationHandler.handleMessage(feedbackMessage);
    }
}
