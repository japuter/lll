package Observer;

public interface Subject {
    void addObserver(WeatherObserver observer); //register observer
    void removeObserver(WeatherObserver observer); //unregister observer
    void notifyObservers(); //notify all observers of a change

}
