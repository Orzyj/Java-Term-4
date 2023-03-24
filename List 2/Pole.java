public class Pole {
    public String nazwa;
    public int ID;

    /*
    * Konstruktor klasy abstrakcyjnej
    * @param int, String
    * */
    public Pole(int ID, String nazwa){
        this.ID = ID;
        this.nazwa = nazwa;
    }

    /*
    * Wypisuje informacje o polu
    * @param none
    * @return none
    * */
    public void informacjePole(){
        System.out.println("ID: "+this.ID+"Pole"+this.nazwa);
    }
}
