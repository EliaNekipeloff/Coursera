package datastruct;

/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public abstract class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(int length) {
        super(length);
    }

    public MaxHeap(String[] array) {
        super(array);
    }

    public MaxHeap(T[] array) {
        super(array);
    }


    @Override
    public void insert(T el) {
        increaseSize();
        elements[lastIndex] = el;
        int parentIndex = getParentIndex(lastIndex);
        int elIndex = lastIndex;
        lastIndex++;
        while (elements[parentIndex].compareTo(el) == -1) {
            swap(elIndex, parentIndex);
            elIndex = parentIndex;
            parentIndex = getParentIndex(elIndex);
        }
    }


    protected void bubbleDown(int i) {
        int currentParentIndex = i;
        int child1Index = getFirstChildIndex(i);
        if (child1Index < lastIndex) {
            int indexToSwap = getChildIndexToSwap(currentParentIndex);
            while (indexToSwap < lastIndex && elements[currentParentIndex].compareTo(elements[indexToSwap]) == -1) {
                swap(indexToSwap, currentParentIndex);
                currentParentIndex = indexToSwap;
                indexToSwap = getChildIndexToSwap(currentParentIndex);

            }
        }
    }

    private int getChildIndexToSwap(int i) {
        int child1Index = getFirstChildIndex(i);
        int child2Index = getSecondChildIndex(i);
        int indexToSwap;
        if (child1Index > lastIndex || child2Index > lastIndex) {
            indexToSwap = lastIndex;
        } else {
            indexToSwap = elements[child2Index] == null || elements[child1Index].compareTo(elements[child2Index]) == 1 ? child1Index : child2Index;
        }
        return indexToSwap;

    }
}
