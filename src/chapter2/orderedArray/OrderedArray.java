package chapter2.orderedArray;

public class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curId;

        while (true) {
            curId = (lowerBound + upperBound) / 2;
            if (a[curId] == searchKey) {
                return curId;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curId] < searchKey) {
                    lowerBound = curId + 1;
                } else {
                    upperBound = curId - 1;
                }
            }
        }
    }

    //    2.4 Измените программу orderedArray.java так, чтобы методы insert() и delete(), а так же
//    метод find() использовали двоичный поиск.
    public void insert(long value) {
        int j = 0;
        int lowerBound = 0;
        int upperBound = nElems - 1;

        while (lowerBound <= upperBound) {
            j = (lowerBound + upperBound) / 2;
            if (a[j] < value) {
                lowerBound = j + 1;
                j++;
            } else {
                upperBound = j - 1;
            }
        }

        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    //    2.4 Измените программу orderedArray.java так, чтобы методы insert() и delete(), а так же
//    метод find() использовали двоичный поиск.
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    //    2.5 Добавьте метод объединяющий два упорядоченных массива в один упорядоченный
//    приемный массив- алгоритм должен сравнивать ключи массивов и копировать меньший в Ф
//    приемный массив.
//    Задание сформулированно не до конца понятно, решение странное.
    public long[] merge(long[] firstArrayToMerge, long[] secondArrayToMerge) {
        long[] finalArray = new long[Math.max(firstArrayToMerge.length, secondArrayToMerge.length)];
        if (firstArrayToMerge.length > secondArrayToMerge.length) {
            int i = 0;
            for (; i < secondArrayToMerge.length; i++) {
                finalArray[i] = Math.min(firstArrayToMerge[i], secondArrayToMerge[i]);
            }
            for (; i < firstArrayToMerge.length; i++) {
                finalArray[i] = firstArrayToMerge[i];
            }
        } else {
            int i = 0;
            for (; i < firstArrayToMerge.length; i++) {
                finalArray[i] = Math.min(firstArrayToMerge[i], secondArrayToMerge[i]);
            }
            for (; i < secondArrayToMerge.length; i++) {
                finalArray[i] = secondArrayToMerge[i];
            }
        }
        return finalArray;
    }
}
