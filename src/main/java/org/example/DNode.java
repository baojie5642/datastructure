package org.example;

public class DNode {

    private DNode next;
    private DNode priv;

    private int data;

    private DNode() {

    }

    private static final DNode create() {
        return new DNode();
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPriv() {
        return priv;
    }

    public void setPriv(DNode priv) {
        this.priv = priv;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "data=" + data +
                '}';
    }
}
