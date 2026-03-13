package entities;

import interfaces.Brightness;

public class Image extends ElementoMultimediale implements Brightness {
    protected int brightness;
    protected String brightnessString="";

    //COSTRUTTORE
    public Image(String title, int brightness){
        super(title);
        this.brightness = brightness;
        setBrightnessString(brightness);
    }

    //METODI DELLA CLASSE IAMGE

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

    public void show(){
        System.out.println("Immagine: " + this.title + " Luminosità: " + brightnessString);
    }

    public void showMenu(){
        do{
            System.out.println("Menù dell'Immagine " + this.title);
            System.out.println("1. Alza la Luminosità\n2. Abbassa la Luminosità\n3. Mostra!\n0. Esci 😢");
            System.out.println("Inserisci un numero associato all'operazione per eseguirla");
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    myFlag = false;
                    break;
                case 1:
                    System.out.println("Inserisci un valore del quale ALZARE la Luminosità.");
                    raiseBrightness(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Inserisci un valore del quale ABBASSARE la Luminosità (Attenzione! la Luminosità non può essere minore di zero!");
                    lowerBrightness(scanner.nextInt());
                    break;
                case 3:
                    show();
                    break;
                default:
                    System.out.println("Valore non valido, per piacere inserirne un altro.");
            }
        }while(myFlag);
    }

}
