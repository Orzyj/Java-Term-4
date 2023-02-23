import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CD {
    public String title;
    public String authorSurname;
    public String wyd;
    public int year;
    public float price;
    public List<UTWOR> listaUtworow;
    public CD(){
        this.listaUtworow = new ArrayList<UTWOR>();
    }
    public void insertData(){
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforcin = new BufferedReader(cin);

        System.out.println("Podaj tytuł płyty: ");
        try {
            this.title = bufforcin.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            this.title = "Nie podano płyty";
        }

        System.out.println("Podaj nazwisko autora ");
        try {
            this.authorSurname = bufforcin.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            this.authorSurname = "Nie podano płyty";
        }

        System.out.println("Podaj wydawnictwo: ");
        try {
            this.wyd = bufforcin.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            this.wyd = "Nie podano płyty";
        }

        System.out.println("Podaj rok płyty: ");
        try {
            this.year = Integer.parseInt(bufforcin.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            this.year = 0;
            System.out.println("Błedny rok płyty");
        }

        System.out.println("Podaj cene płyty: ");
        try {
            this.price = Float.parseFloat(bufforcin.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            this.price = 0;
        }

    }
    public void showData(){
        System.out.println("Informacje o płycie: \n[Tytuł]: "+ this.title + "\n[Nazwisko autora]: " + this.authorSurname + "\n[Wydawnictwo]: "+this.wyd + "\n[Rok wydania]: "+this.year + "\n[Cena]:" +this.price);
    }
    public void editData(){
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforcin = new BufferedReader(cin);
        boolean checkCondition = true;
        int optionMenu;

        while(checkCondition){
            System.out.println("Edycja danych o płycie\nMenu: \n[1]. Tytuł \n[2]. Nazwisko autora \n[3]. Wydawnictwo \n[4]. Rok wydania \n[5]. Cena \n[6]. Zakończ edycje\nPodaj nr pozycji do edycji: ");

            try{
                optionMenu = Integer.parseInt(bufforcin.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
                optionMenu = 7;
            }

            switch(optionMenu){
                case 1: {
                    String oldTitle = this.title;
                    System.out.println("Podaj nowy tytuł: ");
                    try {
                        this.title = bufforcin.readLine();
                        System.out.println("Zmieniono tytuł z " + oldTitle + "na " + this.title);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.title = oldTitle;
                        System.out.println("Nie zmieniono, błąd");
                    }
                } break;
                case 2:{
                    String oldSurname = this.authorSurname;
                    System.out.println("Podaj nowe nazwisko autora: ");
                    try {
                        this.authorSurname = bufforcin.readLine();
                        System.out.println("Zmieniono naziwsko z " + oldSurname + "na " + this.authorSurname);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.authorSurname = oldSurname;
                        System.out.println("Nie zmieniono, błąd");
                    }
                } break;
                case 3:{
                    String oldWydawnictow = this.wyd;
                    System.out.println("Podaj nowe wydawnictwo: ");
                    try {
                        this.wyd = bufforcin.readLine();
                        System.out.println("Zmieniono wydawnictwo z " + oldWydawnictow + "na " + this.wyd);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.wyd = oldWydawnictow;
                        System.out.println("Nie zmieniono, błąd");
                    }
                } break;
                case 4: {
                    int oldYear = this.year;
                    System.out.println("Podaj nowy rok wydania: ");
                    try {
                        this.year = Integer.parseInt(bufforcin.readLine());
                        System.out.println("Zmieniono rok wydania z " + oldYear + "na " + this.year);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.year = oldYear;
                        System.out.println("Nie zmieniono, błąd");
                    }
                } break;
                case 5: {
                    float oldPrice = this.price;
                    System.out.println("Podaj nową cene: ");
                    try {
                        this.year = Integer.parseInt(bufforcin.readLine());
                        System.out.println("Zmieniono cene z " + oldPrice + "na " + this.price);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        this.price = oldPrice;
                        System.out.println("Nie zmieniono, błąd");
                    }
                } break;
                case 6: checkCondition = false; break;
                default: System.out.println("Nie ma takiej opcji"); break;
            }
        }


    }
    public void showUtwory(){
        if(listaUtworow.size() == 0){
            System.out.println("Brak utworów na liście");
            return;
        }
        System.out.println("Lista utworów: ");
        for(int i = 0; i < listaUtworow.size(); i++)
            System.out.println("[Autor]: " + this.listaUtworow.get(i).author + "[Czas trwania]: "+this.listaUtworow.get(i).time);

    }
}