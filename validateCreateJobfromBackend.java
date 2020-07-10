package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateCreateJobfromBackend {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }
  
  @Test (priority = 0)
  public void Login() {
	
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateCreateJobFromBackend' Execution is started");
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
  
	@Test (priority = 1)
	public void backendCreateJob() {
		
	  String Position = "DineshTesting1";
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/ul/li[3]/a")).click();
	  String newTitle = driver.getTitle();
	  System.out.println("CreateJob page title is: "+newTitle);
	  Assert.assertEquals(newTitle, "Add Job ‹ Alchemy Jobs — WordPress");
	  driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys(Position);
	  driver.findElement(By.id("_application")).clear();
	  driver.findElement(By.id("_application")).sendKeys("dineshbit50@gmail.com");
	  driver.findElement(By.id("_company_website")).sendKeys("Demo.com");
	  driver.findElement(By.id("_company_twitter")).sendKeys("1234@DineshDemo");
	  driver.findElement(By.id("_job_location")).sendKeys("Bangalore");
	  driver.findElement(By.id("_company_name")).sendKeys("DineshDemo");
	  
	  WebElement Publish = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]"));
	  if (Publish.isEnabled()) {
		  Publish.click();  
	  }
	  else {
		  System.out.println("Publish Button is disabled");
		  driver.close();
	  }
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
	  String message = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[1]")).getText();
	  System.out.println(message);
	  Assert.assertEquals(message, Position+ " is now live.");	  
  }
	

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
