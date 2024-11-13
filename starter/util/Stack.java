package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top; // top of stack
    private int size; // size of the stack

    // Constructor
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Adds the item to this stack
     *
     * @param data the item to add
     */
    public void push(T data) {
        top = new Node(data, top);
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * @return if the stack is empty
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * @return the item most recently added to this stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    /**
     * @return an array representation of the items in this stack
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (T item : this) {
            array[i++] = item;
        }
        return array;
    }

    /**
     * @return the number of items in this stack
     */
    public int size() {
        return size;
    }

    /**
     * @return an iterator that iterates over the items in this stack in LIFO order
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}