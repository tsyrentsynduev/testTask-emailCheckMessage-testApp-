package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

}

    @Step("Клик по элементу xpath")
    public void click(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    @Step("Ввод текста по локатору xpath")
    public void sendkeys(WebDriver driver, String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    @Step("Получение текста из области по xpath")
    public String gettext(WebDriver driver, String locator) {
        String a = driver.findElement(By.xpath(locator)).getText();
        return a;
    }
}
