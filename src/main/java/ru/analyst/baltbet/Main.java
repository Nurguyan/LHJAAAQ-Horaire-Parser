package ru.analyst.baltbet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<String> getMatchesUrls(String url, WebDriver driver) {
        List<String> matchesUrls = new ArrayList<>();
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='statistic_displayer']/tbody/tr/td[8]/div/a[@title='Sommaire du match']"));
        elements.forEach((webElement -> {
            String match = webElement.getAttribute("href");
            matchesUrls.add(match);
            System.out.println(match);
        }));
        System.out.println("Total matches: " + elements.size());
        return matchesUrls;
    }

    private static MatchInfo getMatchInfo(String url, WebDriver driver) {
        driver.get(url);
        List<WebElement> teams = driver.findElements(By.xpath("//div[contains(@class,'section season_stats_section')]/div[contains(@class,'table_container')]/table[@class='statistic_displayer']/tbody/tr"));
        TeamStats visitor;
        try {
            int score_visitor = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score visitor']")).getText());
            int score_local = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score local']")).getText());
            if (score_local > score_visitor) result = "Win";
            else if (score_local < score_visitor) result = "Loss";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        teams.forEach((team -> matchInfo.add(getDate(driver) + delimiter + team.getText().replace(" %", "") .replace(' ', delimiter) + delimiter + getMatchResult(driver))));
        return matchInfo;
    }

    private static TeamStats parseWebElement(WebElement webElement){
        String stats = webElement.getText().replace(" %", "");
        String[] data = stats.split(" ");
        TeamStatsBuilder teamStatsBuilder;
        teamStatsBuilder.data[]
        TeamStats teamStats(data);
        return teamStats;
    }

    private static String getMatchResult(boolean isHome, WebDriver driver) {
        try {
            int score_visitor = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score visitor']")).getText());
            int score_local = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score local']")).getText());
            if (score_local > score_visitor) return "Win";
            else if (score_local < score_visitor) return "Loss";
            else return "Draw";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static LocalDate getDate(WebDriver driver) {
        String dateTime = driver.findElement(By.xpath("//span[@class='date']")).getText();                                      //get input date in french
        String dateInFrench = dateTime.substring(dateTime.indexOf(' ')+1, dateTime.indexOf(',')).toLowerCase(Locale.FRANCE);    //remove day of week and time
        //convert from French to numeric format
        DateTimeFormatter frenchFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(dateInFrench, frenchFormatter);
    }

    private static void help() {
        System.out.println("Incorrect arguments: args[0] must be an URL to LHJAAAQ Horaire page. Example: https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093. args[1] is output file name.");
    }

    /*
    args[0] - input URL from https://www.lhjaaaq.com/fr/stats, example: arg[0] - https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093
    args[1] - output file name, example: statistics2018-2019.csv
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                System.out.println("URL: " + args[0]);
                System.out.println("Output: " + args[1]);
                String statsUrl = args[0];
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                FileWriter writer = new FileWriter(args[1]);
                char delimiter = ';';
                writer.append("Date");
                writer.append(delimiter);
                writer.append("Location");
                writer.append(delimiter);
                writer.append("Team");
                writer.append(delimiter);
                writer.append("GF");
                writer.append(delimiter);
                writer.append("GA");
                writer.append(delimiter);
                writer.append("GF%");
                writer.append(delimiter);
                writer.append("GA%");
                writer.append(delimiter);
                writer.append("Sh%");
                writer.append(delimiter);
                writer.append("Sv%");
                writer.append(delimiter);
                writer.append("PP%");
                writer.append(delimiter);
                writer.append("PK%");
                writer.append(delimiter);
                writer.append("PUN");
                writer.append(delimiter);
                writer.append("Final");
                writer.append(System.getProperty( "line.separator"));

                List<String> matchesUrls = getMatchesUrls(statsUrl, driver);
                for (String matchUrl : matchesUrls) {
                    List<String> matchInfos = getMatchInfo(matchUrl, driver);
                    for (String matchInfo : matchInfos) {
                        System.out.println(matchInfo);
                        writer.append(matchInfo);
                        writer.append(System.getProperty( "line.separator"));
                    }
                }
                writer.flush();
                writer.close();
                driver.quit();
            } catch (IOException e) {
                e.printStackTrace();
                help();
            }
        }
        else
        {
            help();
        }
    }
}
