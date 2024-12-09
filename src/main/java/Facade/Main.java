package Facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade apiFacade = new SimpleApiFacade();

        // Example 1: Retrieve a random Chuck Norris joke
        try {
            String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Random Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.err.println("Error fetching Chuck Norris joke: " + e.getMessage());
        }

        // Example 2: Retrieve foreign exchange rates from an API (you may replace with a valid endpoint)
        try {
            String baseCurrency = apiFacade.getAttributeValueFromJson("https://api.exchangerate.host/latest", "base");
            System.out.println("Base Currency: " + baseCurrency);

            String rates = apiFacade.getAttributeValueFromJson("https://api.exchangerate.host/latest", "rates");
            System.out.println("Exchange Rates: " + rates);
        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}
