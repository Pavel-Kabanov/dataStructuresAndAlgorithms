package chapter3.select;

import java.util.Calendar;

public class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    public void selectSort() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
        Long endTime = Calendar.getInstance().getTime().getTime();
        System.out.println(String.format("Select sorting of %s item(s) took %s second(s)", nElems, (endTime - startTime) / 1000));
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
