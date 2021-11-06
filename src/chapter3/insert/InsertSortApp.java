package chapter3.insert;

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100000;
        ArrayIns arr = new ArrayIns(maxSize);

//        arr.insert(77);
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
//
//        arr.display();
//
//        arr.insertSort();
//
//        arr.display();
//        for (int i = 0; i < maxSize; i++) {
//            arr.insert((long) (Math.random() * (maxSize - 1)));
//        }

//        for (int i = 99999; i > 0; i--) {
//            arr.insert(i);
//        }

        for (int i = 0; i < maxSize; i++) {
            arr.insert(i);
        }

        arr.insertSort();
    }
}
