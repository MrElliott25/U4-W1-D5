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

    public void showMenu(){

    }

    public void show(){}
}
