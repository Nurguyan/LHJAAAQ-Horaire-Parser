package ru.analyst.baltbet;

import jdk.internal.net.http.common.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> getMatchesUrls(String url, WebDriver driver) {
        List<String> matchesUrls = new ArrayList<>();
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='statistic_displayer']/tbody/tr/td[8]/div/a[@title='Sommaire du match']"));
        elements.forEach((webElement -> matchesUrls.add(webElement.getAttribute("href"))));
        return matchesUrls;
    }

    private static Pair<String, String> getMatchInfo(String url, WebDriver driver){
        driver.get(url);
        List<WebElement> teams = driver.findElements(By.xpath("//div[contains(@class,'section season_stats_section')]/div[contains(@class,'table_container')]/table[@class='statistic_displayer']/tbody/tr"));
        Pair<String, String> info = new Pair<>(teams.get(0).getText(), teams.get(1).getText());
        return info;
    }

    public static void main(String[] args) {
        String statsUrl = "https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093";
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        List<String> matchesUrls = getMatchesUrls(statsUrl, driver);
        getMatchInfo("https://www.lhjaaaq.com/fr/stats/sommaire.html?season=2359&subSeason=2371&category=1093&game=791202", driver);
        driver.quit();
    }
}
