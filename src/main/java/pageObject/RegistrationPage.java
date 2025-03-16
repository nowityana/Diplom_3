package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {

    private static WebDriver driver;

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By enterButton = By.xpath(".//a[text()='Войти']");
    public By errorTextForFalsePass = By.xpath(".//p[text()='Некорректный пароль']");
    private By registerAnimation = By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']");

    public RegistrationPage(WebDriver driver) {
        RegistrationPage.driver = driver;
    }

    public void openRegistrationPage() {
        driver.get(REGISTER_PAGE_URL);
    }

    @Step("Ввести имя" )
    public void setUserName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести почту")
    public void setUserEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void setUserPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на кнопку Войти")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(enterButton).click();
    }

    /*@Step("Ожидание загрузки страницы полностью, анимация исчезнет.")
    public void waitInvisibilityAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(registerAnimation));
    }*/
}
