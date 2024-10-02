package Observer;


// weatherStation is a Subject, meaning that it maintains a list of observers,
//and it's responsible for notifying the observers of any weather changes. also called "observable"
//Holds the temperature and manages the list of observers.
//Notifies observers whenever the temperature changes.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Subject {
    private float temperature;  //The current temperature
    private List<WeatherObserver> observers;  // List of observers
    private Random random;  //to simulate temperature changes

    public WeatherStation() {
        observers = new ArrayList<>(); // initialize list of observers
        temperature = 20.0f;
    }

    // add observer
    @Override
    public void addObserver(WeatherObserver observer){
        observers.add(observer);
    }

    //remove an observer
    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    //notify user of a change
    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature); // Call each observer's update method
        }
    }

    //Simulate temperature change
    public void setTemperature(float newTemperature) {
        this.temperature = newTemperature; // Change the temperature
        notifyObservers(); // Notify observers that the temperature has changed
    }


}
