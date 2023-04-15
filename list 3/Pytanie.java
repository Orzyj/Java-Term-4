import java.io.Serializable;

public class Pytanie implements Serializable {
    public int ID;
    public String contents;
    public String anserwA, anserwB, anserwC, anserwD;
    public char correctAnserw;

    public Pytanie(int ID, String contents, String anserwA, String anserwB, String anserwC, String anserwD, char correctAnserw){
        this.ID = ID;
        this.contents = contents;
        this.anserwA = anserwA;
        this.anserwB = anserwB;
        this.anserwC = anserwC;
        this.anserwD = anserwD;
        this.correctAnserw = correctAnserw;
    }

    @Override
    public String toString(){
        return "Pytanie: " + this.ID + "\nTreść: " + this.contents + "\nOdpowiedzi:\n" + this.anserwA + "\n" + this.anserwB + "\n" + this.anserwC + "\n" + this.anserwD + "\n";
    }

    public boolean checkAnserw(char letter){
        return (letter == this.correctAnserw);
    }
}
