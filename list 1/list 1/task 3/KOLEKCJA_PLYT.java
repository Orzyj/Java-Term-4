import java.util.*;
public class KOLEKCJA_PLYT{
    public List<CD> kolekcja;
    public KOLEKCJA_PLYT(){
        kolekcja = new ArrayList<CD>();
    }
    public void addCD(){
        CD cd = new CD();
        cd.insertData();
        kolekcja.add(cd);
    }
    public void showCDs(){
        if(kolekcja.size() == 0){
            System.out.println("Brak płyt");
            return;
        }

        for(int i = 0; i < kolekcja.size(); i++)
            System.out.println("["+(i+1)+"][Płyta]:"+ this.kolekcja.get(i).title);
    }
}