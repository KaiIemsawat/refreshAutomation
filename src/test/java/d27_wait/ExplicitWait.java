package d27_wait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // set up explicit

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    WebElement forgotPassword =
        myWait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")));
    forgotPassword.click();

    Thread.sleep(5000);

    driver.quit();
  }
}
