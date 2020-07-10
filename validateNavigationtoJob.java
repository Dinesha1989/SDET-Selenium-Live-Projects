package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateNavigationtoJob {
 WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }
  
  @Test
  public void navigationtoJob() {
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateNavigationtoJob' Execution is started");
	  System.out.println("-----------------------------------------------");
	  WebElement job = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a"));
	  if (job.isDisplayed()) {
		 job.click();
	  }
	  String Title = driver.getTitle();
	  System.out.println("Title of the new page is: "+ Title);
	  Assert.assertEquals(Title, "Jobs – Alchemy Jobs");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
