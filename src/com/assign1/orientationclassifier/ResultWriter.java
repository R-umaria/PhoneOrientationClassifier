package com.assign1.orientationclassifier;

import java.io.*;
import java.util.List;

public class ResultWriter {
    private String outputPath;

    public ResultWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    public void writeResults(List<String[]> results) {
        File directory = new File("result");
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String[] row : results) {
                int label = Integer.parseInt(row[3]);  // Extract label
                PhoneOrientation orientation = PhoneOrientation.fromLabel(label); // Map label to orientation
                
                writer.write(String.join(", ", row) + ", " + orientation);
                writer.newLine();
            }
            System.out.println("Results saved to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputPath);
            e.printStackTrace();
        }
    }
}
