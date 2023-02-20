import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<String, int[]> map = new TreeMap<>();
    public static void main(String[] args) {
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforIn = new BufferedReader(cin);
        boolean condition = true;
        int chocie;

       do {
           System.out.println("Menu:\n1. Dodaj przedmiot i oceny.\n2. Pokaż średnią końcową.\n3. Pokaż oceny \n4. Zakończ program");
           System.out.println("\nPodaj opcje z menu: ");
           try {
               chocie = Integer.parseInt(bufforIn.readLine());
           } catch (IOException exception) {
               exception.printStackTrace();
               chocie = 100;
           }

           switch(chocie){
               case 1: addSubjectAndGrades(); break;
               case 2: {
                   float avgStudent = avg();
                   System.out.println("Średnia: " + avgStudent + " stypendium" + (avgStudent >= 4.1 ? " przysługuje" : " nie przysługuje za niska średnia") );
               } break;
               case 3: showGrades(); break;
               case 4: condition = false; break;
               default: System.out.println("Brak opcji w menu"); break;
           }
       } while (condition);
    }
    public static void addSubjectAndGrades(){
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforIn = new BufferedReader(cin);
        String subject;
        int amountGrades;

        System.out.println("Podaj nazwe przedmiotu: ");
        try {
            subject = bufforIn.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Bez nazwy przedmiotu nie da rady kontynuować");
            return;
        }

        System.out.println("Podaj ile ocen chcesz wprowadzić");
        try {
            amountGrades = Integer.parseInt(bufforIn.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Błąd w podawaniu liczby ocen oceny");
            return;
        }

        int[] grades = new int[amountGrades];

        for(int i = 0; i < amountGrades;){
            System.out.println("Podaj ocene: ");
            int grade;
            try{
                grade = Integer.parseInt(bufforIn.readLine());
                if(grade > 0 && grade < 7){
                    grades[i] = grade;
                    i++;
                } else System.out.println("Ocena nie znajduje się w przedziale <1;6>");
            } catch (IOException exception){
                exception.printStackTrace();
                System.out.println("Błąd w podawaniu oceny");
            }
        }
        map.put(subject, grades);
    }

    public static float avg(){
        float mainAvg=0;
        Iterator<String> iter = map.keySet().iterator();

        while(iter.hasNext()){
            int sum = 0;
            String arrayName = iter.next();
            int[] arr = map.get(arrayName);
            for(int i = 0; i < arr.length; i++){
                sum += arr[i];
            }
            mainAvg += (sum/arr.length);
        }

        return mainAvg/map.size();
    }

    public static void showGrades(){
        Iterator<String> iter = map.keySet().iterator();

        while(iter.hasNext()){
            String arrayName = iter.next();
            int[] arr = map.get(arrayName);
            System.out.println("Przedmiot " + arrayName + " oceny:");
            for(int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }
    }
}