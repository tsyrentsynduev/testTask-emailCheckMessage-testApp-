package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadFromUserData;

public class YandexMailAuthPage extends Page {
    private String loginEnterButtonLocator = ReadFromUserData.getValueFromConfig("loginEnterButtonLocator", "AuthPageYandexMail.properties");
    private String passwordEnterButtonLocator = ReadFromUserData.getValueFromConfig("passwordEnterButtonLocator", "AuthPageYandexMail.properties");
    Page page = new Page(driver);

    public YandexMailAuthPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод логина")
    public void inputLogin(WebDriver driver, String LOGIN) {
        driver.findElement(By.id("passp-field-login")).sendKeys(LOGIN);
    }

    @Step("Клик по кнопке войти после ввода логина")
    public void clickonLoginEnterButton(WebDriver driver) {
        page.click(driver, loginEnterButtonLocator);
    }

    @Step("Ввод пароля")
    public void inputPassword(WebDriver driver, String PASSWORD) {
        driver.findElement(By.id("passp-field-passwd")).sendKeys(PASSWORD);
    }

    @Step("Клик по кнопке войти после ввода пароля")
    public void clickonPasswordEnterButton(WebDriver driver) {
        page.click(driver, passwordEnterButtonLocator);
    }
}
