package d24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    // child
    String login =
        driver
            .findElement(
                By.xpath(
                    "//div[@class='oxd-form-actions orangehrm-login-action']/button[@type='submit']"))
            .getText();

    System.out.println("Login text : " + login);

    // multiple attributes
    // can use '*' as a wildcard
    driver
        .findElement(
            By.xpath(
                "//*[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
        .click();
  }
}
