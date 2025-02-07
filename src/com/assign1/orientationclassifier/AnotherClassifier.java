package com.assign1.orientationclassifier;

import java.util.List;

public class AnotherClassifier extends Classifier {

    public AnotherClassifier(List<String[]> trainingData) {
        super(trainingData);
    }

    @Override
    public String predict(double x, double y, double z) {
        System.out.println("AnotherClassifier.predict() called");
        return "No classification performed";
    }

    public static void main(String[] args) {
        // Test AnotherClassifier
        DataReader reader = new DataReader("data/trainingData.txt");
        reader.readFile();

        AnotherClassifier dummy = new AnotherClassifier(reader.getData());

        // Example test input
        double testX = 0.5, testY = 0.1, testZ = -0.3;
        String result = dummy.predict(testX, testY, testZ);

        System.out.println("Dummy Classifier Output: " + result);
    }
}
