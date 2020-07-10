package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateWebsiteheading {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }

  
  @Test
  public void websiteHeading() {
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateWebsiteHeading' execution is started");
	  System.out.println("-----------------------------------------------");
	  String heading = driver.findElement(By.cssSelector(".entry-title")).getText();
	  System.out.println("Heading of the website is: "+ heading);
	  Assert.assertEquals(heading, "Welcome to Alchemy Jobs");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  

}
