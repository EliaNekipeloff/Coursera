package datastruct;

import java.util.Arrays;

/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public abstract class Heap<T extends Comparable<T>> {
    protected T[] elements;
    protected int lastIndex;

    public Heap(int length) {
        this.elements = createElements(length);
    }

    public Heap(String[] array) {
        lastIndex = 0;
        elements = createElements(array.length);
        for (String str : array) {
            insert(toEl(str));
        }
    }

    public Heap(T[] array) {
        lastIndex = array.length;
        elements = array;
        heapify();
    }

    public void heapify() {
        for (int i = elements.length / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    protected abstract void bubbleDown(int i);



    public abstract void insert(T el);

    public T extract() {
        T el = elements[0];
        swap(0, lastIndex - 1);
        elements[lastIndex - 1] = null;
        if (lastIndex > 0) lastIndex--;
        bubbleDown(0);
        return el;
    }

    public T[] getElements() {
        return elements;
    }

    public void print() {
        for (T el : elements) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    protected int getParentIndex(int index) {
        return index / 2;
    }

    @SuppressWarnings("unchecked")
    protected abstract T[] createElements(int length);

    protected abstract T toEl(String str);

    protected void swap(int i, int j) {
        T buf = elements[i];
        elements[i] = elements[j];
        elements[j] = buf;
    }


    protected void increaseSize() {
        if (elements.length == lastIndex) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    protected void decreaseSize() {
        if (elements.length / 2 == lastIndex) {
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    protected int getFirstChildIndex(int index) {
        return 2 * index + 1;
    }

    protected int getSecondChildIndex(int index) {
        return 2 * index + 2;
    }

}
