package d21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase01 {
  public static void main(String[] args) {

    //    Launch browser
    WebDriver driver = new ChromeDriver();

    //    Open URL on te browser (use 'https://demo.opencart.com/')
    driver.get("https://demo.opencart.com/");
  }
}
