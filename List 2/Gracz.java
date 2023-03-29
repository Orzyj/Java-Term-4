import javax.swing.*;
import java.util.Random;

public class Gracz implements  GraczI{
    public String imie;
    public String IDgracza;
    public int pozycja;
    public int stanKonta;
    public boolean czyBankrut;

    public Gracz(String ID, String imie){
        this.imie = imie;
        this.IDgracza = ID;
        this.pozycja = 0;
        this.stanKonta = 2000;
        this.czyBankrut = false;
    }

    public String przedstawSie(){
        return " ID: "+this.IDgracza+"\nImie: "+this.imie + "\nStan konta: " + this.stanKonta + "$\nPozycja: "+this.pozycja+"\nBankrut: " + (this.czyBankrut ? "tak" : "nie");
    }

    @Override
    public void ruchPoPlanszy() {
        Random random = new Random();
        int kostka1 = random.nextInt(6)+1;
        int kostka2 = random.nextInt(6)+1;

        this.pozycja += kostka1 + kostka2;

        if(this.pozycja > 25)
            this.pozycja -= 25;
}

    @Override
    public boolean odejmijZKonta(int kwota) {
        if(kwota > this.stanKonta)
            return false;

        this.stanKonta -= kwota;
        return true;
    }

    @Override
    public void dodajDoKonta(int kwota) {
        this.stanKonta += kwota;
    }
}
