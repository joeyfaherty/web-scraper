import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by manuela on 01/10/16.
 */
public class TennisScraper {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.flashscore.com/tennis/").timeout(3000).get();
        Element matches = document.getElementById("g_2_d6lSjOrL");
        Elements select = document.getElementsByClass("copyright");
        Elements allElements = document.getAllElements();
        Elements content = document.getElementsByClass("content");

        String html = content.html();
        boolean flag = html.toLowerCase().contains("lajovic");
        System.out.println(flag);

    }
}
