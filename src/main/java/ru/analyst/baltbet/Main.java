package ru.analyst.baltbet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<String> getMatchesUrls(String url, WebDriver driver) {
        List<String> matchesUrls = new ArrayList<>();
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='statistic_displayer']/tbody/tr/td[8]/div/a[@title='Sommaire du match']"));
        elements.forEach((webElement -> matchesUrls.add(webElement.getAttribute("href"))));
        return matchesUrls;
    }

    private static List<String> getMatchInfo(String url, WebDriver driver){
        driver.get(url);
        String date = driver.findElement(By.xpath("//span[@class='date']")).getText();
        List<WebElement> teams = driver.findElements(By.xpath("//div[contains(@class,'section season_stats_section')]/div[contains(@class,'table_container')]/table[@class='statistic_displayer']/tbody/tr"));
        List<String> matchInfo = new ArrayList<>(2);
        teams.forEach((team -> matchInfo.add(date.substring(date.indexOf(' ')+1).replace(",","") + ' ' + team.getText())));
        return matchInfo;
    }

    public static void main(String[] args) throws IOException {
        String statsUrl = "https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093";
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        FileWriter writer = new FileWriter("stats.csv");
        char delimiter = ';';
        writer.append("Day");
        writer.append(delimiter);
        writer.append("Month");
        writer.append(delimiter);
        writer.append("Year");
        writer.append(delimiter);
        writer.append("Time");
        writer.append(delimiter);
        writer.append("Team");
        writer.append(delimiter);
        writer.append("BP");
        writer.append(delimiter);
        writer.append("BC");
        writer.append(delimiter);
        writer.append("BP%");
        writer.append(delimiter);
        writer.append("BC%");
        writer.append(delimiter);
        writer.append("Tirs%");
        writer.append(delimiter);
        writer.append("TR%");
        writer.append(delimiter);
        writer.append("AN%");
        writer.append(delimiter);
        writer.append("DN%");
        writer.append(delimiter);
        writer.append("PUN");
        writer.append(System.getProperty( "line.separator"));

        List<String> matchesUrls = getMatchesUrls(statsUrl, driver);
        for (String matchUrl : matchesUrls) {
            List<String> matchInfos = getMatchInfo(matchUrl, driver);
            for (String matchInfo : matchInfos) {
                String line = matchInfo.replace(" %", "") .replace(' ', delimiter);
                System.out.println(line);
                writer.append(line);
                writer.append(System.getProperty( "line.separator"));
            }
        }

        writer.flush();
        writer.close();
        driver.quit();
    }
}
