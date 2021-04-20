import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://leetcode.com/accounts/login/");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_login"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("id_login")).clear();
        driver.findElement(By.id("id_login")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("id_password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.className("btn-content__10Tj")).click();
        Thread.sleep(5000);

    }

    public String getErrorMessageEmptyUser() {
        WebElement errorPage = driver.findElement(By.className("error-message__3Q-C"));
        return errorPage.getText();
    }

    public String getErrorMessageInvalidCred() {
        WebElement errorPage = driver.findElement(By.className("error-message__27FL"));
        return errorPage.getText();
    }
}
