package d30_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();

    driver.get("https://ui.vision/demo/webtest/frames/");
    driver.manage().window().maximize();

    /* Handle frame */
    // Need to go to the frame
    // - get frame element
    WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));

    // - switch to the frame
    // -- frame(name)
    // -- frame(id)
    // -- frame(webElement)
    // -- frame(index)
    driver.switchTo().frame(frame1);

    // - once switch to the frame, we may manipulate
    driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test sending to frame");

    // ** Once finish using the frame, should always go back to default content
    // ** So that we may go to another frame
    driver.switchTo().defaultContent();

    // - get another frame element
    WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
    // switch to another frame
    driver.switchTo().frame(frame2);
    driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test frame 2 input");
    driver.switchTo().defaultContent();

    // Switch to Frame that contains more frames
    WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
    driver.switchTo().frame(frame3);
    driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Test frame 3 input");

    // Not go back to default due to the next tasks

    // inner frame iframe (Part of frame3)
    driver.switchTo().frame(0);
    System.out.println(driver.findElement(By.xpath("//label[@for='i8']//span")).getText());

    driver.switchTo().defaultContent();

    Thread.sleep(5000);
    driver.quit();
  }
}
