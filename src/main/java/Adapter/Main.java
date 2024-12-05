package Adapter;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the adapter
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        // Set a date
        dateAdapter.setYear(2024);
        dateAdapter.setMonth(12); // December
        dateAdapter.setDay(5);

        // Print the initial date
        System.out.println("Initial Date: " + dateAdapter.getDay() + "/" +
                dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        // Advance the date by 10 days
        dateAdapter.advanceDays(10);

        // Print the updated date
        System.out.println("Updated Date: " + dateAdapter.getDay() + "/" +
                dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}
