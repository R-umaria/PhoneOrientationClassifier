package com.assign1.orientationclassifier;

import java.util.List;

public abstract class Classifier {
    protected List<String[]> trainingData;

    public Classifier(List<String[]> trainingData) {
        this.trainingData = trainingData;
    }

    // Abstract method to be implemented by NN and KNN classifiers
    public abstract String predict(double x, double y, double z);

    // Helper method to calculate Euclidean distance
    protected double calculateDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }
}
