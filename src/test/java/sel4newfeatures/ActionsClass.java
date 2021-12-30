package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {


    @Test
    public void actions1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("iphoneX");

        //NEW IN SELENIUM 4-> code is now shorter
        Actions actions = new Actions(driver);
        //double click
        actions.doubleClick(searchBox).perform();
        //right click
        actions.contextClick(searchBox).perform();

    }

}
