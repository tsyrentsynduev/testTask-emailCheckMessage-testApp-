package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;


public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @Step("Инициализация веб-элемента")
    public WebElement getWebelement(WebDriver driver, String locator) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(locator));
        } catch (NoSuchElementException a) {
            System.out.println("Веб-элемент не найден");
            driver.quit();
        } catch (InvalidSelectorException b) {
            System.out.println("Невозможно найти элемент с выражением xpath");
            driver.quit();
        }
        return element;
    }

    @Step("Клик по элементу xpath")
    public void click(WebDriver driver, String locator) {
        getWebelement(driver, locator).click();

    }

    @Step("Ввод текста по локатору xpath")
    public void sendkeys(WebDriver driver, String locator, String text) {
        getWebelement(driver, locator).sendKeys(text);
    }

    @Step("Получение текста из области по xpath")
    public String gettext(WebDriver driver, String locator) {
        return getWebelement(driver, locator).getText();
    }
}
