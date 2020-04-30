package TestSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ReadFromUserData;


public class MailTest extends BaseTest {

    private String LOGIN = ReadFromUserData.getValueFromConfig("UserLogin");
    private String PASSWORD = ReadFromUserData.getValueFromConfig("UserPassword");
    private String TEXT = ReadFromUserData.getValueFromConfig("TextMessage");



    @BeforeMethod(description = "Вход в личный кабинет")
    public void loginMail() {
        BaseTest.getDriver().get("https://mail.yandex.ru/");
        try {
            BaseTest.getDriver().findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[]")).click();
        } catch (Exception a) {
            a.printStackTrace();
            System.out.println("Веб-элемент не найден");
        }
        BaseTest.getDriver().findElement(By.id("passp-field-login")).sendKeys(LOGIN);
        BaseTest.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
        BaseTest.getDriver().findElement(By.id("passp-field-passwd")).sendKeys(PASSWORD);
    }

    @Test(description = "Отправка сообщения самому себе и проверка соответствия текста")
    public void SendMessage() {
        BaseTest.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
        BaseTest.getDriver().findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[3]/div[2]/div[2]/div/div/a")).click();
        BaseTest.getDriver().findElement(By.xpath("//div[@class='composeYabbles']")).sendKeys(LOGIN);
        BaseTest.getDriver().findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']")).sendKeys(TEXT);
        BaseTest.getDriver().findElement(By.xpath("//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")).click();
        BaseTest.getDriver().findElement(By.linkText("Вернуться во \"Входящие\"")).click();
        BaseTest.getDriver().findElement(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_firstline js-message-snippet-firstline']")).click();
        String a = BaseTest.getDriver().findElement(By.xpath("//div[@class='mail-Message-Body-Content']")).getText();
        System.out.println(a);
        Assert.assertEquals(a, TEXT);
    }


}
