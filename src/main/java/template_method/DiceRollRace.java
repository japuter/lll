package template_method;

import java.util.Random;

public class DiceRollRace extends Game{
    int[] scores;
    private int targetScore;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        scores = new int[numberOfPlayers];
        targetScore = 20;
        random = new Random();
        System.out.println("Starting a Dice roll game with " + numberOfPlayers + "players. First to reach " + targetScore + "wins!");
    }

    @Override
    public boolean endOfGame() {
        for (int score : scores) {
            if (score >= targetScore) {
                return true;
            }
        } return false;
    }

    @Override
    public void playSingleTurn(int player) {
        //Simulate rolling a die
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;
        System.out.println("Player " + (player + 1) + " rolls a " + roll + ". Total score: " + scores[player]);
    }

    @Override
    public void displayWinner() {
        int winningPlayer = -1;
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            winningPlayer = i;
            maxScore = scores[i];
        }
        System.out.println("Player " + (winningPlayer + 1) + " wins with a score of " + maxScore + "!");
    }



}
