package entities;

import interfaces.Brightness;
import interfaces.Playable;

public class Video extends ElementoMultimediale implements Playable, Brightness {
    protected int duration;
    protected int volume;
    protected String volumeString = "";
    protected int brightness;
    protected String brightnessString="";

    //COSTRUTTORE
    public Video(String title, int volume, int duration, int brightness){
        super(title);
        this.brightness = brightness;
        this.volume = volume;
        this.duration = duration;
        setVolumeString(volume);
        setBrightnessString(brightness);
    }

    //METODI DELLA CLASSE VIDEO

    public void raiseVolume(int volumeToAdd){
        this.volume += volumeToAdd;
        setVolumeString(this.volume);
    }

    public void lowerVolume(int volumeToSubtract){
        int result = this.volume - volumeToSubtract;
        if (result >= 0){
            this.volume = result;
            setVolumeString(result);
        }
        else System.out.println("Hai inserito un valore non valido per l'operazione! Ti riporto al menù");
    }

    public void setVolumeString(int value){
        this.volumeString="";
        for(int i = 0; i<value; i++){
            this.volumeString += "!";
        }
    }

    public void raiseBrightness(int brightnessToAdd) {
        this.brightness += brightnessToAdd;
        setBrightnessString(this.brightness);
    }


    public void lowerBrightness(int brightnessToSubtract){
        int result = this.brightness - brightnessToSubtract;
        if (result >= 0){
            this.brightness = result;
            setBrightnessString(result);
        }
        else System.out.println("Hai inserito un valore non valido per l'operazione! Ti riporto al menù");
    }

    public void setBrightnessString(int value){
        this.brightnessString="";
        for(int i = 0; i<value; i++){
            this.brightnessString += "*";
        }
    }

    public void showMenu(){}
    public void play(){}
}
