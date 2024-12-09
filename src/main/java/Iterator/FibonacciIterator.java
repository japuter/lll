package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0; // First previous value (F(n-2))
    private int curr = 1; // Second previous value (F(n-1))
    private int count = 0; // Number of elements generated
    private final int limit; // Limit for the sequence length

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the Fibonacci sequence.");
        }

        if (count == 0) {
            count++;
            return 1; // The first Fibonacci number is 1
        }

        int next = prev + curr; // F(n) = F(n-1) + F(n-2)
        prev = curr;
        curr = next;
        count++;
        return prev; // Return the current Fibonacci number
    }
}
