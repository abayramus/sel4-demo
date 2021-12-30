package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsClass {

    @Test
    public void relativeLocatorsTest1() {
        //creating the driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //going to google
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        //locating the google image
        WebElement logo = driver.findElement (By.xpath("//img[@id='hplogo']"));


        //NEW IN SEL 4: finding the input that is BELOW google logo
        WebElement searchBox = driver
                .findElement (RelativeLocator.with(By.tagName("input"))
                .below(logo));


        searchBox.sendKeys("Iphone latest model"+Keys.ENTER);

    }

    @Test
    public void relativeLocatorsTest2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement searchButton = driver.findElement (By.xpath("(//input[@value='Google Search'])[last()]"));

        WebElement luckyButton = driver
                .findElement (RelativeLocator.with(By.tagName("input"))
                        .toRightOf(searchButton));

        luckyButton.click();

    }

}
