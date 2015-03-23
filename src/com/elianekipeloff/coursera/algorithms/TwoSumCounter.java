package com.elianekipeloff.coursera.algorithms;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import datastruct.HashTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ella Nekipelova
 *         Date: 3/10/2015.
 */
public class TwoSumCounter {
    private Integer[] array;
    private static final int START = 10;
    private static final int END = 10;

    public TwoSumCounter(String path) throws IOException {
        array =  DataReader.readIntegerArray(DataReader.getSourcePath(path));

    }

    public int[] readData(String path, int size) throws IOException {
        int[] array = new int[size];
        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while (reader.ready()) {
            array[i] = Integer.valueOf(reader.readLine());

        }
        return array;
    }

    public int countAll() {
        int number = 0;
        for (int i = START; i <= END; i++) {
            number += count(i);
        }
        return number;
    }
    public  int count(int sum) {
        HashTable<Integer> hashTable = new HashTable<>(array.length);
        for (int el : array) {
            hashTable.put(el);
        }
        int num = 0;
        for (int el : array) {
            int addition = sum >= 0 ? sum - el : sum + el;
            boolean exists = hashTable.find(addition);
            if (addition != el && exists) {
                num++;
            }
        }
        return num/2;
    }

    public  int count() {
        int sum = 5;
        HashTable<Integer> hashTable = new HashTable<>(array.length);
        for (int el : array) {
            hashTable.put(el);
        }
        int num = 0;
        for (int el : array) {
            int addition = sum > 0 ? sum - el : sum + el;
            boolean exists = hashTable.find(addition);
            if (addition != el && exists) {
                num++;
            }
        }
        return num/2;
    }
}
