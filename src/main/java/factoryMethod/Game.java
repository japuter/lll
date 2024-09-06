package factoryMethod;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Luodaan 5x5-kokoinen kaupunkikartta (CityMap)
        Map cityMap = new CityMap(5, 5);  // Annetaan leveys ja korkeus
        cityMap.generateMap();  // Generoidaan kartan laatat
        cityMap.display();  // Näytetään kartta

        // Luodaan 5x5-kokoinen erämaakartta (WildernessMap)
        Map wildernessMap = new WildernessMap(5, 5);  // Annetaan leveys ja korkeus
        wildernessMap.generateMap();  // Generoidaan kartan laatat
        wildernessMap.display();  // Näytetään kartta
    }
}
