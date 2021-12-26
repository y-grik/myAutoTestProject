package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver(){
    }

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ig0re\\IdeaProjects\\myAutoTestProject\\src\\main\\resources\\chromedriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
        }
        return driver;
    }

    public static void tearDown(){
        driver.quit();
        driver = null;
    }
}
