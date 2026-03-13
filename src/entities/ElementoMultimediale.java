package entities;

public abstract class ElementoMultimediale {
    protected String title;
    public abstract void showMenu();

    public ElementoMultimediale(String title){
        this.title = title;
    }
}
