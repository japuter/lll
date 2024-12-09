package Iterator;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer> { // Implements Iterable
    private final int limit; // Limit for the sequence length

    public FibonacciSequence(int limit) {
        this.limit = limit; // Maximum number of elements in the sequence
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}

