package testSample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import page.YandexMailAuthPage;
import page.YandexMailInboxPage;
import page.YandexMailMainPage;
import utils.ReadFromUserData;


public class MailTest extends BaseTest {

    private String MAIL = ReadFromUserData.getValueFromConfig("UserMail", "UserData.properties");
    private String PASSWORD = ReadFromUserData.getValueFromConfig("UserPassword", "UserData.properties");
    private String TEXT = ReadFromUserData.getValueFromConfig("TextMessage", "UserData.properties");


    @BeforeMethod(description = "Вход в личный кабинет")
    public void loginMail() {
        YandexMailMainPage yandexMailMainPage = new YandexMailMainPage(getDriver());
        yandexMailMainPage.gotoYandexMail(getDriver());
        yandexMailMainPage.clickonButtonEnter(getDriver());
        YandexMailAuthPage yandexMailAuthPage = new YandexMailAuthPage(getDriver());
        yandexMailAuthPage.inputLogin(getDriver(), MAIL);
        yandexMailAuthPage.clickonLoginEnterButton(getDriver());
        yandexMailAuthPage.inputPassword(getDriver(), PASSWORD);
        yandexMailAuthPage.clickonPasswordEnterButton(getDriver());
    }

    @Test(description = "Отправка сообщения самому себе и проверка соответствия текста")
    public void SendMessage() {
        SoftAssert softAssert = new SoftAssert();
        YandexMailInboxPage yandexMailInboxPage = new YandexMailInboxPage(getDriver());
        yandexMailInboxPage.clickOnWriteButton(getDriver());
        yandexMailInboxPage.inputTo(MAIL);
        yandexMailInboxPage.inputTextMessage(TEXT);
        yandexMailInboxPage.clickOnSendButton(getDriver());
        yandexMailInboxPage.clickOnReturnButton(getDriver());
        yandexMailInboxPage.clickOnFirstMessage(getDriver());
        String a = yandexMailInboxPage.getTextMesage(getDriver());
        System.out.println(a);
        softAssert.assertEquals(a, TEXT);
        softAssert.assertAll();
        yandexMailInboxPage.checkImgProfile(getDriver());

    }

}
