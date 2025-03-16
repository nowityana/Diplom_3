import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

public class MoveTest extends BaseUITest {
    private String email;
    private String password;

    public MoveTest() {
        this.password = "qwerty123";
        this.email = "yana123yana@gmail.com";
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода при клике на кнопку Личный кабинет")
    public void moveLoginPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfilePage();
        boolean success = profilePage.waitInvisibilityAnimation();
        Assert.assertTrue(success);
    }

    @Test
    @DisplayName("Выход из профиля")
    @Description("Проверка выхода из профиля ")
    public void exitTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfilePage();
        profilePage.clickExitButton();
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        Assert.assertTrue(driver.findElement(loginPage.entranceTitle).isDisplayed());
    }

    @Test
    @DisplayName("Переход на главную через кнопку Конструктор")
    @Description("Проверка перехода при клике на кнопку Конструктор")
    public void MoveConstructorButtonTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickConstructorButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue(success);
    }

    @Test
    @DisplayName("Переход на главную через логотип")
    @Description("Проверка перехода при клике на логотип ")
    public void moveMainWithLogoTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickLogoLink();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue(success);
    }
}