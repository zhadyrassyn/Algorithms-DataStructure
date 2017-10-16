package ds.stack;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String>{

    public String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == a.length; }
    public void push(String item) { a[N++] = item; };
    public String pop() { return a[--N]; }
    public String peek() { return a[N-1]; }

    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<String> {

        private int i = N-1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public String next() {
            if(!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        while(StdIn.hasNextToken()) {
            String item = StdIn.next();
            stack.push(item);
            StdOut.print(stack.pop() + " ");
        }

        StdOut.println("\nLeft:");
        for(String item: stack) {
            StdOut.print(item + " ");
        }

        StdOut.flush();
    }
}
