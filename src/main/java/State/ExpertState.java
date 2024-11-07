package State;

import factoryMethod.Game;

public class ExpertState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training ... +20 XP");
        character.gainExperience(20);

        //check if eligible for promotion to Master
        if (character.getExperiencePoints() >= 200) {
            System.out.println("Leveling up to Master!");
            character.setLevel(4);
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating ... +10 XP");
        character.gainHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting ... +30 XP , -20 HP");
        character.gainExperience(30);
        character.loseHealth(20);

    //Check health if too low warn player
    if (character.getHealthPoints() <= 0) {
    System.out.println("You have lost too much health! Rest to recover.");

    }
    }

}
