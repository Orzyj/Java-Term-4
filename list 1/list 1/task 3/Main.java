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
            System.out.println("------------------------------\n\t[MENU]:\n[1]. Dodaj płyte\n:");

            try{
                choice = Integer.parseInt(bufforcin.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
                System.out.println("Nie ma takiej opcji");
                choice = 10;
            }

            switch (choice) {
                case 1: {
                    kolekcja.addCD();
                } break;
            }
        }
    }
}