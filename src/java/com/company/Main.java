package com.company;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        TeamStatsBuilder visitor = parseWebElement(teams.get(0));
        TeamStatsBuilder local = parseWebElement(teams.get(1));
        int visitorScore = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score visitor']")).getText());
        int localScore = Integer.parseInt(driver.findElement(By.xpath("//span[@class='score local']")).getText());
        visitor.setLocation("Away").setScore(Integer.toString(visitorScore));
        local.setLocation("Home").setScore(Integer.toString(localScore));
        if (localScore > visitorScore) {
            local.setResult("Win");
            visitor.setResult("Loss");
        } else if (localScore < visitorScore) {
            local.setResult("Loss");
            visitor.setResult("Win");
        } else {
            local.setResult("Draw");
            visitor.setResult("Draw");
        }
        DateTimeFormatter numericFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = getDate(driver).format(numericFormatter);
        local.setDate(date);
        visitor.setDate(date);
        return new MatchInfo(local.createTeamStats(), visitor.createTeamStats());
    }

    private static TeamStatsBuilder parseWebElement(WebElement webElement) {
        String stats = webElement.getText().replace(" %", "");
        String[] data = stats.split(" ");
        TeamStatsBuilder teamStatsBuilder = new TeamStatsBuilder();
        teamStatsBuilder.setName(data[0]).setGF(data[1]).setGA(data[2]).setGFp(data[3]).setGAp(data[4]).setShp(data[5]).setSvp(data[6]).setPPp(data[7]).setPKp(data[8]).setPUN(data[9]);
        return teamStatsBuilder;
    }

    private static LocalDate getDate(WebDriver driver) {
        String dateTime = driver.findElement(By.xpath("//span[@class='date']")).getText();                                      //get input date in french
        String dateInFrench = dateTime.substring(dateTime.indexOf(' ') + 1, dateTime.indexOf(',')).toLowerCase(Locale.FRANCE);    //remove day of week and time
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

                File file = new File(args[1]);
                FileWriter outfile = new FileWriter(file);
                CSVWriter writer = new CSVWriter(outfile);
                String[] header = {"Date", "Location", "Team", "GF", "GA", "GF%", "GA%", "Sh%", "Sv%", "PP%", "PK%", "PenaltyTime", "Final", "Score"};
                writer.writeNext(header);

                List<String> matchesUrls = getMatchesUrls(statsUrl, driver);
                for (String matchUrl : matchesUrls) {
                    MatchInfo matchInfo = getMatchInfo(matchUrl, driver);
                    System.out.println(matchInfo.local.toString());
                    System.out.println(matchInfo.visitor.toString());
                    writer.writeNext(matchInfo.local.toStringArray());
                    writer.writeNext(matchInfo.visitor.toStringArray());
                }
                writer.flush();
                writer.close();
                driver.quit();
            } catch (IOException e) {
                e.printStackTrace();
                help();
            }
        } else {
            help();
        }
    }
}
