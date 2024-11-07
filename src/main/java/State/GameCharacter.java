package State;

import factoryMethod.Game;

public class GameCharacter {
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;
    private State currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1; // starts at novice level
        this.experiencePoints = 0;
        this.healthPoints = 100; // default health points
        this.currentState = new NoviceState(); // initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void gainExperience(int points) {
        this.experiencePoints += points;
    }

    public void gainHealth(int points) {
        this.healthPoints += points;
    }

    public void loseHealth(int points) {
        this.healthPoints -= points;
    }

    // delegate actions to the current state
    public void train() {
        currentState.train(this);
    }

    public void meditate() {
        currentState.meditate(this);
    }

    public void fight() {
        currentState.fight(this);
    }

    //Getters and setters for experience points, health, etc-
    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void displayStatus() {
        System.out.println("Name: " + name + ", Level: " + level + ", XP: " + experiencePoints + ", HP: " + healthPoints);
    }



}

