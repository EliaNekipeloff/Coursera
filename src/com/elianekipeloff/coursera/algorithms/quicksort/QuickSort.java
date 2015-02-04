package com.elianekipeloff.coursera.algorithms.quicksort;

/**
 * @author Ella Nekipelova
 *         Date: 2/2/2015.
 */
public class QuickSort<T extends Comparable> {

    private T[] array;
    private final PivotTypes type;
    private long comparisonsQuantity;

    public QuickSort(PivotTypes type, T[] array) {
        this.type = type;
        this.array = array;
    }


    public T[] sort() {
        sort(0, array.length - 1);
        return array;
    }

    private void sort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            sort(left, pivotIndex - 1);
            sort(pivotIndex + 1, right);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(int left, int right) {
        comparisonsQuantity += right - left;
        int pivotIndex = getPivotIndex(left, right);
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, left);
        int i = left + 1;
        for (int j = i; j <= right; j++) {
            if (array[j].compareTo(pivot) == -1) {
                swap(array, i, j);
                i++;
            }
        }
        int newPivotIndex = i - 1;
        swap(array, left, newPivotIndex);
        return newPivotIndex;
    }


    private void swap(T[] array, int i, int j) {
        T buf = array[j];
        array[j] = array[i];
        array[i] = buf;
    }

    @SuppressWarnings("unchecked")
    private int getPivotIndex(int left, int right) {
        int index;
        switch (type) {
            case LEFT:
                index = left;
                break;
            case RIGHT:
                index = right;
                break;
            case MEDIAN:
                int mid = (right - left) / 2;
                int lr = array[left].compareTo(array[right]);
                int mr = array[mid].compareTo(array[right]);
                int lm = array[mid].compareTo(array[left]);
                if (mr != lm) index = mid;
                else if (lr != lm) index = left;
                else index = right;
                break;
            default:
                index = left;

        }
        return index;
    }

    public long getComparisonsQuantity() {
        return comparisonsQuantity;
    }

    public void printArray() {
        for (T el : array) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public enum PivotTypes {
        LEFT,
        RIGHT,
        MEDIAN
    }
}
