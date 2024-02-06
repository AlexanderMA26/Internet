import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;


public class Interface {


    public TextArea results = new TextArea("Links\n");
    public TextField url = new TextField("Enter url here");
    public TextField link = new TextField("Enter search");





    public Interface(){
        prepareGUI();
    }

    public static void main(String[] args) {
        Interface main = new Interface();
    }
    public void prepareGUI(){
        JFrame mainframe = new JFrame("Medium2");
        mainframe.setBounds(0,0,1800,800);
        mainframe.setLayout(new BorderLayout());
        JPanel searches = new JPanel();
        searches.setSize(1800, 10);
        searches.setLayout(new GridLayout(1, 2));
        results.setEditable(false);

        searches.add(url);
        searches.add(link);

        mainframe.add(searches, BorderLayout.NORTH);
        mainframe.add(results, BorderLayout.CENTER);


        url.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                linkCheck();
                System.out.println("Event heard");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        link.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                linkCheck();
                System.out.println("Event Heard");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });




        mainframe.setVisible(true);





    }

    public void linkCheck(){
        results.setText("");
        try {
            String userUrl = url.getText();
            URL imputurl = new URL(userUrl);

            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(imputurl.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("http")) {

                    int start = line.indexOf("https");

                    int end = line.indexOf("\"", start);

                    if (!Objects.equals(link.getText(), "Enter search") && line.contains(link.getText())) {
                        System.out.println(line.substring(start, end));
                        results.append(line.substring(start, end));
                        results.append("\n");
                    } else if (Objects.equals(link.getText(), "Enter search")) {
                        System.out.println(line.substring(start, end));
                        results.append(line.substring(start, end));
                        results.append("\n");
                    }

                }
            }

            reader.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    }

