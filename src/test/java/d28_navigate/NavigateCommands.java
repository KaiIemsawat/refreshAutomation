package d28_navigate;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommands {
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    WebDriver driver = new ChromeDriver();

    //    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    // - Same thing as
    //
    // driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    // - However, driver.navigate().to() can accept URL type
    URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.navigate().to(url);

    driver.manage().window().maximize();

    driver
        .findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"))
        .click();

    Thread.sleep(5000);

    driver.navigate().back();

    Thread.sleep(5000);

    driver.navigate().forward();

    driver.quit();
  }
}
