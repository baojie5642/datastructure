package org.example;

public class FindLoop {

    private FindLoop() {

    }

    public static final FindLoop create() {
        return new FindLoop();
    }

    public final LoopStructure getLoop(Node head) {
        if (null == head) {
            return noLoop();
        }
        Node temp = head;
        if (null == temp.getNext()) {
            return noLoop();
        }
        Node slow = head;
        Node fast = head;
        boolean has = false;
        for (; null != fast.getNext() && null != fast.getNext().getNext(); ) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                has = true;
                break;
            }
        }
        if (has) {
            int count = 0;
            Node loopLenFlag = slow;
            // 处理长度远大于环长度的情况
            boolean meetLoopLenFlag = false;
            Node endFlag = fast;
            slow = head;
            for (; fast != slow; ) {
                slow = slow.getNext();
                fast = fast.getNext();
                if (endFlag.getNext() != fast) {
                    endFlag = endFlag.getNext();
                }
                if (fast != loopLenFlag) {
                    if (!meetLoopLenFlag) {
                        count++;
                    }
                } else {
                    if (!meetLoopLenFlag) {
                        count++;
                        meetLoopLenFlag = true;
                    }
                }
            }
            Node start = slow;
            Node end = endFlag;
            if (!meetLoopLenFlag) {
                for (; fast != loopLenFlag; ) {
                    fast = fast.getNext();
                    count++;
                }
            }
            return LoopStructure.create(start, end, count, true);
        } else {
            return noLoop();
        }
    }

    private final LoopStructure noLoop() {
        return LoopStructure.create(null, null, 0, false);
    }


    public static final void main(String args[]) {
        FindLoop findLoop = FindLoop.create();
        Node loop = CreateList.create().buildLoop(1189000, 78);
        LoopStructure structure = findLoop.getLoop(loop);
        System.out.println("loop is in list=" + structure.isHasLoop());
        System.out.println("loop length=" + structure.getLoopLength());
        System.out.println("loop start data=" + structure.getStart().getDate());
        System.out.println("loop end data=" + structure.getEnd().getDate());
    }

    private static final class LoopStructure {

        // 环的开始节点
        private final Node start;
        // 环的结束节点
        private final Node end;
        // 环的长度
        private final int loopLength;
        // 是否存在环
        private final boolean hasLoop;

        private LoopStructure(Node start, Node end, int loopLength, boolean hasLoop) {
            this.start = start;
            this.end = end;
            this.loopLength = loopLength;
            this.hasLoop = hasLoop;
        }

        public static final LoopStructure create(Node start, Node end, int loopLength, boolean hasLoop) {
            return new LoopStructure(start, end, loopLength, hasLoop);
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        public int getLoopLength() {
            return loopLength;
        }

        public boolean isHasLoop() {
            return hasLoop;
        }
    }

}
