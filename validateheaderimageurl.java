package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class validateheaderimageurl {
 WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }
  
  @Test
  public void headerImageUrl() {
	  
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateHeaderImageUrl' Execution is started");
	  System.out.println("-----------------------------------------------");
	  WebElement image = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img"));
	  String url = image.getAttribute("src");
	  System.out.println("url of the header image is: "+ url);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
