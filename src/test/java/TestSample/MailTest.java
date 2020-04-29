package TestSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MailTest {
    private WebDriver driver;
    private String LOGIN1 = "";
    private String PASSWORD1 = "";
    private String Textmessage = "";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginMail() throws InterruptedException {
        driver.get("https://mail.yandex.ru/");
        driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys(LOGIN1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
        driver.findElement(By.id("passp-field-passwd")).sendKeys(PASSWORD1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[3]/div[2]/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//div[@class='composeYabbles']")).sendKeys(LOGIN1);
        driver.findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']")).sendKeys(Textmessage);
        driver.findElement(By.xpath("//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")).click();
        driver.findElement(By.linkText("Вернуться во \"Входящие\"")).click();
        driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_firstline js-message-snippet-firstline']")).click();
        String a = driver.findElement(By.xpath("//div[@class='mail-Message-Body-Content']")).getText();
        System.out.println(a);
        Assert.assertEquals(a, Textmessage);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
