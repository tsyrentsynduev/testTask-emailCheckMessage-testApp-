package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadFromUserData;

public class YandexMailInboxPage extends Page {
    Page page = new Page(driver);
    private String writeButtonLocator = ReadFromUserData.getValueFromConfig("writeButtonLocator", "InboxPageYandexMail.properties");
    private String fieldtoMessageLocator = ReadFromUserData.getValueFromConfig("fieldtoMessageLocator", "InboxPageYandexMail.properties");
    private String fieldTextMessageLocator = ReadFromUserData.getValueFromConfig("fieldTextMessageLocator", "InboxPageYandexMail.properties");
    private String sendButtonLocator = ReadFromUserData.getValueFromConfig("sendButtonLocator", "InboxPageYandexMail.properties");
    private String firstMessageLocator = ReadFromUserData.getValueFromConfig("firstMessageLocator", "InboxPageYandexMail.properties");
    private String textInMessageLocator = ReadFromUserData.getValueFromConfig("textInMessageLocator", "InboxPageYandexMail.properties");

    public YandexMailInboxPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопку \"Написать\"")
    public void clickOnWriteButton(WebDriver driver) {
        page.click(driver, writeButtonLocator);
    }

    @Step("Ввод почты адресата")
    public void inputTo(String Email) {
        page.sendkeys(driver, fieldtoMessageLocator, Email);
    }

    @Step("Ввод текста сообщения")
    public void inputTextMessage(String Text) {
        page.sendkeys(driver, fieldTextMessageLocator, Text);
    }

    @Step("Клик по кнопке \"Отправить\"")
    public void clickOnSendButton(WebDriver driver) {
        page.click(driver, sendButtonLocator);
    }

    @Step("Клик по первому входящему сообщению")
    public void clickOnFirstMessage(WebDriver driver) {
        page.click(driver, firstMessageLocator);
    }

    @Step("Получение текста сообщения")
    public String getTextMesage(WebDriver driver) {
        String a = page.gettext(driver, textInMessageLocator);
        return a;
    }
    @Step("Клик по кнопке \"Вернуться\"")
    public void clickOnReturnButton(WebDriver driver){
        driver.findElement(By.linkText("Вернуться во \"Входящие\"")).click();
    }
}
