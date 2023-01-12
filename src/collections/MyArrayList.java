package collections;

import static java.lang.System.arraycopy;

public class MyArrayList<T> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] objArray;
    private int size;

    public MyArrayList() {
        objArray = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int length) {
        objArray = new Object[length];
    }

    public void add(T element) {
        if (checkSize()) {
            makeBigger();
        }
        objArray[size++] = element;
    }

    public void addAll(MyArrayList<? extends T> collection) {
        Object[] newArray = new Object[collection.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = collection.get(i);
        }
        while ((objArray.length - size) < newArray.length) {
            makeBigger();
        }
        arraycopy(newArray, 0, objArray, size, newArray.length);
    }

    public T get(int index) {
        return (T) objArray[index];
    }

    public void remove(int index) {
        int boundary;
        if ((boundary = size - 1) > index)
            arraycopy(objArray, index + 1, objArray, index, boundary - index);
        objArray[size = boundary] = null;
    }

    public int size() {
        return size;
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        while (length != 0) {
            int maxIndex = 0;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    maxIndex = i;
                }
            }
            length = maxIndex;
        }
    }

    private void makeBigger() {
        Object[] newArray = new Object[size + (size / 2)];
        arraycopy(objArray, 0, newArray, 0, objArray.length);
        objArray = newArray;
    }

    private boolean checkSize() {
        return size == objArray.length;
    }
}
