package d29_checkbox_alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationHandleDemo {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    // will see a popup witt username and password required
    //    driver.get("https://the-internet.herokuapp.com/basic_auth");

    //    Include username and password in URI
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    Thread.sleep(5000);
    driver.quit();
  }
}
