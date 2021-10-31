package chapter2.highArray;

public class HighArray {

    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }
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

//     2.1 Добавьте в класс HightArray из программы highArray.java метод getMax(), который
//     возвращает наибольшее значение ключа в массиве или -1, если массив пуст. Добавьте в
//     main() код для тестирования нового метода. Считайте, что все ключи являются
//     положительными числами.
    public long getMax() {
        if (nElems == 0) {
            return -1;
        } else {
            long max = 0;
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            return max;
        }
    }

//     2.2 Измените метод getMax() так, чтобы элемент с наибольшем ключом не только возвращался
//     методом, но и удалялся из массива. Присвойте новой версии имя removeMax().
    public long removeMax() {
        long max = getMax();
        delete(max);
        return max;
    }

//    2.3 Реализуйте алгоритм сортировки
    public void sort() {
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < nElems - 1; j++) {
                if (a[j] > a[j + 1]) {
                    long tmp;
                    tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
