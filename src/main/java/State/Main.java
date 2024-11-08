package State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter("Hero");
        Scanner scanner = new Scanner(System.in);

        while (character.getLevel() < 4) { // While character is not a master
            character.displayStatus();
            System.out.println("Choose an action: train, meditate, fight");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action. Choose again.");
            }
        }

        System.out.println("Congratulations! You've reached Master level!");
        scanner.close();
    }
}
