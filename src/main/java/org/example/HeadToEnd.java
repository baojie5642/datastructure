package org.example;

// 通过一次遍历找到倒数节点
public class HeadToEnd {

    private HeadToEnd() {

    }

    public static final HeadToEnd create() {
        return new HeadToEnd();
    }

    public Node nthNodeFromEnd(Node head, int nth) {
        if (null == head) {
            throw new NullPointerException();
        }
        if (null == head.getNext()) {
            throw new IllegalArgumentException();
        }
        Node temp = head;
        Node find = null;
        for (int i = 1; i < nth; i++) {
            if (null == temp) {
                break;
            } else {
                temp = temp.getNext();
            }
        }
        for (; null != temp; ) {
            if (null == find) {
                find = head;
            } else {
                find = find.getNext();
            }
            temp = temp.getNext();
        }
        if (null != find) {
            return find;
        } else {
            // 答印警告
            return null;
        }
    }

    public static final void main(String[] args) {
        CreateList create = CreateList.create();
        Node head = create.buildNormal(8);
        Node temp = head;
        for (; null != temp; ) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        HeadToEnd find = HeadToEnd.create();
        Node nth = find.nthNodeFromEnd(head, 5);
        System.out.println(nth);
    }

}
