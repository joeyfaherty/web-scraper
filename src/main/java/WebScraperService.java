import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraperService {

    public static final String URL = "http://flashscore.com";

    public static void main(String[] args) throws IOException {
        Document document = getConnection();
        System.out.println("title is : " + getTitle(document));
        printAllLinksInDocument(document);
        printMetadataOfUrl(document);
    }

    private static Document getConnection() {
        try {
            return Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getTitle(Document document) {
        return document.title();
    }

    private static void printAllLinksInDocument(Document document) {
        Elements links = document.select("a[href]");
        for (Element link : links) {
          System.out.println("link: " + link.attr("href"));
            System.out.println("text: " + link.text());
        }
    }

    private static void printMetadataOfUrl(Document document) {
        String keywords = document.select("meta[name=keywords]").first().attr("content");
        System.out.println("Meta keyword : " + keywords);
        String description = document.select("meta[name=description]").get(0).attr("content");
        System.out.println("Meta description : " + description);
    }

    private static void printFormParameters(Document document) {
        Element loginform = document.getElementById("registerform");

        Elements inputElements = loginform.getElementsByTag("input");
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");
            System.out.println("Param name: "+key+" \nParam value: "+value);
        }
    }


}
