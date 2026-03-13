import entities.Audio;
import entities.ElementoMultimediale;
import entities.Image;
import entities.Video;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean myFlag = true;
        int choice;
        ElementoMultimediale[] myMultimedias = new ElementoMultimediale[5];

        System.out.println("Popoliamo il nostro array di 5 Elementi multimediali!");

        //Ciclo for per popolare il mio array
        for(int i=0; i<myMultimedias.length; i++) {
            System.out.println("Creiamo l'elemento numero: " + (i + 1));
            System.out.println("Di che tipo sarà il nostro Elemento Multimediale?");
            do {
                System.out.println("1. Audio\n2. Immagine\n3. Video");
                choice = parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        myMultimedias[i] = createAudio(myFlag, scanner);
                        break;
                    case 2:
                        myMultimedias[i] = createImage(myFlag, scanner);
                        break;
                    case 3:
                        myMultimedias[i] = createVideo(myFlag, scanner);
                        break;
                    default:
                        System.out.println("Inserire un valore valido.");
                }
            } while (choice > 3 || choice < 1);
        }

        //Ciclo do-while per determinare quanto l'utente voglia interagite con il nostro array di ElementiMultimediale
        do {
            System.out.println("Con che elemento vogliamo interagire?");
            System.out.println("1. " + myMultimedias[0].getTitle());
            System.out.println("2. " + myMultimedias[1].getTitle());
            System.out.println("3. " + myMultimedias[2].getTitle());
            System.out.println("4. " + myMultimedias[3].getTitle());
            System.out.println("5. " + myMultimedias[4].getTitle());
            System.out.println("0. Esci 😢😢");
            choice = parseInt(scanner.nextLine());
            if(choice == 0) break;
            switch(choice){
                case 1, 2, 3, 4, 5:
                    myMultimedias[choice-1].showMenu();
                    break;
                default:
                    System.out.println("Inserisci un valore valido!");
            }
        }while(myFlag);
    }

    public static Audio createAudio(boolean flag, Scanner scanner){
        int volume;
        String title;
        int duration;
            System.out.println("Inserire un titolo per il nostro Audio");
            title = scanner.nextLine();
            System.out.println("Inserire il valore di inizializzazione del volume (deve essere positivo!) di questo Audio");
            do {
                volume = parseInt(scanner.nextLine());
                if(volume>=0) flag=false;
                else System.out.println("Inserire un valore valido.");
            }while(flag);
            flag=true;
        System.out.println("Inserisci un valore per la sua durata (in secondi e maggiore di 0!)");
        do {
            duration = parseInt(scanner.nextLine());
            if(duration>0) flag=false;
            else System.out.println("Inserire un valore valido.");
        }while(flag);
        return new Audio(title, duration, volume);
    }

    public static Image createImage(boolean flag, Scanner scanner){
        String title;
        int brightness;
        System.out.println("Inserire un titolo per la nostra Immagine");
        title = scanner.nextLine();
        System.out.println("Inserire il valore di inizializzazione della luminosità (deve essere positivo!) di questa Immagine");
        do {
            brightness = parseInt(scanner.nextLine());
            if(brightness>=0) flag=false;
            else System.out.println("Inserire un valore valido.");
        }while(flag);
        return new Image(title, brightness);
    }

    public static Video createVideo(boolean flag, Scanner scanner){
        String title;
        int volume;
        int duration;
        int brightness;
        System.out.println("Inserire un titolo per il nostro Video");
        title = scanner.nextLine();
        System.out.println("Inserire il valore di inizializzazione del volume (deve essere positivo!) di questo Video");
        do {
            volume = parseInt(scanner.nextLine());
            if(volume>=0) flag=false;
            else System.out.println("Inserire un valore valido.");
        }while(flag);
        flag=true;
        System.out.println("Inserisci un valore per la sua durata (in secondi e maggiore di 0!)");
        do {
            duration = parseInt(scanner.nextLine());
            if(duration>0) flag=false;
            else System.out.println("Inserire un valore valido.");
        }while(flag);
        flag=true;
        System.out.println("Inserire il valore di inizializzazione della luminosità (deve essere positivo!) di questo Video");
        do {
            brightness = parseInt(scanner.nextLine());
            if(brightness>=0) flag=false;
            else System.out.println("Inserire un valore valido.");
        }while(flag);
        return new Video(title, volume, duration, brightness);
    }
}