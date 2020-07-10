package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateCreateJob {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }
  

  @Test
  public void createJob() {
	  String position = "DineshDemoTesting1";
	  String email = "dinesh1246@gmail.com";
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateCreateJob' Execution is started");
	  System.out.println("-----------------------------------------------");
	  Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).isDisplayed());
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
	  driver.findElement(By.id("create_account_email")).sendKeys(email);
	  driver.findElement(By.id("job_title")).sendKeys(position);
	  driver.findElement(By.id("job_location")).sendKeys("Bangalore");
	  driver.findElement(By.id("job_description_ifr")).sendKeys("opening for testing");
	  driver.findElement(By.id("application")).sendKeys("demo@gmail.com");
	  driver.findElement(By.id("company_name")).sendKeys("DEMO");
	  driver.findElement(By.id("company_website")).sendKeys("http://demo.com");
	  driver.findElement(By.name("submit_job")).click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  String postionres = driver.findElement(By.cssSelector(".job_listing_preview > h1:nth-child(1)")).getText();
	  System.out.println(postionres);
	  Assert.assertEquals(postionres, position);
	  System.out.println("Job posted successfully");
	  driver.findElement(By.id("job_preview_submit_button")).click();
	  String resulttext = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div")).getText();
	  System.out.println(resulttext);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	  //driver.findElement(By.id("search_keywords")).sendKeys(position);
	  //driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
	  //String jobexist = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")).getText();
	  //Assert.assertEquals(jobexist, position);
	  
  }
	  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
