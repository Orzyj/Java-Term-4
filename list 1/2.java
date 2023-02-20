import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader bufforCin = new BufferedReader(cin);
        int n;

        System.out.println("Podaj n: ");
        try {
            n = Integer.parseInt(bufforCin.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Błędne n: ");
            return;
        }

        //silnia
        int i = 1;
        for(int j = 1; j <= n; j++)
            i*=j;
        System.out.println("Silnia dla liczby " + n + " wynosi: " + i);

        //ciąg
        double c = 0;
        for(int j = 1; j <= n; j++){
            System.out.println("Wartość kroku ["+j+"]: "+ 1f/(j+n));
            c += 1f/(j+n);
        }
        System.out.println("Wartość ciągu: " + c);

    }
}