package first.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SeleniumTest {

    //declare Selenium WebDriver
    private WebDriver webDriver;

    @BeforeTest
    public void preTestSetup () {
        //Setting system properties of ChromeDriver
        //to amend directory path base on your local file path
        String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverDir);

        //initialize FirefoxDriver at the start of test
        webDriver = new ChromeDriver();
    }

    @Test
    public void checkingPageTitle() {
        //Load website as a new page
        webDriver.navigate().to("localhost:8090/maven-web-project/");

        //Assert the title to check that we are indeed in the correct website
        Assert.assertEquals(webDriver.getTitle(), "Home");

        System.out.println("title: "+webDriver.getTitle());

        //Retrieve link using it's class name and click on it
        webDriver.findElement(By.linkText("Click to go to user registration")).click();

        //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
        Assert.assertTrue(webDriver.getTitle().contains("Wikipedia"));
        System.out.println("new title: "+webDriver.getTitle());
    }

    @AfterTest
    public void afterTest() {
        //Quit the ChromeDriver and close all associated window at the end of test
        webDriver.quit();
    }
}