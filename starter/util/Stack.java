package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T>{
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
}