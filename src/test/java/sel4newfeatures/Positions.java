package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class Positions {
    @Test
    public void positionsTest() throws IOException {

        //creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //going to google
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        //getting the logo element
        WebElement logo = driver.findElement (By.xpath("//img[@id='hplogo']"));
        //getting the height of the logo
        System.out.println("Height of logo => "+logo.getRect().getDimension().getHeight());
        //getting the  width of the logo
        System.out.println("Width of logo => "+logo.getRect().getDimension().getWidth());
        //getting the height x coordinate
        System.out.println("X location logo => "+logo.getRect().getX());
        //getting the height y coordinate
        System.out.println("Y location logo => "+logo.getRect().getY());
    }
}
