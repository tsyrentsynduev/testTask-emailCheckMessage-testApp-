package testSample;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    public static final int ELEMENT_TIMEOUT = 1;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        try {
//            new BaseTest().safeclick(EnterButton,2);
//        } catch (Exception a) {
//            a.printStackTrace();
//            System.out.println("Веб-элемент не найден");
//        }
    }
    @BeforeTest
    public void profileSetup() {
        BaseTest.driver.manage().window().maximize();
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
