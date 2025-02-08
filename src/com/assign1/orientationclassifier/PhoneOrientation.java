package com.assign1.orientationclassifier;

public enum PhoneOrientation {
    FACE_UP(1),
    FACE_DOWN(2),
    PORTRAIT_UP(3),
    PORTRAIT_DOWN(4),
    LANDSCAPE_LEFT(5),
    LANDSCAPE_RIGHT(6),
    UNKNOWN(0);

    private final int label;

    PhoneOrientation(int label) {
        this.label = label;
    }

    public static PhoneOrientation fromLabel(int label) {
        switch (label) {
            case 1: return FACE_UP;
            case 2: return FACE_DOWN;
            case 3: return PORTRAIT_UP;
            case 4: return PORTRAIT_DOWN;
            case 5: return LANDSCAPE_LEFT;
            case 6: return LANDSCAPE_RIGHT;
            default: return UNKNOWN;
        }
    }
}