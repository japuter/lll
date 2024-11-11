package Strategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Random random = new Random();

        // Generate small data set
        int[] smallDataSet = new int[30];
        for (int i = 0; i < smallDataSet.length; i++) {
            smallDataSet[i] = random.nextInt(100);
        }

        // Generate large data set
        int[] largeDataSet = new int[100000];
        for (int i = 0; i < largeDataSet.length; i++) {
            largeDataSet[i] = random.nextInt(100000);
        }

        // Test with each sorting strategy on small data set
        System.out.println("Performance on small data set:");
        sorter.setStrategy(new BubbleSort());
        sorter.sortAndMeasure(smallDataSet);

        sorter.setStrategy(new SelectionSort());
        sorter.sortAndMeasure(smallDataSet);

        sorter.setStrategy(new MergeSort());
        sorter.sortAndMeasure(smallDataSet);

        // Test with each sorting strategy on large data set
        System.out.println("\nPerformance on large data set:");
        sorter.setStrategy(new BubbleSort());
        sorter.sortAndMeasure(largeDataSet);

        sorter.setStrategy(new SelectionSort());
        sorter.sortAndMeasure(largeDataSet);

        sorter.setStrategy(new MergeSort());
        sorter.sortAndMeasure(largeDataSet);
    }
}
