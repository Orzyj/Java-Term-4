import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforcin = new BufferedReader(cin);
        KOLEKCJA_PLYT kolekcja = new KOLEKCJA_PLYT();
        boolean isRunning = true;
        int choice;

        while(isRunning){
            System.out.println("------------------------------\nLista Płyt CD:");
            kolekcja.showCDs();
            System.out.println("------------------------------\n\t[MENU]:\n[1]. Dodaj płyte\n[2]. Edytuj płyte:\n[3]. Operacje na wybranej płycie\n[4]. Zakończ");

            try{
                choice = Integer.parseInt(bufforcin.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
                System.out.println("Nie ma takiej opcji");
                choice = 10;
            }

            if(choice == 1)
                kolekcja.addCD();
            else if (kolekcja.countCDs() != 0 && (choice == 2 || choice == 3)){
                int ID;

                try {
                    System.out.println("Podaj ID płyty: ");
                    ID = Integer.parseInt(bufforcin.readLine());
                } catch(IOException exception) {
                    exception.printStackTrace();
                    ID = -1;
                    System.out.println("Błąd w wprowadzeniu nr. płyty");
                }
                ID = ID - 1;

                if(ID != -1 && choice == 2)
                    kolekcja.kolekcja.get(ID).editData();

                if(ID != -1 && choice == 3){
                    int secondMenuChoice;
                    boolean c = true;
                    while(c){
                        kolekcja.kolekcja.get(ID).showData();
                        kolekcja.kolekcja.get(ID).showTracks();
                        System.out.println("[Menu dodawania utworów/edycji ich]:\n[1]. Dodawanie utworu\n[2]. Edycja utworu\n[3]. Zakończ");

                        try {
                            secondMenuChoice = Integer.parseInt(bufforcin.readLine());
                        } catch (IOException exception) {
                            exception.printStackTrace();
                            secondMenuChoice = -1;
                        }

                        if(secondMenuChoice == 1)       kolekcja.kolekcja.get(ID).addTracks();
                        else if (secondMenuChoice == 2) kolekcja.kolekcja.get(ID).editTrack();
                        else if (secondMenuChoice == 3) c = false;
                    }
                }
            }
            else if(choice == 4) isRunning = false;
        }
    }
}