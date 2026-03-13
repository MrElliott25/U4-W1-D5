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

    public void play(){
        for(int i = 0; i<this.duration; i++){
            System.out.println("Video: " + this.title + " Volume: " + this.volumeString + " Luminosità: " + brightnessString);
        }
    }

    public void showMenu(){
          do{
            System.out.println("Menù del Video: " + this.title);
            System.out.println("1. Alza il Volume\n 2. Abbassa il Volume\n 3.Alza la Luminosità\n 4. Abbassa la Luminosità\n 5. Riproduci! 0. Esci 😢");
            System.out.println("Inserisci un numero associato all'operazione per eseguirla");
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    myFlag = false;
                    break;
                case 1:
                    System.out.println("Inserisci un valore del quale ALZARE il volume.");
                    raiseVolume(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Inserisci un valore del quale ABBASSARE il volume (Attenzione! il volume non può essere minore di zero!");
                    lowerVolume(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Inserisci un valore del quale ALZARE la Luminosità.");
                    raiseBrightness(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Inserisci un valore del quale ABBASSARE la Luminosità (Attenzione! la Luminosità non può essere minore di zero!");
                    lowerBrightness(scanner.nextInt());
                    break;
                case 5:
                    play();
                    break;

                default:
                    System.out.println("Valore non valido, per piacere inserirne un altro.");
            }
        }while(myFlag);
    }
}
