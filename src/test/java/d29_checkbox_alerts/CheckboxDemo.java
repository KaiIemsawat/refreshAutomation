package d29_checkbox_alerts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {
  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();

    //    driver.findElement(By.xpath("//input[@value='sunday']")).click();

    List<WebElement> checkboxes =
        driver.findElements(
            By.xpath("//div[@class='form-check form-check-inline']/input[@type='checkbox']"));

    //    Check last 3 checkboxes
    for (int i = checkboxes.size() - 1; i >= checkboxes.size() - 3; i--) {
      checkboxes.get(i).click();
    }
    Thread.sleep(2000);
    //    Uncheck them
    for (int i = checkboxes.size() - 1; i >= checkboxes.size() - 3; i--) {
      checkboxes.get(i).click();
    }
    Thread.sleep(5000);

    //    Check all boxes
    for (WebElement cb : checkboxes) {
      cb.click();
    }

    Thread.sleep(10000);

    driver.quit();
  }
}
