public  class Pole {
    public String nazwa;
    public int ID;

    public Pole(int ID, String nazwa){
        this.ID = ID;
        this.nazwa = nazwa;
    }
    public String informacjePole(){
        return "ID: "+this.ID+"\nPole: "+this.nazwa;
    }
    public String kup(Gracz gracz)
    {
        return "To pole nie można kupić";
    }
    public String Czynsz(Gracz placacy, Gracz wlasciciel){
        return "Pole " + this.nazwa;
    }
    public String kupDomek(Gracz gracz){
        return "Na tym polu nie można kupic domka";
    }
    public String sprzedaj(Gracz gracz) {return "";}
    public boolean sprawdzeniePosiadlosci(Gracz gracz) {return false;}
}
