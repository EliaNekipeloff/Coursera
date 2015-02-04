package com.elianekipeloff.coursera.algorithms;

import com.elianekipeloff.coursera.algorithms.util.DataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class provides the implementation of divide on conquer paradigm which is used to compute the number of inversions in an Integer array
 */
public class InversionNumberComputer {
    private Integer[] array;
    private long inversionsNum;

    public InversionNumberComputer(String path) {
        array = DataReader.readIntegerArray(path);
        inversionsNum = 0L;

    }

    public long getInversionsNumber() {
        inversionsNum = 0L;
        sort(array, 0, array.length - 1);
        return inversionsNum;
    }

    private void sort(Integer[] array, int low, int high) {
        if (high > low) {
            int middle = (low + high) / 2;
            sort(array, low, middle);
            sort(array, middle + 1, high);
            mergeAndCountInversions(array, low, middle, high);
        }
    }


    private void mergeAndCountInversions(Integer[] arr, int low, int middle, int high) {
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

    public Integer[] getArray() {
        return array;
    }

}

