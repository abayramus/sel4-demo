package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class NewWindows {

    @Test
    public void newWindowsTest() throws IOException {
        //Creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //window 1 go to google
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        String googleHandle=driver.getWindowHandle();

        //window 2 go linkedin
        WebDriver window2 = driver.switchTo().newWindow(WindowType.WINDOW);
        window2.get("https://www.linkedin.com");
        System.out.println(window2.getTitle());
        String linkedinHandle=driver.getWindowHandle();

        //window 3 go to amazon
        WebDriver window3 = driver.switchTo().newWindow(WindowType.WINDOW);
        window3.get("https://www.amazon.com");
        System.out.println(window3.getTitle());
        String amazonHandle=driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());

        //switching between the windows
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN : "+window2.getCurrentUrl());
        Assert.assertTrue(window2.getCurrentUrl().contains("linkedin"));

        driver.switchTo().window(googleHandle);
        System.out.println("GOOGLE : "+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));

        driver.switchTo().window(amazonHandle);
        System.out.println("AMAZON : "+window3.getCurrentUrl());
        Assert.assertTrue(window3.getCurrentUrl().contains("amazon"));

    }
}
