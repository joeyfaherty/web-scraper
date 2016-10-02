import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SportTableScraper {

    public static final String URL = "http://www.espnfc.com/english-premier-league/23/table";

    public static void main(String[] args) {

        // establish a connection to the site
        Document document = getConnection();

        // select a html element example: div.content
        Elements elements = document.select("table");

        // for each element get all tables
        for (Element table : elements) {
            // for each table get all rows
            for (Element row : table.select("tr")) {
                // for each row get all columns
                Elements tds = row.select("td");
                // now we have the column data to save in excel, database, print etc
                if (tds.size() == 24) {
                    System.out.println("Team: " + tds.get(1).text());
                    System.out.println("League Position: " + tds.get(0).text());
                    System.out.println("Goal Difference: " + tds.get(22).text());
                    System.out.println("Points: " + tds.get(23).text() + "\n");
                }
            }
        }
    }

    private static Document getConnection() {
        try {
            return Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
