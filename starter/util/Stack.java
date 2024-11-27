package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic stack implementation using a singly linked list.
 *
 * @param <T> the type of elements in the stack
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Stack<T> implements Iterable<T> {

    /**
     * A node representing an element in the stack.
     */
    private class Node {
        T data;
        Node next;

        /**
         * Creates a new node with the specified data and reference to the next node.
         *
         * @param data the data stored in the node
         * @param next the next node in the stack
         */
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top; // Top of the stack
    private int size; // Size of the stack

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Adds an item to the top of this stack.
     *
     * @param data the item to add
     */
    public void push(T data) {
        top = new Node(data, top);
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the size of this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return a space-separated string of stack items in LIFO order
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
     * Returns an array representation of the items in this stack.
     *
     * @return an array of items in LIFO order
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
     * Returns an iterator that iterates over the items in this stack in LIFO order.
     *
     * @return an iterator for this stack
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
                    throw new NoSuchElementException("No more elements in the stack");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
