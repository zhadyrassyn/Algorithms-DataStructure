package ds.stack;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicStack<Item> implements Iterable<Item>{

    public Item[] a;
    private int N;

    public DynamicStack(int capacity) {
        a = (Item[]) new Object[capacity];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == a.length; }
    public void push(Item item) {
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public Item pop() {
        Item item  = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public Item peek() { return a[N-1]; }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

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
        DynamicStack<String> stack = new DynamicStack<>(max);
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
