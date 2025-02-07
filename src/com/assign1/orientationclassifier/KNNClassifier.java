package com.assign1.orientationclassifier;

import java.util.*;

public class KNNClassifier extends Classifier {
    private int k;

    public KNNClassifier(List<String[]> trainingData, int k) {
        super(trainingData);
        this.k = k;
    }

    @Override
    public String predict(double x, double y, double z) {
        PriorityQueue<DataPoint> nearestNeighbors = new PriorityQueue<>(Comparator.comparingDouble(dp -> dp.distance));

        for (String[] row : trainingData) {
            if (row.length < 4) continue;

            double trainX = Double.parseDouble(row[0]);
            double trainY = Double.parseDouble(row[1]);
            double trainZ = Double.parseDouble(row[2]);
            String label = row[3];

            double distance = calculateDistance(x, y, z, trainX, trainY, trainZ);
            nearestNeighbors.offer(new DataPoint(label, distance));

            if (nearestNeighbors.size() > k) {
                nearestNeighbors.poll(); // Remove farthest point
            }
        }

        return getMostFrequentLabel(nearestNeighbors);
    }

    private String getMostFrequentLabel(PriorityQueue<DataPoint> neighbors) {
        Map<String, Integer> labelCount = new HashMap<>();

        for (DataPoint dp : neighbors) {
            labelCount.put(dp.label, labelCount.getOrDefault(dp.label, 0) + 1);
        }

        return Collections.max(labelCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static class DataPoint {
        String label;
        double distance;

        DataPoint(String label, double distance) {
            this.label = label;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        // Test KNN Classifier
        DataReader reader = new DataReader("data/trainingData.txt");
        reader.readFile();

        KNNClassifier knn = new KNNClassifier(reader.getData(), 3);

        // Example test input (modify based on dataset)
        double testX = 0.5, testY = 0.1, testZ = -0.3;
        String predictedLabel = knn.predict(testX, testY, testZ);

        System.out.println("Predicted Orientation (KNN): " + predictedLabel);
    }
}
