package d21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase01 {
  public static void main(String[] args) {

    //    1. Launch browser
    WebDriver driver = new ChromeDriver();

    //    2. Open URL on te browser (use 'https://demo.opencart.com/')
    driver.get("https://demo.opencart.com/");

    //    3. Validate title
    String actualTitle = driver.getTitle();
    if (actualTitle.equals("Your Store")) {
      System.out.println("Test Passed");
    } else {
      System.out.println("Test Failed");
    }
    //  4. Close/Quit browser
    driver.quit();
    //    driver.close();
  }
}
