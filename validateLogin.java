package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateLogin {
  WebDriver driver;
  
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }
  

  @Test
  public void backendLogin() {
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateLogin' Execution is started");
	  System.out.println("-----------------------------------------------");
	  WebElement username = driver.findElement(By.id("user_login"));
	  WebElement password = driver.findElement(By.id("user_pass"));
	  
	  username.sendKeys("root");
	  password.sendKeys("pa$$w0rd");
	  
	  driver.findElement(By.id("wp-submit")).click();
	  String Title = driver.getTitle();
	  System.out.println("Title of the login page is: "+Title);
	  Assert.assertEquals(Title, "Dashboard ‹ Alchemy Jobs — WordPress");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
