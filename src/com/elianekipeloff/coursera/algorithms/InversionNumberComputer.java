package com.elianekipeloff.coursera.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class provides the implementation of divide on conquer paradigm which is used to compute the number of inversions in an Integer array
 */
public class InversionNumberComputer {
    private int[] array;
    private long inversionsNum;
    private final int arrayLength;

    public InversionNumberComputer(String path, int arrayLength) {
        this.arrayLength = arrayLength;
        array = readData(path);
        inversionsNum = 0L;

    }

    public long getInversionsNumber() {
        inversionsNum = 0L;
        sort(array, 0, array.length - 1);
        return inversionsNum;
    }

    private void sort(int[] array, int low, int high) {
        if (high > low) {
            int middle = (low + high) / 2;
            sort(array, low, middle);
            sort(array, middle + 1, high);
            mergeAndCountInversions(array, low, middle, high);
        }
    }


    private void mergeAndCountInversions(int[] arr, int low, int middle, int high) {
        int i = low, j = middle + 1, k = 0;
        int num = high - low + 1;
        int[] temp = new int[num];
        while (i <= middle && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else if (arr[j] < arr[i]) {
                temp[k++] = arr[j++];
                for (int h = i; h <= middle; h++) {
                    inversionsNum = inversionsNum + 1;
                }
            }

        }
        while (i <= middle) {
            temp[k++] = arr[i++];

        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        int h = 0;
        for (i = low; i <= high; i++) {
            array[i] = temp[h++];
        }
    }


    private int[] readData(String path) {
        BufferedReader br;
        int[] data;
        try {
            br = new BufferedReader(new FileReader(path));
            data = new int[arrayLength];
        } catch (FileNotFoundException e) {
            System.out.println("input file not found");
            return null;
        }

        try {
            int i = 0;
            while (br.ready()) {
                data[i] = new Integer(br.readLine());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public int[] getArray() {
        return array;
    }

}

