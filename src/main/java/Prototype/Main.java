package Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Recommendation> recommendations = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View Recommendations");
            System.out.println("2. Add New Recommendation");
            System.out.println("3. Clone and Modify Recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewRecommendations(recommendations);
                case 2 -> addNewRecommendation(scanner, recommendations);
                case 3 -> cloneAndModifyRecommendation(scanner, recommendations);
                case 4 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewRecommendations(List<Recommendation> recommendations) {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {
            for (int i = 0; i < recommendations.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + recommendations.get(i));
            }
        }
    }

    private static void addNewRecommendation(Scanner scanner, List<Recommendation> recommendations) {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();
        Recommendation recommendation = new Recommendation(audience);

        while (true) {
            System.out.print("Add a book (Y/N)? ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) break;

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter book genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter book publication year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            recommendation.addBook(new Book(title, author, genre, year));
        }

        recommendations.add(recommendation);
        System.out.println("Recommendation added!");
    }

    private static void cloneAndModifyRecommendation(Scanner scanner, List<Recommendation> recommendations) {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations to clone.");
            return;
        }

        viewRecommendations(recommendations);
        System.out.print("Select a recommendation to clone (by number): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Recommendation cloned = recommendations.get(index).clone();
        System.out.print("Enter new target audience: ");
        String newAudience = scanner.nextLine();
        cloned = new Recommendation(newAudience);

        while (true) {
            System.out.print("Modify books (add/remove/finish)? ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("finish")) break;

            if (action.equalsIgnoreCase("add")) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                System.out.print("Enter book genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter book publication year: ");
                int year = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                cloned.addBook(new Book(title, author, genre, year));
            } else if (action.equalsIgnoreCase("remove")) {
                System.out.print("Enter title of book to remove: ");
                String title = scanner.nextLine();
                cloned.removeBook(title);
            } else {
                System.out.println("Invalid action. Please try again.");
            }
        }

        recommendations.add(cloned);
        System.out.println("Cloned recommendation modified and added!");
    }
}
