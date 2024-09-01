package d28_navigate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindowDemo {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    driver.manage().window().maximize();

    driver.findElement(By.linkText("OrangeHRM, Inc")).click();

    Set<String> wid = driver.getWindowHandles();

    List<String> widList = new ArrayList<>(wid);
    String originalTab = widList.get(0);
    String newTab = widList.get(1);

    driver.switchTo().window(newTab);
    System.out.println(driver.getTitle());

    driver.switchTo().window(originalTab);
    System.out.println(driver.getTitle());

    driver.quit();
  }
}
