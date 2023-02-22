import java.util.*;
public class KOLEKCJA_PLYT{
    public List<CD> kolekcja;

    public KOLEKCJA_PLYT(){
        kolekcja = new ArrayList<CD>();
    }

    public void addCD(){
        CD cd = new CD();
        cd.insertData();
    }
}
