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

    // start-with
    driver.findElement(By.xpath("//input[starts-with(@name, 'pa')]")).sendKeys("admin123");

    // child
    String login =
        driver
            .findElement(
                By.xpath(
                    "//div[@class='oxd-form-actions orangehrm-login-action']/button[@type='submit']"))
            .getText();

    System.out.println("Login text : " + login);

    // inner text
    String innerText = driver.findElement(By.xpath("//p[text()='OrangeHRM OS 5.7']")).getText();
    System.out.println("inner text : " + innerText);

    // contains text -- only needs part of the whole text
    // ** Can't use in case of another tag involves <p>1st part <span>mid part </span>last part</p>
    String containsText = driver.findElement(By.xpath("//*[contains(text(),', Inc')]")).getText();
    System.out.println("contains text : " + containsText);

    // contains attribute
    // multiple contains
    // '.' can be used as wild card for contains
    String multipleContain =
        driver
            .findElement(By.xpath("//p[contains(@class,'oxd-text') and contains(.,'Ad')]"))
            .getText();
    System.out.println("Multiple contains : " + multipleContain);

    // multiple attributes may use 'and' operator or split to multiple '[]'
    // can use '*' as a wildcard

    // 'and' operator
    //    driver
    //        .findElement(
    //            By.xpath(
    //                "//*[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--main
    // orangehrm-login-button']"))
    //        .click();

    // 'or' operator can be used as well

    // multiple '[]'
    driver
        .findElement(
            By.xpath(
                "//*[@type='submit'][@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
        .click();
  }
}
