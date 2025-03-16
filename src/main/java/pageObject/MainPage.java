package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    public static WebDriver driver;

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By profileButton = By.xpath(".//a[@href='/account']/p[text()='Личный Кабинет']");
    private By bunTab = By.xpath("//span[text()='Булки']");
    private By sauceTab = By.xpath("//span[text()='Соусы']");
    private By fillingTab = By.xpath("//span[text()='Начинки']");
    public By bunImg = By.xpath(".//p[text()='Краторная булка N-200i']");
    public By sauceImg = By.xpath(".//p[text()='Соус Spicy-X']");
    public By fillingImg = By.xpath(".//p[text()='Мясо бессмертных моллюсков Protostomia']");
    public By titleMainPage = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    private By mainAnimation = By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']");


    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickToLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на кнопку Личный Кабинет")
    public void clickProfileButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();
    }

    @Step("Нажать на вкладку Булки")
    public void clickBunsTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunTab));
        driver.findElement(bunTab).click();
    }

    @Step("Нажать на вкладку Соусы")
    public void clickSaucesTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceTab));
        driver.findElement(sauceTab).click();
    }

    @Step("Нажать на вкладку Начинки")
    public void clickFillingTab() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingTab));
        driver.findElement(fillingTab).click();
    }

    @Step("Появлениие заголовка Соберите бургер")
    public boolean titleMainPageExist() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(titleMainPage));
        return driver.findElement(titleMainPage).isDisplayed();
    }

    /*@Step("Ожидание загрузки страницы полностью, анимация исчезнет")
    public void waitInvisibilityAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(mainAnimation));

    }*/
}