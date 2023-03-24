public class Miasto extends Pole implements MiastoI{
    public int cena;
    public int domki;
    public int cenaDomka;
    public boolean hipoteka;
    public String IDWlasciciela;
    public Miasto(int ID, String nazwa, int cena){
        super(ID, nazwa);
        this.cena = cena;
        this.domki = 0;
        this.cenaDomka = 200;
        this.hipoteka = false;
        this.IDWlasciciela = null;
    }

    @Override
    public void kupDomek(){

    }
    @Override
    public void kupMiasto() {

    }

    @Override
    public void kup() {

    }

    @Override
    public String informacje(){
        return "";
    }
}
