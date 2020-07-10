package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateWebsiteTtile {
WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }
  
  @Test
  public void websiteTitle() {
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateWebsiteTitle' execution is started");
	  System.out.println("-----------------------------------------------");
	  String Title = driver.getTitle();
	  System.out.println("Title of the webseite is: "+ Title);
	  Assert.assertEquals(Title, "Alchemy Jobs – Job Board Application");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
