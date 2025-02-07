package com.assign1.orientationclassifier;

public enum PhoneOrientation {
    FACE_UP,
    FACE_DOWN,
    PORTRAIT_UP,
    PORTRAIT_DOWN,
    LANDSCAPE_LEFT,
    LANDSCAPE_RIGHT,
    UNKNOWN;

    public static PhoneOrientation fromString(String label) {
        switch (label.toLowerCase()) {
            case "face up":
                return FACE_UP;
            case "face down":
                return FACE_DOWN;
            case "portrait up":
                return PORTRAIT_UP;
            case "portrait down":
                return PORTRAIT_DOWN;
            case "landscape left":
                return LANDSCAPE_LEFT;
            case "landscape right":
                return LANDSCAPE_RIGHT;
            default:
                return UNKNOWN;
        }
    }
}
