import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    public static Main app;
    public JLabel lNumber, lStrong, lString;
    public JTextField tNumber;
    public JButton bExecute;
    public Main(){
        setSize(400,250);
        setTitle("Silnia i ciąg");
        setLayout(null);

        this.setLaout();
    }
    public void setLaout(){
        lNumber = new JLabel("Podaj n: ");
        lNumber.setBounds(10, 10, 100, 30);
        lNumber.setFont(new Font("", Font.PLAIN, 20));
        add(lNumber);

        tNumber = new JTextField("");
        tNumber.setBounds(110, 10, 100, 30);
        add(tNumber);

        bExecute = new JButton("Oblicz");
        bExecute.setBounds(10,50,100,30);
        bExecute.addActionListener(this);
        add(bExecute);

        lStrong = new JLabel("Silnia wynik: ");
        lStrong.setBounds(10, 90, 200, 30);
        lStrong.setFont(new Font("", Font.PLAIN, 20));
        add(lStrong);

        lString = new JLabel("Ciag wynik: ");
        lString.setBounds(10, 130, 200, 30);
        lString.setFont(new Font("", Font.PLAIN, 20));
        add(lString);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int n, i = 1;
        double c = 0;

        if(source == bExecute){
            try { n = Integer.parseInt(tNumber.getText()); }
            catch (IOError error) {
                error.printStackTrace();
                n = 0;
            }

            for(int j = 1; j <= n; i*=j,j++);
            for(int j = 1; j <= n; c+= 1f/(j+n),System.out.println("Wartość kroku ["+j+"]: "+ 1f/(j+n)),j++);

            tNumber.setText("");
            lStrong.setText("Wynik silni: " + String.valueOf(i));
            lString.setText("Wynik ciągu:" + String.valueOf(c));
        }
    }

    public static void main(String[] args) {
        app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}