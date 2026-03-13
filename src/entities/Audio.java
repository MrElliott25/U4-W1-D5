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


    public void play(){
        for(int i =0; i<this.duration; i++){
            System.out.println("Canzone: " + this.title + "Secondo " + i + ": " + this.volumeString);
        }
    }

    public void showMenu(){
        do{
            System.out.println("Menù dell'Audio " + this.title);
            System.out.println("1. Alza il Volume\n 2. Abbassa il Volume\n 3. Riproduci!\n 0. Esci 😢");
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
                    play();
                    break;
                default:
                    System.out.println("Valore non valido, per piacere inserirne un altro.");
            }
        }while(myFlag);
    }
}
