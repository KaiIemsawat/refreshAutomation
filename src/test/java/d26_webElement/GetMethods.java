package d26_webElement;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    //    Get title
    System.out.println(driver.getTitle());

    //    Get url of current page
    System.out.println(driver.getCurrentUrl());

    //    Get source of current page
    System.out.println(driver.getPageSource());

    /* HANDLE WINDOW */
    //      getWindowHandle() // return of a single browser window
    //      Window id may change when reopen window again
    String windowId = driver.getWindowHandle();
    System.out.println("Window ID : " + windowId);

    //      get WindowHandles()
    //      click to open new browser window
    driver.findElement(By.linkText("OrangeHRM, Inc")).click();

    //    get window ids from multiple tabs(windows)
    Set<String> windowsId = driver.getWindowHandles();
    for (String wid : windowsId) {
      System.out.println(wid);
    }

    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());

    //    driver.quit();
    driver.close();
  }
}
