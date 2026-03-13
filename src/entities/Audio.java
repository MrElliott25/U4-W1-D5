package entities;

import interfaces.Playable;

public class Audio extends ElementoMultimediale implements Playable {
    protected int duration;
    protected int volume;
    protected String volumeString = "";

    //COSTRUTTORE

    public Audio(String title, int duration, int volume){
        super(title);
        this.duration = duration;
        this.volume = volume;
        setVolumeString(volume);
    }

    //METODI DELLE CLASSE AUDIO

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


    public void play(){}
    public void showMenu(){}
}
