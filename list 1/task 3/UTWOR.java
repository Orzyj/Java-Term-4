import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UTWOR {
    public String author;
    public String wykonawca;
    public float time;


    public void showData(){
        System.out.println("Informacje o utworze: \n[Autor]: "+this.author+"\n[Wykonawca]: "+this.wykonawca+"\n[Czas]: "+this.time);
    }
    public void insertData(){
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforCin = new BufferedReader(cin);

        System.out.println("Podaj Autora: ");
        try{
            this.author = bufforCin.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            this.author = "";
            System.out.println("Błąd danych, zawartości nie wprowadzono");
        }

        System.out.println("Podaj Wykonawce: ");
        try {
            this.wykonawca = bufforCin.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            this.wykonawca = "";
            System.out.println("Błąd danych, zawartości nie wprowadzono");
        }

        System.out.println("Podaj czas trwania");
        try{
            this.time = Float.parseFloat(bufforCin.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            this.time = 0f;
            System.out.println("Błąd danych, zawartości nie wprowadzono");
        }
    }
    public void editData(){
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforcin = new BufferedReader(cin);
        boolean checkCondition = true;
        int optionMenu;

        while(checkCondition){
            System.out.println("Edycja danych utworu\nMenu: \n[1]. Autor\n[2]. Wykonawca \n[3]. Czas\n [4]. Zakończ\nPodaj numer do edycji danych utworu: ");
            try{
                optionMenu = Integer.parseInt(bufforcin.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
                optionMenu = 5;
            }

            switch(optionMenu) {
                case 1: {
                    String oldAuthor = this.author;
                    System.out.println("Podaj nowego autora: ");
                    try {
                        this.author = bufforcin.readLine();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.author = oldAuthor;
                        System.out.println("Nie dodano nowego autora");
                    }
                } break;
                case 2: {
                    String oldWyk = this.wykonawca;
                    System.out.println("Podaj nowego wykonawce: ");
                    try {
                        this.wykonawca = bufforcin.readLine();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.wykonawca = oldWyk;
                        System.out.println("Nie dodano nowego wykonawcy");
                    }
                } break;
                case 3: {
                    float oldTime = this.time;
                    System.out.println("Podaj nowy czas utworu: ");
                    try {
                        this.time = Float.parseFloat(bufforcin.readLine());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.time = oldTime;
                        System.out.println("Nie dodano nowego czasu utworu");
                    }
                } break;
                case 4: checkCondition = false; break;
                default: System.out.println("Nie ma takiej opcji"); break;
            }
        }
    }
}
