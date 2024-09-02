package d31_dropdown;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandleDemo {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();

    // 'Select' type for select element
    Select ddSelectCountry = new Select(driver.findElement(By.xpath("//select[@id='country']")));

    // select option in dropdown
    ddSelectCountry.selectByVisibleText("Canada");
    Thread.sleep(3000);
    ddSelectCountry.selectByValue("uk");
    Thread.sleep(3000);
    ddSelectCountry.selectByIndex(7);
    Thread.sleep(3000);

    List<WebElement> options = ddSelectCountry.getOptions();
    for (WebElement op : options) {
      System.out.println(op.getText());
    }

    driver.quit();
  }
}
