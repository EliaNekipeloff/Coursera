package com.elianekipeloff.coursera.algorithms;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import datastruct.HashSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ella Nekipelova
 *         Date: 3/10/2015.
 */
public class TwoSumCounter {
    private Integer[] array;
    private static final int START = -20;
    private static final int END = 20;


    public TwoSumCounter(String path) throws IOException {
        array = DataReader.readIntegerArray(DataReader.getSourcePath(path));

    }


    public int countAll() {
        int count = 0;
        for (int i = START; i <= END; i++) {
            if (countWithSort(i) > 0) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public int count(int sum) {
        int count = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int el : array) {
            hashSet.put(el);
        }
        int i = 0;
        while (hashSet.size() > 0 && i < array.length) {
            int el = array[i];
            if (hashSet.find(el)) {
                hashSet.remove(el);
                int addition = sum - el;

                if (hashSet.find(addition)) {
                    count++;
                    hashSet.remove(addition);
                    System.out.println("Counted! " + sum + " = " + array[i] + " + " + addition);
                }

            }
            i++;
        }
        return count;
    }

    public int countWithSort(int sum) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int addition = sum - array[i];
            int startIndex = i + 1;
            int found;
            boolean founded = false;
            do {
                found = Arrays.binarySearch(array, startIndex, array.length -1, addition);
                if (found >= 0 ) {
                    startIndex = found + 1;
                    founded = true;
                }
            } while (found >= 0 && startIndex < array.length - 2);
            if (founded) count++;
        }
        return count;
    }

}
