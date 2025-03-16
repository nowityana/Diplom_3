import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.MainPage;
import pageObject.RegistrationPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RegistrationTest extends BaseUITest {

    @Test
    @DisplayName("Регистрация пользователя с валидным паролем")
    @Description("Проверка регистрации пользователя с  паролем от 6 символов")
    public void registrationTest() {

        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.openRegistrationPage();
        registerPage.setUserName("Yana");
        registerPage.setUserEmail("yana123yana@gmail.com");
        registerPage.setUserPassword(randomAlphanumeric(6, 20));
        registerPage.clickRegisterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Проверка регистрации пользователя с паролем менее 6 символов")
    public void registrationWrongPasswordTest() {
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.openRegistrationPage();
        registerPage.setUserName("yana");
        registerPage.setUserEmail("yana123yana@gmail.com");
        registerPage.setUserPassword(randomAlphanumeric(4, 5));
        registerPage.clickRegisterButton();
        Assert.assertTrue(driver.findElement(registerPage.errorTextForFalsePass).isDisplayed());
    }
}