package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private static WebDriver driver;

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private By emailField = By.xpath(".//input[@name='name']");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By recoveryPassLink = By.xpath(".//a[@href='/forgot-password']");
    public By entranceTitle = By.xpath(".//h2[text()='Вход']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoLink = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private By loginAnimation = By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']");

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }
    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Ввести почту")
    public void setUserEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void setUserPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на ссылку Восстановить пароль")
    public void clickForgotPasswordLink() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(recoveryPassLink));
        driver.findElement(recoveryPassLink).click();
    }

    @Step("Авторизация")
    public void authorization(String email, String password) {
        setUserEmail(email);
        setUserPassword(password);
        clickLoginButton();
    }
    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogoLink() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoLink));
        driver.findElement(logoLink).click();
    }
    @Step("Ожидание загрузки страницы полностью, анимация исчезнет.")
    public void waitInvisibilityAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(loginAnimation));
    }
}