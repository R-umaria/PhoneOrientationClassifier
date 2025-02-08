package com.assign1.orientationclassifier;

import java.util.*;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to choose a classifier
        System.out.println("Select a classifier:");
        System.out.println("1. Nearest Neighbor (NN)");
        System.out.println("2. K-Nearest Neighbors (KNN)");
        System.out.println("3. AnotherClassifier (Dummy)");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Ask user for input data file
        System.out.print("Enter the input file name (e.g., unknownData.txt): ");
        String inputFile = scanner.nextLine();
        
        // Read training data
        DataReader trainReader = new DataReader("data/trainingData.txt");
        trainReader.readFile();
        
        // Read test data (user input file)
        DataReader testReader = new DataReader("data/" + inputFile);
        testReader.readFile();

        // Select the classifier
        Classifier classifier;
        if (choice == 1) {
            classifier = new NNClassifier(trainReader.getData());
        } else if (choice == 2) {
            System.out.print("Enter K value for KNN: ");
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            classifier = new KNNClassifier(trainReader.getData(), k);
        } else {
            classifier = new AnotherClassifier(trainReader.getData());
        }

        // Classify test data
        List<String[]> results = new ArrayList<>();
        for (String[] row : testReader.getData()) {
            if (row.length < 3) continue;
            
            double x = Double.parseDouble(row[0]);
            double y = Double.parseDouble(row[1]);
            double z = Double.parseDouble(row[2]);
            String predictedLabel = classifier.predict(x, y, z);
            
            results.add(new String[]{row[0], row[1], row[2], predictedLabel});
        }

        // Write results to file
        ResultWriter writer = new ResultWriter("result/result.txt");
        writer.writeResults(results);

        System.out.println("\nClassification complete. Results saved to result/result.txt");
        scanner.close();
    }
}