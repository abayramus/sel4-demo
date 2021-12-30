package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class NewTabs {

    @Test
    public void newTabsTest() throws IOException {
        //creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //opening google on teh first tab
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        //NEW WITH SELENIUM 4- opening a new TAB and going to linkedin
        WebDriver tab2 = driver.switchTo().newWindow(WindowType.TAB);
        tab2.get("https://www.linkedin.com");
        System.out.println(tab2.getTitle());

        //NEW WITH SELENIUM 4- opening a new TAB and going to amazon
        WebDriver tab3 = driver.switchTo().newWindow(WindowType.TAB);
        tab2.get("https://www.amazon.com");
        System.out.println(tab3.getTitle());



    }
}
