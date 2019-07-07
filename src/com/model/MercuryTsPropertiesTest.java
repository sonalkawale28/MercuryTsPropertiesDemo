package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTsPropertiesTest {
	
	public WebDriver driver;
	Properties prop=new Properties();    //for Parameter properties
	Properties prop1=new Properties();    //for config properties
	
  @Test(priority=1)
  public void loginwithValidds1() 
  {
	  System.out.println("loginwithValidds1 under @Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username1"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password1"));
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag1=true;
	  Assert.assertEquals(act_flag1, exp_flag1);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @Test(priority=2)
  public void loginwithValidds2() 
  {
	  System.out.println("loginwithValidds2 under @Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username2"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password2"));
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag2=true;
	  Assert.assertEquals(act_flag2, exp_flag2);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @Test(priority=3)
  public void loginwithValidds3() 
  {
	  System.out.println("loginwithValidds3 under @Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username3"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password3"));
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag3=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag3=true;
	  Assert.assertEquals(act_flag3, exp_flag3);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @Test(priority=4)
  public void loginwithInValidds4() 
  {
	  System.out.println("loginwithInValidds4 under @Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("invalidusernm"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("invalidpassword"));
	  driver.findElement(By.xpath("//input[@name='login']")).click();
//	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
//	  boolean exp_flag1=true;
//	  Assert.assertEquals(act_flag1, exp_flag1);
//	  driver.findElement(By.linkText("SIGN-ON")).click();
  }
  
  @BeforeMethod
  public void getAllcookies() 
  {
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
	  
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\JAVA.TestNG-workspace\\MercuryTsPropertiesDemo\\Screenshot"));
	  
  }

  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("maximizeBrowser under @BeforeClass");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteAllcookies() 
  {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("enterApplicationURL under   @BeforeTest");
	  driver.get(prop.getProperty("url"));
	  System.out.println("url has opened successfully");
  }

  @AfterTest
  public void dbconnectionclose()
  {
	  System.out.println("dbconnectionclose under @AfterTest");
  }

  @BeforeSuite
  public void openBrowser() throws IOException 
  {
	  System.out.println("openBrowser under @BeforeSuite");
	  FileInputStream fis=new FileInputStream("F:\\JAVA.TestNG-workspace\\MercuryTsPropertiesDemo\\Parameter.properties");
	  prop.load(fis);
	  
	  FileInputStream fis1=new FileInputStream("F:\\JAVA.TestNG-workspace\\MercuryTsPropertiesDemo\\config.properties");
	  prop1.load(fis1);
	  
	  System.out.println("Chrome exe path is:"+prop1.getProperty("chromeexepath"));
	  System.out.println("Browser name is:"+prop.getProperty("browser"));
	  System.out.println("url is:"+prop.getProperty("url"));
	/*  System.out.println("username is:"+prop.getProperty("username1"));
	  System.out.println("password is:"+prop.getProperty("password1"));
	*/  
	  if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", prop1.getProperty("chromeexepath"));
		  driver=new ChromeDriver();
	  }
	  else if(prop.getProperty("browser").equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", prop1.getProperty("ieexepath"));
		  driver=new InternetExplorerDriver();
	  }
	  else
	  {
		  System.setProperty("webdriver.gecko.driver", prop1.getProperty("firefoxexepath"));
		  driver=new FirefoxDriver();  
	  }
	  
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  driver.close();
	  System.out.println("Browser closed successfully");
  }

}
