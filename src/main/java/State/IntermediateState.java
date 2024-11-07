package State;

public class IntermediateState implements State {
    @Override
    public void train (GameCharacter character) {
        System.out.println("Training ... +15 XP");
        character.gainExperience(15);


        //Check if eligible for promotion to Expert
        if (character.getExperiencePoints() >= 100) {
            System.out.println("Leveling up to Expert");
            character.setLevel(3);
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating ... +10 HP");
        character.gainHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediates cannot fight.");
    }


}
