import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by manuela on 01/10/16.
 */
public class Example {
    public static void main(String[] args) throws IOException {
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://www.betvictor.com/sports/en/football/coupons/100/0/0/43438/0/100/0/0/0/0/1").timeout(10000).get();

            // get all links
            Elements matches = doc.select("td.event_description a");
            Elements odds = doc.select("td.event_description a");
            for (Element match : matches) {

                // get the value from href attribute

                String matchEvent = match.text();
                String[] parts = matchEvent.split(" v ");
                String team1 = parts[0];
                String team2 = parts[1];
                System.out.println("text : " + team1 + " v " + team2);

            }
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
    }

}
