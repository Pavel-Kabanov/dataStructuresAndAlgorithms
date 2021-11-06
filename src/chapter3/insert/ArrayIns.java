package chapter3.insert;

import java.util.Calendar;

public class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void insertSort() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }

        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Insert sorting of %s item(s) took %s second(s)", nElems, (endTime - startTime) / 1000));
    }

    public long median() {
        insertSort();
        if (nElems % 2 != 0) {
            return a[nElems / 2];
        } else {
            return (a[nElems / 2 - 1] + a[nElems / 2]) / 2;
        }
    }
}
