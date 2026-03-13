package interfaces;

public interface Brightness {
    void raiseBrightness(int brightnessToAdd);
    void lowerBrightness(int brightnessToSubtract);
    void setBrightnessString(int value);
}
