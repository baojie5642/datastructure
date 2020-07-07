package org.example;

public class Node {

    private Node next;
    private int date;

    private Node() {

    }

    public static final Node create() {
        return new Node();
    }

    public void setNext(final Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                '}';
    }
}
