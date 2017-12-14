package ds.linkedlist;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> implements Iterable<E>{

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public void addFront(E data) {
        Node<E> newNode = new Node<E>(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<E>(data);
        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }

    public E removeFirst() {
        if(head == null) throw new NullPointerException();
        E data = head.data;
        head = head.next;

        --size;

        return data;
    }


    @Override
    public E get(int index) {
        if(index < size && index >= 0) {
            Node<E> temp = head;
            while(--index >= 0) {
                temp = temp.next;
            }
            return temp.data;
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(int position, E data) {
        if(position < 0 || position >= size) throw new IndexOutOfBoundsException();
        if(position == 0) {
            addFront(data);
            return;
        }

        Node<E> newNode = new Node<>(data);

        Node<E> first = head;
        int temp = position - 2;
        while(temp-- >= 0) {
            first = first.next;
        }
        Node<E> second = first.next;
        first.next = newNode;
        newNode.next = second;

        ++size;
    }

    public E remove(int position) {
        if(position >= size || position < 0) throw new IndexOutOfBoundsException();
        if(position == 0) removeFirst();

        Node<E> first = head;

        int temp = position;
        temp -= 2;
        while(temp-- >= 0) {
            first = first.next;
        }
        Node<E> mid = first.next;
        Node<E> last = mid.next;
        E data = mid.data;

        first.next = last;

        if(position == size -1) {
            tail = first;
        }
        --size;

        return data;
    }

    public void reversePrint() {
        Node temp = head;
        reversePrint(temp);
    }

    private void reversePrint(Node head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }

    public void reverse() {
        reverse(head);
    }

    private void reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        tail = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;

    }

    @Override
    public E set(int position, E data) {
        if(position < 0 || position >= size) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        while(--position >= 0) {
            temp = temp.next;
        }
        E val = temp.data;
        temp.data = data;
        return val;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<E> {
        Node<E> next;
        E data;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(head);
    }

    private class ListIterator<E> implements Iterator<E> {

        Node<E> head;

        ListIterator(Node<E> first) {
            this.head = first;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = head.data;
            head = head.next;
            return data;
        }
    }



    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFront(123);
        linkedList.addFront(56);
        linkedList.addFront(23);

        linkedList.reversePrint();


    }
}
