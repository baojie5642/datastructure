package org.example;

public class CreateList {

    private CreateList() {

    }

    public static final CreateList create() {
        return new CreateList();
    }

    public final Node buildNormal(int length) {
        return build(length).getHead();
    }

    private final HeadTail build(int length) {
        final Node head = Node.create();
        Node current = head;
        for (int i = 0; i < length; i++) {
            Node node = Node.create();
            node.setDate(i + 1);
            current.setNext(node);
            current = node;
        }
        final HeadTail ht = HeadTail.create(head, current);
        return ht;
    }

    public final Node buildLoop(int listLength, int loopLength) {
        if (listLength < 0) {
            throw new IllegalArgumentException();
        }
        if (listLength == 0) {
            return Node.create();
        }
        if (loopLength <= 0) {
            return buildNormal(listLength);
        }
        if (loopLength > listLength) {
            throw new IllegalArgumentException();
        }
        HeadTail ht = build(listLength);
        Node head = ht.getHead();
        Node tail = ht.getTail();
        if (loopLength == listLength) {
            tail.setNext(head.getNext());
        } else {
            Node temp = head;
            int dur = listLength - loopLength;
            for (int i = 0; i < dur; i++) {
                temp = temp.getNext();
            }
            tail.setNext(temp.getNext());
        }
        return head;
    }

    private static final class HeadTail {
        private final Node head;
        private final Node tail;

        private HeadTail(final Node head, final Node tail) {
            this.head = head;
            this.tail = tail;
        }

        public static final HeadTail create(final Node head, final Node tail) {
            return new HeadTail(head, tail);
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }
    }


}
