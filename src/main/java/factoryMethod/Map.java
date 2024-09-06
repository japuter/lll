package factoryMethod;

abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;  // Karan laatat 2D-taulukkona

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
    }
    public abstract Tile createTile();// Tehdasmetodi, jonka konkreettinen kartta toteuttaa

    public void generateMap() {
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }
    public void display() {
        // Tämä metodi näyttää kartan merkkimatriisina
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");  // Näytetään laatan merkki
            }
            System.out.println();  // Rivinvaihto
        }
    }
}

