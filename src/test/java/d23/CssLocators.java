package d23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {
  public static void main(String[] args) {

    /*
     *   tag is optional
     *   tag id                    tag#id
     *   tag class                 tag.classname
     *   tag attribute             tag[attribute="value"]
     *   tag class attribute       tag.classname[attribute="value"]
     */
    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    //    classname
    System.out.println(
        "Logo is displayed : "
            + driver.findElement(By.cssSelector(".orangehrm-login-logo")).isDisplayed());

    //    tag + attribute
    driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
    //    attribute
    driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");

    // Can use only part of the className from the whole className as '.orangehrm-login-button'
    // From -> 'class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"
    driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
  }
}
