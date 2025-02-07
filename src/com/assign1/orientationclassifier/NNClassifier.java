package com.assign1.orientationclassifier;

import java.util.List;

public class NNClassifier extends Classifier {

    public NNClassifier(List<String[]> trainingData) {
        super(trainingData);
    }

    @Override
    public String predict(double x, double y, double z) {
        String closestLabel = "Unknown";
        double minDistance = Double.MAX_VALUE;

        for (String[] row : trainingData) {
            if (row.length < 4) continue; // Skip invalid data

            double trainX = Double.parseDouble(row[0]);
            double trainY = Double.parseDouble(row[1]);
            double trainZ = Double.parseDouble(row[2]);
            String label = row[3];

            double distance = calculateDistance(x, y, z, trainX, trainY, trainZ);

            if (distance < minDistance) {
                minDistance = distance;
                closestLabel = label;
            }
        }

        return closestLabel;
    }

    public static void main(String[] args) {
        // Test the classifier with some data
        DataReader reader = new DataReader("data/trainingData.txt");
        reader.readFile();

        NNClassifier nn = new NNClassifier(reader.getData());

        // Example test input (modify based on actual dataset)
        double testX = 0.5, testY = 0.1, testZ = -0.3;
        String predictedLabel = nn.predict(testX, testY, testZ);

        System.out.println("Predicted Orientation: " + predictedLabel);
    }
}
