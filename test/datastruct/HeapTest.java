package datastruct;

import org.junit.Test;


import static org.junit.Assert.*;
/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public class HeapTest {

    @Test
    public void testCreationFromString() {
        String[] array = new String[] {"2", "1", "4", "10", "5", "8", "4", "3", "7"};
        Heap<Integer> heap = HeapFactory.getHeap(HeapFactory.HeapType.MIN, array);
        heap.print();
        Integer min = 1;
        assertEquals(heap.extract(), min);
    }

    @Test
    public void testCreation() {
        Integer[] array = new Integer[] {10,9,4,3,7,3,2,5,7};
        Heap<Integer> heap = HeapFactory.getHeap(HeapFactory.HeapType.MIN, array);
        heap.print();
        Integer min = 2;
        assertEquals(heap.extract(), min);
    }

    @Test
    public void testExtractAll() {
        String[] array = new String[] {"2", "1", "4", "10", "5", "8", "4", "3", "7"};
        Heap<Integer> heap = HeapFactory.getHeap(HeapFactory.HeapType.MIN, array);
        int i = 0;
        while (i < array.length -1) {
            System.out.println(heap.extract());
            i++;
        }
        Integer max = 10;
        assertEquals(max, heap.extract());
    }
}
