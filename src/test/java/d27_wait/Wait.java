package d27_wait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit wait

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    driver.findElement(By.linkText("OrangeHRM, Inc")).click();

    Thread.sleep(5000); // Java method. Needs to throw exception

    driver.quit();
  }
}
