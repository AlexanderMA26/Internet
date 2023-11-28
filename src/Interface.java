import javax.swing.*;
import java.awt.*;

public class Interface {
    private JFrame mainframe;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private TextArea ta;



    public Interface(){
        prepareGUI();
    }

    public static void main(String[] args) {
        Interface main = new Interface();
    }
    public static void prepareGUI(){
        JFrame mainframe = new JFrame("Medium2");
        mainframe.setBounds(0,0,1800,800);
        mainframe.setLayout(new BorderLayout());
        JPanel searches = new JPanel();
        searches.setSize(1800, 50);
        searches.setLayout(new GridLayout(1, 2));

        TextArea url = new TextArea("Paste URL");
        TextArea link = new TextArea("Search Links");
        TextArea results = new TextArea("Results displayed here");

        searches.add(url);
        searches.add(link);

        mainframe.add(searches, BorderLayout.NORTH);
        mainframe.add(results, BorderLayout.SOUTH);


        mainframe.setVisible(true);



    }
}