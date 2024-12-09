package Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence(10);

        for (int number : fibonacciSequence) {
            System.out.print(number + " ");
        }
    }
}
