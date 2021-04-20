import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    @Test
    public void canNotLoginInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("Marija", "pineapplerobot");
        String errorMessage = loginPage.getErrorMessageInvalidCred();
        assertEquals(errorMessage, "The username and/or password you specified are not correct.");
    }

    @Test
    public void canNotLoginEmptyUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "robot");
        String errorMessage = loginPage.getErrorMessageEmptyUser();
        assertEquals(errorMessage, "Required");
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("ModestyBlaise7", "pineapplerobot7");
        assertTrue(new ProblemsPage(driver).isLoaded());

    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        return new FirefoxDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
