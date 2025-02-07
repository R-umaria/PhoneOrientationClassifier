package com.assign1.orientationclassifier;

import java.io.*;
import java.util.*;

public class DataReader {
    private String filePath;
    private List<String[]> data;

    public DataReader(String filePath) {
        this.filePath = filePath;
        this.data = new ArrayList<>();
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming CSV format
                data.add(values);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
    }

    public List<String[]> getData() {
        return data;
    }

    public void printData() {
        for (String[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        DataReader reader = new DataReader("data/trainingData.txt");
        reader.readFile();
        reader.printData(); // Debugging - Prints dataset to console
    }
}