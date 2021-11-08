package chapter3.bubble;

import java.util.Calendar;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void sortBubble() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Bubble sorting of %s item(s) took %s second(s)", nElems, (endTime - startTime) / 1000));
    }

    public void sortBubbleUpgraded() {
        Long startTime = Calendar.getInstance().getTime().getTime();

        int out, outRight, outLeft, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
                if (in - 1 >= 0 && a[in] < a[in - 1]) {
                    swap(in, in - 1);
                }
            }
        }
        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Upgraded bubble sorting of %s item(s) took %s second(s)", nElems, (endTime - startTime) / 1000));
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    // HW 3.4
    public void sortEvenOdd() {
        for (int i = 0; i < nElems; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j < nElems - 1; j = j + 2) {
                    if (a[j] > a[j + 1]) {
                        swap(j, j + 1);
                    }
                }
            } else {
                for (int j = 0; j < nElems - 1; j = j + 2) {
                    if (a[j] > a[j + 1]) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }
}
