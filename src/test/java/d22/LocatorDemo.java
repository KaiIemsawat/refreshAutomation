package d22;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    driver.get("https://demo.opencart.com/");
    driver.manage().window().maximize();

    // - name locator
    // - locate and input string
    driver.findElement(By.name("search")).sendKeys("Mac");

    // - id locator
    boolean isLogoDisplayed = driver.findElement(By.id("logo")).isDisplayed();
    String result = isLogoDisplayed ? "Passed" : "Failed";
    System.out.println(result);

    // - linkText | partialLinkText
    //    driver.findElement(By.linkText("Tablets")).click();
    //    driver.findElement(By.partialLinkText("Tablet")).click();
    // Try not using partialLinkText this due to the possibility of conflict

    // - className
    //   might be multiple elements. Use 'findElements' instead of 'findElement'
    //   Then, it will return as List of WebElement
    List<WebElement> navbarLink = driver.findElements(By.className("nav-item"));
    System.out.println("Number of navbar links : " + navbarLink.size());
    for (WebElement element : navbarLink) {
      System.out.println(element.getText());
    }

    // - tagName -- also high possibility to have multiple elements
    List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
    System.out.println("Number of total links on page : " + listOfLinks.size());
  }
}
