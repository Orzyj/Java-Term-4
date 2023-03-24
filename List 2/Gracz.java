public class Gracz implements  GraczI{
    public String imie;
    public String IDgracza;
    public int pozycja;
    public int stanKonta;

    public Gracz(String ID, int pozycja, String imie){
        this.imie = imie;
        this.IDgracza = ID;
        this.pozycja = pozycja;
    }

    @Override
    public void ruchPoPlanszy() {

    }

    @Override
    public int odejmijZKonta(int kwota) {
        return 0;
    }

    @Override
    public int dodajDoKonta(int kwota) {
        return 0;
    }
}
