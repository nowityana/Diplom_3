package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PasswordForgotPage {
    private static WebDriver driver;

    private By enterLink = By.xpath(".//a[text()='Войти']");

    public PasswordForgotPage(WebDriver driver) {
        PasswordForgotPage.driver = driver;
    }

    @Step("Нажать на ссылку Войти")
    public void clickEnterLink() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterLink));
        driver.findElement(enterLink).click();
    }
}