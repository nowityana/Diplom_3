import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PasswordForgotPage;
import pageObject.RegistrationPage;

public class LoginTest extends BaseUITest{
    private String email;
    private String password;

    public LoginTest() {
        this.password = "qwerty123";
        this.email = "yana123yana@gmail.com";
    }

    @Test
    @DisplayName("Вход с главной страницы")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной странице")
    public void successfulMainLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickToLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        Assert.assertTrue(driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверка входа через кнопку Личный кабинет на главной странице")
    public void profileLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        Assert.assertTrue(driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Проверка входа через кнопку Войти в форме регистрации")
    public void RegistrationLoginTest() {
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.openRegistrationPage();
        registerPage.clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Вход через Форму восстановления пароля")
    @Description("Проверка входа через кнопку Войти в форме восстановления пароля")
    public void PasswordForgotLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickForgotPasswordLink();
        PasswordForgotPage forgotPassPage = new PasswordForgotPage(driver);
        forgotPassPage.clickEnterLink();
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(driver.findElement(mainPage.titleMainPage).isDisplayed());
    }
}