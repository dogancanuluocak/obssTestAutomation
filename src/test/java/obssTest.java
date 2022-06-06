import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class obssTest {
    private static WebElement eLement = null;
    public static void main(String[] args){
        DesiredCapabilities caps = new DesiredCapabilities();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();
        //Cookies policy discard

        contentSettings.put("cookies",2);
        profile.put("managed_default_content_settings",contentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs",prefs);
        caps.setCapability(ChromeOptions.CAPABILITY,options);
        //Starting chrome driver

        WebDriver driver = new ChromeDriver(caps);
        driver.get("https://obss.com.tr/en/");
        //Maximize the driver
        driver.manage().window().maximize();
        //Wait a 1000ms
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        //click on the search bar
        driver.findElement(By.id("search-icon")).click();
        //write "automation" on the search bar
        driver.findElement(By.id("search-box")).sendKeys("Automation",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        //Verify Testing automation page
       boolean eLement= driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/article[1]/h2/a")).isDisplayed();
        System.out.println("Testing Automation Page is displayed ="  +eLement);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/article[1]/h2/a")).click();
        //scroll down the bottom
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[5]"));
        //Check if the footer is seen on the bottom
        boolean element= driver.findElement(By.xpath("/html/body/div[5]")).isEnabled();
        System.out.println("Footer is seen on the bottom ="  +element);

       //close browser
        driver.quit();

        }
        @Test
    public static WebElement testingAutomationPage_Check(WebDriver driver){
      eLement=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/article[1]/h2/a"));
      Assert.assertEquals(true,true);
      return eLement;
    }
       @Test
    public static WebElement footer_Check(WebDriver driver){
         eLement=driver.findElement(By.xpath("/html/body/div[5]"));
        Assert.assertEquals(true,"Footer is seen on the bottom");
        return  eLement;

    }
    }


