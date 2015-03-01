package datastruct;

/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public class HeapFactory {
    public enum HeapType {
        MIN,
        MAX
    }

    public static Heap<Integer> getHeap(HeapType type, String[] array) {
        Heap<Integer> heap;
         switch(type) {
             case MIN:
                heap = new MinHeap<Integer>(array) {
                    @Override
                    protected Integer[] createElements(int length) {
                        return new Integer[length];
                    }

                    @Override
                    protected Integer toEl(String str) {
                        return Integer.decode(str);
                    }
                };
                 break;
             case MAX:
                 heap = new MaxHeap<Integer>(array) {
                     @Override
                     protected Integer[] createElements(int length) {
                         return new Integer[length];
                     }

                     @Override
                     protected Integer toEl(String str) {
                         return Integer.decode(str);
                     }
                 };
                 break;
             default:
                 heap = new MinHeap<Integer>(array) {
                     @Override
                     protected Integer[] createElements(int length) {
                         return new Integer[length];
                     }

                     @Override
                     protected Integer toEl(String str) {
                         return Integer.decode(str);
                     }
                 };
                 break;
         }
        return heap;
    }

    public static Heap<Integer> getHeap(HeapType type, Integer[] array) {
        Heap<Integer> heap;
        switch(type) {
            case MIN:
                heap = new MinHeap<Integer>(array) {
                    @Override
                    protected Integer[] createElements(int length) {
                        return new Integer[length];
                    }

                    @Override
                    protected Integer toEl(String str) {
                        return Integer.decode(str);
                    }
                };
                break;
            case MAX:
                heap = new MaxHeap<Integer>(array) {
                    @Override
                    protected Integer[] createElements(int length) {
                        return new Integer[length];
                    }

                    @Override
                    protected Integer toEl(String str) {
                        return Integer.decode(str);
                    }
                };
                break;
            default:
                heap = new MinHeap<Integer>(array) {
                    @Override
                    protected Integer[] createElements(int length) {
                        return new Integer[length];
                    }

                    @Override
                    protected Integer toEl(String str) {
                        return Integer.decode(str);
                    }
                };
                break;
        }
        return heap;
    }
}
