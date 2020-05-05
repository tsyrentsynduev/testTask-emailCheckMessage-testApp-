package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.ReadFromUserData;

public class YandexMailMainPage extends Page {
    private String enterButtonLocator = ReadFromUserData.getValueFromConfig("enterButtonLocator", "MainPageYandexMail.properties");
    Page page = new Page(driver);


    public YandexMailMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на Яндекс почту")
    public void gotoYandexMail(WebDriver driver) {
        driver.get("https://mail.yandex.ru/");
    }

    @Step("Клик по кнопке Войти")
    public void clickonButtonEnter(WebDriver driver) {
        page.click(driver, enterButtonLocator);
    }

}
