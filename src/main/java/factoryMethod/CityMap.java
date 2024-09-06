package factoryMethod;

import java.util.Random;

public class CityMap extends Map {

    public CityMap(int width, int height) {
        super(width, height);
    }
    private Random random = new Random();

    @Override
    public Tile createTile() {
        int randomTile = random.nextInt(3);
        switch (randomTile) {
            case 0 -> {
                return new Road();
            }
            case 1 -> {
                return new Forest();
            }
            case 2 -> {
                return new Building();
            }
            default -> {
                return new Road();
            }
        }
    }
}
