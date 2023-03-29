public final class Miasto extends Media{
    public int domki;
    public int cenaDomka;
    public Miasto(int ID, String nazwa, int cena){
        super(ID, nazwa, cena);
        this.domki = 0;
        this.cenaDomka = 200;
    }

    @Override
    public String informacjePole(){
        return super.informacjePole() + "\nDomki: "+ this.domki;
    }

    @Override
    public String kupDomek(Gracz gracz){
        if(this.IDWlasciciela != gracz.IDgracza)
            return "Nie można kupić domka na nie swoim polu";

        if(this.cenaDomka > gracz.stanKonta)
            return("Brak wystarczających środków na koncie");

        if(this.domki > 4)
            return("Zbyt duża liczba domków jest już ich: " + this.domki);

        if(this.IDWlasciciela == gracz.IDgracza && gracz.odejmijZKonta(this.cenaDomka)){
            this.domki++;
            return("Kupiono domek");
        } else
            return("Nie zakupiono domka, brak wystarczających środkow na koncie");
    }

    @Override
    public String Czynsz(Gracz placacy, Gracz wlasciciel) {
        int czynsz = this.cena/2 * (this.domki+1);
        boolean czyPobrano = placacy.odejmijZKonta(czynsz);
        if(!czyPobrano){
            placacy.czyBankrut = true;
            return "Gracz: " + placacy.imie + " stał sie bankrutem :(";
        }
        wlasciciel.dodajDoKonta(czynsz);
        return "Gracz " + placacy.imie + (czyPobrano ? " zapłacił" : " nie zapłacił") + " graczowi" + wlasciciel.imie + " kwoty: " + czynsz + "$";
    }
}
