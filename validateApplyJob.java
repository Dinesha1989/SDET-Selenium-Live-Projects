package SeleniumLiveProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class validateApplyJob {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }

  @Test
  public void applyJob() {
	  
	  String jobtitle = "DineshTesting";
	  System.out.println("-----------------------------------------------");
	  System.out.println("Test case - 'ValidateApplyJob' Execution is started");
	  System.out.println("-----------------------------------------------");
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	  driver.findElement(By.id("search_keywords")).sendKeys(jobtitle);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  String positiontitle = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")).getText();
	  System.out.println("name of the position is: "+ positiontitle);
	  Assert.assertEquals(positiontitle, jobtitle);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")).click();
	  driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
	  String result = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p")).getText();
	  System.out.println(result);
	  
  }
  
  
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
