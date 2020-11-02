package ru.analyst.baltbet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://www.lhjaaaq.com/fr/stats/horaire.html?season=2359&subSeason=2371&category=1093";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nkornilov\\Downloads\\chromedriver_win32\\chromedriver.exe");
        String item = "Sommaire";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get(url);
            final WebElement schedule_container = driver.findElement(By.className("schedule_container"));
            //String html = schedule_container.getAttribute("innerHTML");
            List<WebElement> linkList = schedule_container.findElements(By.tagName("a"));
            for (WebElement link : linkList) {
                if (link.getText().equals(item)){
                    System.out.println(link.getText() + " - " + link.getAttribute("href"));
                    driver.get(link.getAttribute("href"));
                    final String match_date = driver.findElement(By.className("date_container bg_primary")).getText();
                    WebElement season_stats = driver.findElement(By.id("season_stats"));
                    System.out.println(match_date  + ": " + season_stats.getText());
                }
            }
        } finally {
            driver.quit();
        }
    }
}
