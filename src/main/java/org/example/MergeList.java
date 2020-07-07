package org.example;

/**
 * Hello world!
 */
public class MergeList {
    private MergeList() {

    }

    public static final MergeList create() {
        return new MergeList();
    }

    public int[] merge(int[] first, int[] second) {
        if (null == first || null == second) {
            return new int[0];
        } else {
            if (first.length == 0) {
                return second;
            } else if (second.length == 0) {
                return first;
            } else {
                int f = first.length;
                int s = second.length;
                int t = f + s;
                int[] third = new int[t];
                int i = 0;
                int j = 0;
                int k = 0;
                for (; ; ) {
                    if (i < f && j < s) {
                        if (first[i] < second[j]) {
                            third[k] = first[i];
                            k++;
                            i++;
                        } else if (first[i] == second[j]) {
                            third[k] = first[i];
                            k++;
                            i++;
                            third[k] = second[j];
                            k++;
                            j++;
                        } else {
                            third[k] = second[j];
                            k++;
                            j++;
                        }
                    } else {
                        break;
                    }
                }
                for (; i < f; ) {
                    third[k] = first[i];
                    k++;
                    i++;
                }
                for (; j < s; ) {
                    third[k] = second[j];
                    k++;
                    j++;
                }
                return third;
            }
        }
    }

    public static void main(String[] args) {
        int[] first = new int[99999999];
        int[] second = new int[99999999];
        for (int i = 0; i < 99999999; i++) {
            first[i] = i + 1;
            second[i] = i + 3;
        }
        long sum = 0;
        int times = 32;
        for (int i = 0; i < times; i++) {
            long s = System.currentTimeMillis();
            System.out.println("init done, ");
            MergeList mergeList = MergeList.create();
            int[] third = mergeList.merge(first, second);
            long e = System.currentTimeMillis();
            long cust = e - s;
            sum = sum + cust;
            System.out.println(third.length + ", cust=" + cust);
        }
        long vurge = sum / times;
        System.out.println("vurge=" + vurge);
    }
}
