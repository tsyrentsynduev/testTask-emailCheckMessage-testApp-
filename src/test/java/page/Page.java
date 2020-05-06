package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @Step("Клик по элементу xpath")
    public void click(WebDriver driver, String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
        } catch (Exception a) {
            System.out.println("Веб-элемент не найден");
            driver.quit();
        }
    }

    @Step("Ввод текста по локатору xpath")
    public void sendkeys(WebDriver driver, String locator, String text) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        } catch (Exception a) {
            System.out.println("Веб-элемент не найден");
            driver.quit();
        }
    }

    @Step("Получение текста из области по xpath")
    public String gettext(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }
}
