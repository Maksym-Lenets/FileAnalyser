package com.badprogram.testtask.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
    private final static int INITIAL_CAPACITY_FOR_LARGE_COLLECTIONS = 10_000_000;
    public static List<Integer> readNumbersFromFileReader(File file) throws IOException {
        var result = new ArrayList<Integer>(INITIAL_CAPACITY_FOR_LARGE_COLLECTIONS);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(Integer.parseInt(line));
            }
        }
        if (result.isEmpty()) {
            throw new IllegalArgumentException("File should not be empty");
        }
        return result;
    }
}
