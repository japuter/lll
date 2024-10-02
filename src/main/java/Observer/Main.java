package Observer;

public class Main {
    public static void main(String[] args) {

        //Create a weather station
        WeatherStation newWeatherStation = new WeatherStation();

        //Now create ConcreteWeatherObserver objects/Observers (Phone and Apple Watch)
        ConcreteWeatherObserver phone = new ConcreteWeatherObserver("Phone");
        ConcreteWeatherObserver apple_watch = new ConcreteWeatherObserver("Apple Watch");
        ConcreteWeatherObserver android = new ConcreteWeatherObserver("Android");
        ConcreteWeatherObserver computer = new ConcreteWeatherObserver("Computer");


        // Now we register them with WeatherStation so they receive weather updates

        newWeatherStation.addObserver(phone);
        newWeatherStation.addObserver(apple_watch);
        newWeatherStation.addObserver(android);
        newWeatherStation.addObserver(computer);


        //Simulate temperature change

        newWeatherStation.setTemperature(25.0f);
        newWeatherStation.setTemperature(30.0f);

        // Remove an observer and continue updating
        System.out.println("\nRemoving Smartwatch...\n");
        newWeatherStation.removeObserver(apple_watch);


        //change temperature now that one observer has been removed
        newWeatherStation.setTemperature(5.0f);






    }

}
