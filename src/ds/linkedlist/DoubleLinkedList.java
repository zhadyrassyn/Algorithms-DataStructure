package ds.linkedlist;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> extends AbstractList<E> {

    Node<E> head;
    Node<E> tail;

    private int N;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.N = 0;
    }

    public void addFront(E data) {
        Node<E> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        ++N;
    }

    public void addBack(E data) {
        Node<E> newNode = new Node<>(data);
        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        ++N;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        if(index == 0) addFront(element);
        else if(index == size()-1) addBack(element);
        else {
            Node<E> mid = new Node<>(element);

            Node<E> first = head;
            while(--index > 0) {
                first = first.next;
            }

            Node<E> third = first.next;

            first.next = mid;
            mid.prev = first;
            mid.next = third;
            third.prev = mid;

            ++N;
        }
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        while(index-- > 0) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        while(index-- > 0) {
            temp = temp.next;
        }

        E data = temp.data;
        temp.data = element;
        return data;
    }

    @SuppressWarnings("Duplicates")
    public E removeFirst() {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = head;
        E data = temp.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        --N;

        return data;
    }

    @SuppressWarnings("Duplicates")
    public E removeLast() {
        if(tail == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = tail;
        E data = temp.data;
        tail = tail.prev;
        if(tail == null) {
            head = null;
        }
        --N;

        return data;

    }


    @Override
    public E remove(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        if(index == 0) return removeFirst();
        else if(index == size()-1) return removeLast();
        else {
            Node<E> mid = head;
            while(index-- > 0) {
                mid = mid.next;
            }

            E data = mid.data;

            Node<E> first = mid.prev;
            Node<E> third = mid.next;

            first.next = third;
            third.prev = first;

            --N;

            return data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(head);
    }

    private class ListIterator<E> implements Iterator<E> {

        Node<E> first;

        ListIterator(Node<E> head) {
            this.first = head;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            E data = first.data;
            first = first.next;
            return data;
        }
    }
    private class Node<E> {
        Node<E> next;
        Node<E> prev;
        E data;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for(int i = 0; i < 5; i++) {
            doubleLinkedList.addBack(i);
        }

        doubleLinkedList.add(0, 22);
        doubleLinkedList.add(1, 23);

        doubleLinkedList.set(2, 24);

        for(int item: doubleLinkedList) {
            System.out.print(item + ", ");
        }
        System.out.println();

        System.out.println("REMOVED: " + doubleLinkedList.remove(1));
        System.out.println("REMOVED: " + doubleLinkedList.remove(1));
        System.out.println("REMOVED: " + doubleLinkedList.remove(1));

        for(int item: doubleLinkedList) {
            System.out.println(item);
        }
    }
}
