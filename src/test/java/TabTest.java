import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.MainPage;

public class TabTest extends BaseUITest {

    @Test
    @DisplayName("Переключение на вкладку Соусы")
    @Description("Проверка перехода в раздел Соусы кликом по вкладке")
    public void  goToSauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        //mainPage.waitInvisibilityAnimation();
        mainPage.clickFillingTab();
        mainPage.clickSaucesTab();
        Assert.assertTrue(driver.findElement(mainPage.sauceImg).isDisplayed());
    }

    @Test
    @DisplayName("Переключение на вкладку Булки")
    @Description("Проверка перехода в раздел Булки кликом по вкладке")
    public void goToBunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        //mainPage.waitInvisibilityAnimation();
        mainPage.clickFillingTab();
        mainPage.clickBunsTab();
        Assert.assertTrue(driver.findElement(mainPage.bunImg).isDisplayed());
    }

    @Test
    @DisplayName("Переключение на вкладку Начинки")
    @Description("Проверка перехода в раздел Начинки кликом по вкладке")
    public void goToFillingTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        //mainPage.waitInvisibilityAnimation();
        mainPage.clickFillingTab();
        Assert.assertTrue(driver.findElement(mainPage.fillingImg).isDisplayed());
    }
}