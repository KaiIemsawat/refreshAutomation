package d27_wait;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluWaitDemo {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    //    Set up Fluent wait
    Wait<WebDriver> myWait =
        new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    //    Using syntax
    WebElement usernameInput =
        myWait.until(
            new Function<WebDriver, WebElement>() {
              public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
              }
            });
    usernameInput.sendKeys("Admin");

    WebElement passwordInput =
        myWait.until(
            new Function<WebDriver, WebElement>() {
              public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Password']"));
              }
            });
    passwordInput.sendKeys("admin123");

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    Thread.sleep(5000);

    driver.quit();
  }
}
