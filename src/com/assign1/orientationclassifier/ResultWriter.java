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
            directory.mkdir(); // Create the result directory if it doesn't exist
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String[] row : results) {
                writer.write(String.join(", ", row));
                writer.newLine();
            }
            System.out.println("Results saved to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputPath);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        ResultWriter writer = new ResultWriter("result/result.txt");

        List<String[]> sampleResults = List.of(
                new String[]{"0.5", "0.1", "-0.3", "Face Up"},
                new String[]{"-0.2", "0.3", "0.8", "Landscape Left"}
        );

        writer.writeResults(sampleResults);
    }
}
