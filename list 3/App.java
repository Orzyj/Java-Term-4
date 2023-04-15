import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame implements ActionListener, Serializable {
    private ArrayList<Pytanie> questions = new ArrayList<>();
    private final User user = new User();
    private static final JFrame window = new JFrame();
    private JLabel lUserName = new JLabel("Imie gracza"), lGame, lAnserw, lUsers;
    private JTextArea taUserName = new JTextArea(), taQuestion, taAnserw, taUsers;
    private JButton bAddUser = new JButton("Rozpocznij"), bNextQuestion;
    private JButton bReturn = new JButton("Od nowa");
    private final int height;
    private final int width;
    private int activeQuestion;
    public boolean isQuizOver = false;
    public App(){
        this.loadQuestions();
        this.height = 400;
        this.width = 600;
        this.activeQuestion = 0;

        this.window.setSize(this.width, this.height);
        this.window.setTitle("Aplikacja do testów");
        this.window.setResizable(false);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setLayout(null);

        this.window.setVisible(true);
    }
    private void makeInterfaceInput(){
        this.window.getContentPane().removeAll();
        this.window.repaint();

        Font font = new Font("Arial", Font.PLAIN, 22);
        Font fontButton = new Font("Arial", Font.PLAIN, 12);

        this.lUserName.setBounds(20,20,150,30);
        this.lUserName.setFont(font);
        this.window.add(this.lUserName);

        this.taUserName.setBounds(20,60,150,30);
        this.taUserName.setFont(font);
        this.window.add(this.taUserName);

        this.bAddUser.setBounds(70,100,100,30);
        this.bAddUser.setFont(fontButton);
        this.bAddUser.addActionListener(this);
        this.window.add(this.bAddUser);
    }
    private void makeMainInterface(){
        this.window.getContentPane().removeAll();
        this.window.repaint();

        //stworzenie intertfejsu do odtwarzania pytań
        this.lGame = new JLabel("Gra w toku");
        this.lGame.setBounds(20,20,200,20);
        window.add(this.lGame);

        this.taQuestion = new JTextArea();
        this.taQuestion.setBounds(20,50,550,200);
        this.taQuestion.setEditable(false);
        window.add(this.taQuestion);

        this.bNextQuestion = new JButton("Następne");
        this.bNextQuestion.setBounds(300,300,100,30);
        this.bNextQuestion.addActionListener(this);
        window.add(this.bNextQuestion);

        this.lAnserw = new JLabel("Odpowiedź: ");
        this.lAnserw.setBounds(200,250,100,30);
        window.add(this.lAnserw);

        this.taAnserw = new JTextArea();
        this.taAnserw.setBounds(200,300,50,30);
        this.taAnserw.setLineWrap(true);
        window.add(this.taAnserw);

        this.checkActiveQuestionandButton();
    }
    private void makeAdminInterface(){
        this.window.getContentPane().removeAll();
        this.window.repaint();

        this.lUsers = new JLabel("Gracze: ");
        this.lUsers.setBounds(20,20,200,20);
        window.add(this.lUsers);

        this.taUsers = new JTextArea();
        this.taUsers.setBounds(20,50,550,200);
        this.taUsers.setEditable(false);
        //adding content
        this.loadData();
        window.add(this.taUsers);
    }
    private void loadQuestions() {
        try{
            FileReader inputHandler = new FileReader("q.txt");
            BufferedReader inputReader = new BufferedReader(inputHandler);
            String line;
            while((line = inputReader.readLine()) != null) {
                String[] i = line.split(";");
                questions.add( new Pytanie(
                        Integer.parseInt(i[0]),
                        i[1],
                        i[2],
                        i[3],
                        i[4],
                        i[5],
                        i[6].charAt(0)
                ));
            }
            inputReader.close();
        } catch (IOException exception){
            exception.printStackTrace();
            System.exit(1);
        }
    }
    private void checkActiveQuestionandButton(){
        if(this.bNextQuestion.getText().equals("Zakończono")) return;
        if(this.activeQuestion == this.questions.size()){
            JOptionPane.showMessageDialog(null, this.user.toString());
            this.bNextQuestion.setText("Zakończono");
            this.bNextQuestion.setEnabled(false);
            this.isQuizOver = true;
            this.saveData();
            this.saveActualStatus();
            return;
        }
        this.taQuestion.setText(this.questions.get(activeQuestion).toString());
    }
    private void saveData(){
        BinaryFileOperations ob = new BinaryFileOperations(this.user.name, this.user.points);
        try{
            DataOutputStream outputStream = new DataOutputStream(
                new FileOutputStream("dane.dat", true)
            );
            ob.saveData(outputStream);
            outputStream.close();
        } catch(IOException exc){
            exc.printStackTrace();
            System.exit(1);
        }
    }
    private void loadData(){
        try{
            DataInputStream inputStream = new DataInputStream(
                    new FileInputStream("dane.dat")
            );
            String content = BinaryFileOperations.loadData(inputStream);

            this.taUsers.setText(content);
        } catch (IOException exc){
            exc.printStackTrace();
            System.exit(1);
        }
    }
    private void saveActualStatus(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("appdata.ser")
            );
            outputStream.writeObject(this);
            outputStream.close();
            System.out.println("Zapisano stan aplikacji do pliku.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bAddUser){
            if(this.taUserName.getText().equals("") || this.taUserName.getText() == null) {
                JOptionPane.showMessageDialog(null, "Podaj imie gracza");
                return;
            } else {
                this.user.name = this.taUserName.getText();
                if(this.user.name.equals("admin")  || this.user.name.equals("Admin")){
                    //for admin
                    this.makeAdminInterface();
                } else {
                    //typical user
                    this.makeMainInterface();
                }
            }
        } else if (source == bNextQuestion){
            if(this.taAnserw.getText().equals("") || this.taAnserw.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Podaj odpowiedź!");
                return;
            }
            //checking for points
            this.user.points += this.questions.get(activeQuestion).checkAnserw(this.taAnserw.getText().charAt(0)) ? 1 : 0;

            //saving status
            this.saveActualStatus();

            //Update question
            this.activeQuestion++;

            //clearing anserw box
            this.taAnserw.setText("");

            //load chcek if there is another questions
            this.checkActiveQuestionandButton();
        }
    }
    public void run(){
        this.makeInterfaceInput();

    }
}