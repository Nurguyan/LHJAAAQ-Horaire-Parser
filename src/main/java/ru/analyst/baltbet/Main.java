package ru.analyst.baltbet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093").get();
        String title = doc.title();
//        Elements urls = doc.getElementsByAttributeValueContaining("class", "ellipsis_wrapper link_container");
//        Elements urls = doc.getElementsByClass( "ellipsis_wrapper link_container");
        Elements scripts = doc.select("script.schedule_tpl");
        String relHref = scripts.attr("href");
        String absHref = scripts.attr("abs:href");
        for (Element script : scripts) {
            String type = script.attr("type");
            if (type.contentEquals("text/x-handlebars-template")) {
                String scriptData = script.data(); // your text from the script
                System.out.println(scriptData);
                break;
            }
        }

//        System.out.println(scripts.size());
//        System.out.println(title);
//        System.out.println(scripts.first().getElementsByClass("table_container"));
//        System.out.println(relHref);
//        System.out.println(absHref);
    }
}
