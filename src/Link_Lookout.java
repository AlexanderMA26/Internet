import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class Link_Lookout {

    String links = "";

    public String LinkTest(){
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/Barack_Obama");
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("http")) {
                    int start = line.indexOf("https");

                    int end = line.indexOf("\"", start);

                    links += line.substring(start, end);
                }
            }

            reader.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return links;
    }

}
