package d31_dropdown;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdownDemo {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    //    input credential
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    //    login
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    //    Click on PIM
    driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();

    //    Click on select dropdown menu
    driver
        .findElement(
            By.xpath(
                "//label[contains(text(), 'Job Title')]/parent::div/parent::div//div[@class='oxd-select-text-input']"))
        .click();

    //    Select an element under hidden dropdown -- QA Lead
    driver.findElement(By.xpath("//span[normalize-space()='QA Lead']")).click();

    Thread.sleep(4000);

    driver.quit();
  }
}
