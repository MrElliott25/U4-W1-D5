package entities;

import java.util.Scanner;

public abstract class ElementoMultimediale {
    protected String title;
    //Scelta che adotto solo perchè sto facendo un menu personalizzato per ogni tipologia di oggetto
    protected final Scanner scanner = new Scanner(System.in);
    protected boolean myFlag = true;
    public abstract void showMenu();

    public ElementoMultimediale(String title){
        this.title = title;
    }
}
