package State;

public class MasterState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You are a Master. No need to train.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are a Master. Meditation is no longer necessary.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are a Master. Fighting is beneath you now.");
    }
}
