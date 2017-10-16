package ds.stack;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item>{

    public Item[] a;
    private int N;

    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == a.length; }
    public void push(Item item) { a[N++] = item; };
    public Item pop() { return a[--N]; }
    public Item peek() { return a[N-1]; }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N-1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(max);
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
