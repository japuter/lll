package Strategy;

public class Sorter {
    private SortingStrategy strategy;

    // Method to set the sorting strategy at runtime
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Method to sort and measure performance
    public void sortAndMeasure(int[] array) {
        if (strategy == null) {
            System.out.println("Sorting strategy not set.");
            return;
        }

        // Clone the array to avoid modifying the original during testing
        int[] arrayCopy = array.clone();

        long startTime = System.nanoTime();
        strategy.sort(arrayCopy);
        long endTime = System.nanoTime();

        System.out.println(strategy.getClass().getSimpleName() + " took " + (endTime - startTime) + " nanoseconds.");
    }
}
