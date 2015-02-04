package com.elianekipeloff.coursera.algorithms.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Ella Nekipelova
 *         Date: 2/2/2015.
 */
public class DataReader {

    public static Integer[] readIntegerArray(String path) {
        Integer[] res = null;
        try {
            List<String> dataList = Files.readAllLines(Paths.get(path));
            int i =0;
            res = new Integer[dataList.size()];
            for (String str : dataList) {
                res[i] = new Integer(str);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }

    public static String getSourcePath(String name) throws FileNotFoundException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        if (url == null) {
            return "C:\\dev\\Coursera\\data\\" + name;
        } else
            return url.getPath();
    }
}
