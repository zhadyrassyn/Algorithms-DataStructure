package ds.bag;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>{

    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldNode = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldNode;
        n++;
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while(StdIn.hasNextToken()) {
            bag.add(StdIn.next());
        }

        StdOut.println("Size: " + bag.size());
        for(String s: bag) {
            StdOut.println(s);
        }
        StdOut.flush();

    }
}
