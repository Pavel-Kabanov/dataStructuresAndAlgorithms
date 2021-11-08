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

    // HW 3.5
    public void insertSortWithCount() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        int in, out;
        int counterCopy = 0;
        int counterComparison = 0;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            counterCopy++;
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
                counterCopy++;
                counterComparison++;
            }
            a[in] = temp;
            counterCopy++;
        }

        System.out.println("counterCopy: " + counterCopy);
        System.out.println("counterComparison: " + counterComparison);
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

    //    HW 3.3 and 3.6
    public void noDups() {
        insertSort();

        long[] tmp = new long[nElems];
        int i, j;

        for (i = j = 0; i < nElems; i++) {
            if (j == 0) {
                tmp[j] = a[i];
                j++;
            } else {
                if (tmp[j - 1] != a[i]) {
                    tmp[j] = a[i];
                    j++;
                }
            }
        }

        a = tmp;
        nElems = j;
    }
}
