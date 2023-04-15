import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public int points = 0;

    @Override
    public String toString(){
        return "Gracz: " + this.name + " zdobył: " + this.points;
    }
}
