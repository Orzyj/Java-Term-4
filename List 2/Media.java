import java.util.Random;

public class Media extends Pole{
    public int cena;
    public boolean hipoteka;
    public String IDWlasciciela;
    public Media(int ID, String nazwa, int cena) {
        super(ID, nazwa);
        this.cena = cena;
        this.hipoteka = false;
        this.IDWlasciciela = null;
    }

    @Override
    public String informacjePole(){
        return super.informacjePole() + "\nCena: " + this.cena + "\nHipoteka: " + (this.hipoteka ? "tak" : "nie") + (this.IDWlasciciela != null ? "\nWłaściciel: " +this.IDWlasciciela : "\nBrak właściciela");
    }

    @Override
    public String kup(Gracz gracz) {
        if(this.IDWlasciciela != null)
            return "Posiadłość już posiada właściciela";
        if(gracz.odejmijZKonta(this.cena)){
            this.IDWlasciciela = gracz.IDgracza;
            return "Gracz: " + gracz.imie + "\nzakupił posiadłość:\n"+this.nazwa;
        } else {
            return "Gracz: " + gracz.imie + "\nnie zakupił posiadłość:\n"+this.nazwa;
        }
    }
    @Override
    public String Czynsz(Gracz placacy, Gracz wlasciciel) {
        Random random = new Random();
        int czynsz = (random.nextInt(6)+1 + random.nextInt(6)+1) * 10;
        wlasciciel.dodajDoKonta(czynsz);
        return "Gracz" + placacy.imie + ((placacy.odejmijZKonta(czynsz)) ? " zapłacił" : " nie zapłacił") + " graczowi" + wlasciciel.imie + " kwoty: " + czynsz + "$";
    }

    @Override
    public String sprzedaj(Gracz gracz){
        if(gracz.IDgracza == this.IDWlasciciela){
            gracz.dodajDoKonta(this.cena);
            this.IDWlasciciela = null;
            return "Gracz: \n" + gracz.imie + "\nSprzedał: " + this.nazwa;
        }
        return "";
    }

    @Override
    public boolean sprawdzeniePosiadlosci(Gracz gracz){
        if(gracz.IDgracza == this.IDWlasciciela)
            return true;
        return false;
    }
}
