package datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ella Nekipelova
 *         Date: 3/10/2015.
 */
public class HashSet<T> {
    private int headsNum;
    private final static int INITIAL_SIZE = 10;
    private List<T>[] elements;
    private int size;

    public HashSet() {
        headsNum = INITIAL_SIZE;
        elements = new List[headsNum];

    }

    public HashSet(int size) {
        this.headsNum = size;
        elements = new List[size];
    }

    public void put(T key) {
        if (headsNum == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        if (!find(key)) {
            int newIndex = key.hashCode();
            if (newIndex > headsNum) {
                elements = Arrays.copyOf(elements, hash(key) * 2);

            }
            elements[newIndex] = new ArrayList<>();
            elements[newIndex].add(key);
            size++;
            headsNum++;

        } else {
            if (elements[hash(key)] != null) {
                elements[hash(key)].add(key);
                size++;
            } else throw new RuntimeException("illegal state");
        }
    }


    public void remove(T key) {
        int index = hash(key);
        if (index == -1 || elements[index] == null) {
            throw new RuntimeException("Object " + key + " not found");
        }
        size--;
        if (elements[index].size() > 1) {
            Iterator<T> iterator = elements[index].iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(key)) {
                    iterator.remove();
                    break;
                }
            }
        } else {
            elements[index] = null;
        }

    }

    public boolean find(T object) {
        int index = hash(object);
        boolean exists = false;
        boolean existsArray = elements[index] != null;
        if (existsArray) {
            List<T> objArr = elements[index];
            for (T existingObj : objArr) {
                if (existingObj.equals(object)) {
                    exists = true;
                }
            }
        }
        return existsArray && exists;
    }


    public int size() {
        return size;
    }

    private int hash(T key) {
        return Math.abs(key.hashCode()) % headsNum;
    }


}
