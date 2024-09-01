package d29_checkbox_alerts;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandleDemo {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();

    //    Alert type is 'Alert'
    //    Normal alert
    driver.findElement(By.xpath("//button[@onClick='myFunctionAlert()']")).click();
    Thread.sleep(1000);
    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.accept();

    Thread.sleep(3000);

    //    Confirmation alert
    driver.findElement(By.xpath("//button[@onClick='myFunctionConfirm()']")).click();
    Thread.sleep(1000);
    Alert confirmAlert = driver.switchTo().alert();
    System.out.println(confirmAlert.getText());
    alert.dismiss(); // or use 'alert.accept();' to accept

    Thread.sleep(3000);

    //    Prompt alert
    driver.findElement(By.xpath("//button[@onClick='myFunctionPrompt()']")).click();
    Alert promptAlert = driver.switchTo().alert();
    System.out.println(promptAlert.getText());
    promptAlert.sendKeys("Zukkii");
    promptAlert.accept();
    Thread.sleep(1000);

    String result = driver.findElement(By.id("demo")).getText();
    if (result.equals("Hello Zukkii! How are you today?")) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    Thread.sleep(1000);

    /* Another way to handle alert - using explicit wait */
    // Setup explicit wait
    WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // Click for alert
    driver.findElement(By.xpath("//button[@onClick='myFunctionAlert()']")).click();
    // Wait for alert
    Alert waitAlert = exWait.until(ExpectedConditions.alertIsPresent());
    Thread.sleep(1000);

    System.out.println(waitAlert.getText());
    Thread.sleep(3000);

    driver.quit();
  }
}
