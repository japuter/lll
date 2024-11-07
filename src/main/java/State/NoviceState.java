package State;

public class NoviceState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +10 XP");
        character.gainExperience(10);

        //Check if eligible for promotion to Intermediate
        if (character.getExperiencePoints() >= 50) {
            System.out.println("Leveling up to Intermediate");
            character.setLevel(2);
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("novices cannot meditate");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("novices cannot fight");
    }
}
