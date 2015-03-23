package datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ella Nekipelova
 *         Date: 3/10/2015.
 */
public class HashTable<T> {
    private int size;
    private final static int INITIAL_SIZE = 10;
    private List<T>[] elements;
    private int next;

    public HashTable() {
        size = INITIAL_SIZE;
        elements = new List[size];
        next = 0;
    }

    public HashTable(int size) {
        this.size = size;
        elements = new List[size];
        next = 0;
    }

    public void put(T key) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        if (!find(key)) {
            int newIndex = hash(key);
            if (newIndex > size) {
                elements = Arrays.copyOf(elements, hash(key) * 2);
                size = newIndex + 1;
            }
            elements[newIndex] = new ArrayList<>();
            elements[newIndex].add(key);

        } else {
            if (elements[hash(key)] != null) {
                elements[hash(key)].add(key);
            } else throw new RuntimeException("illegal state");
        }
    }


    public void delete(T key) {
        int index = hash(key);
        if (index == -1) {
            throw new RuntimeException("Object " + key + "not found");
        }
        elements[index] = null;
    }

    public boolean find(T object) {
        int index = hash(object);
        boolean exists = false;
        boolean existsArray = elements[index] != null;
        if (existsArray ) {
            List<T> objArr = elements[index];
            for (T existingObj : objArr) {
                if (existingObj.equals(object)) {
                    exists = true;
                }
            }
        }
        return existsArray && exists;
    }



    public int getIndex(T key) {
        return hash(key);
    }
    private int hash(T key) {
        return Math.abs(key.hashCode()) % size;
    }
}
