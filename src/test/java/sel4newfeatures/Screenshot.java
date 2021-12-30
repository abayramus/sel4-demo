package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    @Test
    public void getScreenShotTest() throws IOException {
        //Creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Going to the google page
        driver.get("https://www.google.com");
        //Maximizing the window
        driver.manage().window().maximize();

        //Getting the image of the google logo and saving it
        WebElement logo = driver.findElement (By.xpath("//img[@id='hplogo']"));
        File logoFile = logo.getScreenshotAs(OutputType.FILE);
        File logoDestFile =new File("logo.png");
        FileUtils.copyFile(logoFile,logoDestFile);


        //Getting the screen shot of sign in button
        WebElement signInButton = driver.findElement(By.xpath("//a[(text()='Sign in')]"));
        File signInButtonFile = signInButton.getScreenshotAs(OutputType.FILE);
        File signInButtonDestFile =new File("signInButton.png");
        FileUtils.copyFile(signInButtonFile,signInButtonDestFile);
    }
}
