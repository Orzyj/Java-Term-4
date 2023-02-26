import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends JFrame implements ActionListener {
    public static Main app;
    public JLabel lSubjects, lGrade, lAvg, lListOfSubjects;
    public JTextField tSubject, tGrade;
    public JButton bAddGrade, bCountAvg;
    public JTextArea taGradesArea;
    public JScrollPane tasGradesArea;
    public static Map<String, double[]> map = new TreeMap<>();
    public  Main(){
        setSize(600,400);
        setTitle("Dziennik Ocen");
        setLayout(null);

        lSubjects = new JLabel("Przedmiot: ");
        lSubjects.setBounds(10,10,100,20);
        add(lSubjects);

        tSubject = new JTextField("");
        tSubject.setBounds(110, 10, 100, 20);
        add(tSubject);

        lGrade = new JLabel("Ocena (po ,): ");
        lGrade.setBounds(10, 35, 100, 20);
        add(lGrade);

        tGrade = new JTextField("");
        tGrade.setBounds(110, 35, 100, 20);
        add(tGrade);

        bAddGrade = new JButton("Dodaj");
        bAddGrade.setBounds(10, 65, 80, 20);
        bAddGrade.addActionListener(this);
        add(bAddGrade);

        bCountAvg = new JButton("Oblicz średnią");
        bCountAvg.setBounds(10, 90, 120, 20);
        bCountAvg.addActionListener(this);
        add(bCountAvg);

        lAvg = new JLabel("Średnia Roczna: ");
        lAvg.setBounds(10, 120, 150, 20);
        add(lAvg);

        lListOfSubjects = new JLabel("Dziennik");
        lListOfSubjects.setBounds(280, 10, 250, 10);
        add(lListOfSubjects);

        taGradesArea = new JTextArea();
        taGradesArea.setBounds(280, 30, 250, 300);
        add(taGradesArea);

        tasGradesArea = new JScrollPane(taGradesArea);
        tasGradesArea.setBounds(280,30,250,300);
        add(tasGradesArea);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == bAddGrade){
            String subjectName = tSubject.getText();
            String textFromLabel = tGrade.getText();
            ArrayList<Double> numbers = extractNumbers(textFromLabel);
            double[] grades = new double[numbers.size()];
            for(int i = 0; i < numbers.size(); i++)
                grades[i] = numbers.get(i);

            if(subjectName != "" || grades.length != 0)
                map.put(subjectName, grades);

            String collection = "";
            taGradesArea.setText("");
            float sum;
            for (Map.Entry<String, double[]> entry : map.entrySet()){
                sum = 0;
                collection += entry.getKey() + "\n";
                for(int i = 0; i < entry.getValue().length; i++){
                    collection +=  "Ocena: " + entry.getValue()[i] + "\n";
                    sum += entry.getValue()[i];
                }
                collection += "Średnia: " + sum/entry.getValue().length + "\n\n";
            }
            taGradesArea.setText(collection);

            tSubject.setText("");
            tGrade.setText("");
        }
        else if(source == bCountAvg){
            float mainAvg = 0;
            for(Map.Entry<String, double[]> entry : map.entrySet()){
                float sum = 0;
                for(int i = 0; i < entry.getValue().length; i++){
                    sum += entry.getValue()[i];
                }
                mainAvg += (sum/entry.getValue().length)/map.size();
            }
            lAvg.setText("Roczna średnia: " + String.valueOf(mainAvg));
        }

    }
    public ArrayList<Double> extractNumbers(String text){
        ArrayList<Double> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matchers = pattern.matcher(text);
        while(matchers.find()){
            if(Float.parseFloat(matchers.group()) >= 1 && Float.parseFloat(matchers.group()) < 6)
                numbers.add(Double.parseDouble(matchers.group()));
        }
        return numbers;
    }
    public static void main(String[] args) {
        app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}