package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateWebsitesecheading {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");  
  }
  
  @Test
  public void secondHeading() {
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateWebsiteSecondHeading' execution is started");
	  System.out.println("-----------------------------------------------");
	  String secHeader = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2")).getText();
	  System.out.println("Second header of the website is: "+ secHeader);
	  Assert.assertEquals(secHeader, "Quia quis non");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
