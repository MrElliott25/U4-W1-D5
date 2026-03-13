package interfaces;

public interface Playable {
    void play();
    void raiseVolume(int volumeToAdd);
    void lowerVolume(int volumeToSubtract);
}
