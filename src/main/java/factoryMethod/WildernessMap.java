package factoryMethod;

import java.util.Random;

public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        super(width, height);
    }
    private Random random = new Random();

    @Override
    public Tile createTile() {
        int randomTile = random.nextInt(3);
        switch (randomTile) {
            case 0 ->{
                return new Swamp();
            }
            case 1 -> {
                return new Water();
            }
            case 2 -> {
                return new Forest();
            }
            default -> {
                return new Swamp();
            }
        }

    }
}
