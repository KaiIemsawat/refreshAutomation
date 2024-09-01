package d25_xpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class d25xpath_axes {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();

    // using '/ancestor::' to nodes above. Should also follow by some specific details
    // using '//' to go down to several node below
    String ancestorAndDescendant =
        driver
            .findElement(
                By.xpath("//input[@name='username']/ancestor::div[@class='oxd-form-row']//label"))
            .getText();
    System.out.println("To ancestor and back to descendant : " + ancestorAndDescendant);

    // use '/parent::' to go to the node a step above
    // '/tag[n]' can be used to go down to one of many children by nth number of children
    String parentChild =
        driver
            .findElement(By.xpath("//input[@type='password']/parent::div/parent::div/div[1]/label"))
            .getText();
    System.out.println("Parent and child : " + parentChild);

    driver.quit();
  }
}
