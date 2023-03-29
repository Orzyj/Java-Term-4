import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class Gra extends JFrame implements ActionListener {
    private final ArrayList<Pole> map;
    private final ArrayList<Gracz> gracze;
    private int aktywnyGracz;
    private final JFrame window;
    private JLabel lTytul, lPole, lGracz, lPanelAkcji, lMenu, lPosiadlosciGracza;
    private JEditorPane taGracz, taInformacjePole, taPanelAkcji, taPosiadlosciGracza;
    private JButton bKupno, bKupnoDomka, bSprzedaz, bKoniecTury;
    public Gra(){
        map = new ArrayList<>();
        gracze = new ArrayList<>();
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Monopoly");
        window.setSize(700,500);
        window.setLayout(null);
        window.setResizable(false);

        this.tworzenieMapy();
        this.dodawanieGraczy();
        this.stworzInterfejsGUI();

        window.setVisible(true);
        this.odswiez();
    }
    private void stworzInterfejsGUI(){
        Font tytulFont = new Font("Arial", Font.BOLD, 20);

        lTytul = new JLabel("Gra Monopoly");
        lTytul.setBounds(220,20,200,20);
        lTytul.setFont(tytulFont);
        window.add(lTytul);

        lPole = new JLabel("Informacje o polu: ");
        lPole.setBounds(20,80,150,20);
        window.add(lPole);

        taInformacjePole = new JEditorPane();
        taInformacjePole.setBounds(20,110,150,100);
        taInformacjePole.setBackground(null);
        taInformacjePole.setEditable(false);
        taInformacjePole.setBorder(BorderFactory.createLoweredBevelBorder());
        window.add(taInformacjePole);

        lGracz = new JLabel("Gracz: ");
        lGracz.setBounds(200,80,150,20);
        window.add(lGracz);

        taGracz = new JEditorPane();
        taGracz.setBounds(200,110,150,100);
        taGracz.setEditable(false);
        taGracz.setBackground(null);
        taGracz.setBorder(BorderFactory.createLoweredBevelBorder());
        window.add(taGracz);

        lPanelAkcji = new JLabel("Aktualna akcja w grze: ");
        lPanelAkcji.setBounds(380,80,150,20);
        window.add(lPanelAkcji);

        taPanelAkcji = new JEditorPane();
        taPanelAkcji.setBounds(380, 110, 250, 100);
        taPanelAkcji.setEditable(false);
        taPanelAkcji.setBackground(null);
        taPanelAkcji.setBorder(BorderFactory.createLoweredBevelBorder());
        window.add(taPanelAkcji);

        lMenu = new JLabel("Menu: ");
        lMenu.setBounds(20,240,100,20);
        window.add(lMenu);

        //JButton bKupno, bKupnoDomka, bSprzedaz, bKoniecTury;
        bKupno = new JButton("Kup");
        bKupno.setBounds(20,270,100,25);
        bKupno.addActionListener(this);
        window.add(bKupno);

        bKupnoDomka = new JButton("Kup domek");
        bKupnoDomka.setBounds(20, 300, 100,25);
        bKupnoDomka.addActionListener(this);
        window.add(bKupnoDomka);

        bSprzedaz = new JButton("Sprzedaj");
        bSprzedaz.setBounds(20,330,100,25);
        bSprzedaz.addActionListener(this);
        window.add(bSprzedaz);

        bKoniecTury = new JButton("Koniec tury");
        bKoniecTury.setBounds(20,360,100,25);
        bKoniecTury.addActionListener(this);
        window.add(bKoniecTury);

        lPosiadlosciGracza = new JLabel("Posiadłości gracza: ");
        lPosiadlosciGracza.setBounds(200,270,150,25);
        lPosiadlosciGracza.setBackground(null);
        window.add(lPosiadlosciGracza);

        taPosiadlosciGracza = new JEditorPane();
        taPosiadlosciGracza.setEditable(false);
        taPosiadlosciGracza.setBackground(null);
        taPosiadlosciGracza.setBorder(BorderFactory.createLoweredBevelBorder());
        taPosiadlosciGracza.setBounds(200,300,250,120);
        window.add(taPosiadlosciGracza);

    }
    private void tworzenieMapy() {
        map.add(new Pole(0, "Start"));
        map.add(new Miasto(1, "Saloniki", 120));
        map.add(new Miasto(2, "Ateny", 120));
        map.add(new Media(3, "Koleje południowe", 400));
        map.add(new Miasto(4, "Rzym", 230));
        map.add(new Miasto(5, "Neapol", 220));
        map.add(new Miasto(6, "Mediolan", 210));
        map.add(new Miasto(7, "Barcelona", 120));
        map.add(new Media(8, "Elektrownia", 60));
        map.add(new Miasto(9, "Madryt", 260));
        map.add(new Miasto(10, "Barcelon", 270));
        map.add(new Miasto(11, "Liverpool", 320));
        map.add(new Miasto(12, "Glasgow", 340));
        map.add(new Miasto(13, "London", 350));
        map.add(new Miasto(14, "Amsterdam", 400));
        map.add(new Miasto(15, "Bruksela", 410));
        map.add(new Miasto(16, "Rotterdam", 420));
        map.add(new Media(17,"Koleje Północne",400));
        map.add(new Miasto(18,"Warszawa",550));
        map.add(new Miasto(19,"Poznań",460));
        map.add(new Miasto(20,"Opole",420));
        map.add(new Miasto(21,"Bonn",550));
        map.add(new Miasto(22,"Berlin",580));
        map.add(new Media(23,"Koleje wschodnie",400));
        map.add(new Miasto(24,"Insbruck",700));
        map.add(new Miasto(25,"Wiedeń",800));
    }
    private void dodawanieGraczy(){
        int ilosc = Integer.parseInt(JOptionPane.showInputDialog(null,"Wprowdź liczbe graczy"));
        for(int i = 0; i < ilosc; i++)
            gracze.add(new Gracz(Integer.toString(i),JOptionPane.showInputDialog(null,"ID: "+(i+1)+") Podaj nazwe gracza: ")));
        aktywnyGracz = 0;
    }
    private boolean sprawdzenieRozgrywki(){
        int j = 0;
        for (Gracz gracz :
                gracze) {
            if(gracz.czyBankrut == false)
                j++;
        }
        if(j==1)
            for(Gracz gracz :
                    gracze){
                if(gracz.czyBankrut == false){
                    taPanelAkcji.setText("Gracz który przetrwał na polu bitwy " + gracz.imie + " wygrał gre!");
                    return false;
                }
            }
        return true;
    }
    private String polaGracza(){
        String listaPolGracza = "";
        Object gracz = this.gracze.get(this.aktywnyGracz);

        for(Pole pole : map){
            if(pole.sprawdzeniePosiadlosci(gracze.get(this.aktywnyGracz)))
                listaPolGracza += pole.nazwa + "\n";
        }
        if(listaPolGracza == "")
            return "Gracz nie posiada posiadłości";

        return listaPolGracza;
    }
    private void sprawdzenieCzynszu(){
        if(map.get(gracze.get(aktywnyGracz).pozycja) instanceof Miasto){
            Object IDWlasciciela = ((Miasto) map.get(gracze.get(aktywnyGracz).pozycja)).IDWlasciciela;
            if(IDWlasciciela != null && IDWlasciciela != gracze.get(aktywnyGracz).IDgracza){
                String informacjaCzynsz = ((Miasto) map.get(gracze.get(aktywnyGracz).pozycja)).Czynsz(gracze.get(aktywnyGracz), gracze.get(Integer.parseInt(((Miasto) map.get(gracze.get(aktywnyGracz).pozycja)).IDWlasciciela)));
                taPanelAkcji.setText(informacjaCzynsz);
            }
        } else if (map.get(gracze.get(aktywnyGracz).pozycja) instanceof Media){
            Object IDWlasciciela = ((Media) map.get(gracze.get(aktywnyGracz).pozycja)).IDWlasciciela;
            if(IDWlasciciela != null && IDWlasciciela != gracze.get(aktywnyGracz).IDgracza){
                String informacjaCzynsz = ((Media) map.get(gracze.get(aktywnyGracz).pozycja)).Czynsz(gracze.get(aktywnyGracz), gracze.get(Integer.parseInt(((Media) map.get(gracze.get(aktywnyGracz).pozycja)).IDWlasciciela)));
                taPanelAkcji.setText(informacjaCzynsz);
            }
        }
    }
    private void odswiez(){
        String informacjeGracz = gracze.get(aktywnyGracz).przedstawSie();
        String informacjePole = map.get(gracze.get(aktywnyGracz).pozycja).informacjePole();
        String informacjePosiadloscGracza = polaGracza();

        sprawdzenieCzynszu();
        taGracz.setText(informacjeGracz);
        taInformacjePole.setText(informacjePole);
        taPosiadlosciGracza.setText(informacjePosiadloscGracza);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!sprawdzenieRozgrywki())
            return;

        Object source = e.getSource();
        int pozycjaGracza = gracze.get(aktywnyGracz).pozycja;

        if(source == bKupno){
            taPanelAkcji.setText(map.get(pozycjaGracza).kup(gracze.get(aktywnyGracz)));
        } else if (source == bKupnoDomka){
            taPanelAkcji.setText(map.get(pozycjaGracza).kupDomek(gracze.get(aktywnyGracz)));
        } else if (source == bSprzedaz){
            taPanelAkcji.setText(map.get(pozycjaGracza).sprzedaj(gracze.get(aktywnyGracz)));
        } else if(source == bKoniecTury){
            if (aktywnyGracz >= gracze.size()-1)
                aktywnyGracz = 0;
            else aktywnyGracz++;
            gracze.get(aktywnyGracz).ruchPoPlanszy();
        }

        odswiez();
    }
}