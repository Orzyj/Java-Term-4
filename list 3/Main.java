import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        //basic object
        App app = new App();

        //startin deseialization
        try{
            ObjectInputStream inputStream = new ObjectInputStream(
              new FileInputStream("appdata.ser")
            );
            app = (App)inputStream.readObject();

            if(app.isQuizOver)
                app = new App();
            else {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Kontynuować rozgrywkę ? ","Powiadomienie", JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.NO_OPTION)
                    app = new App();
            }

            inputStream.close();
        } catch (IOException exc){
            app = new App();
            exc.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException exc){
            app = new App();
            System.exit(1);
        }

        //else continue game
        app.run();
    }
}