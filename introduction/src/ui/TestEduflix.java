package ui;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReaderEduflix;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEduflix {
	
	WebDriver driver;
	WebDriverWait webdwait;
	String browserId;
	ConfigFileReaderEduflix configFileReader= new ConfigFileReaderEduflix();
	@BeforeTest
	public void Prerequisites() throws MalformedURLException {
		String browserId = configFileReader.getBrowserId();

		if (browserId.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);			
			driver.get(configFileReader.getApplicationUrl());
			driver.manage().window().maximize();
			
		}
		if (browserId.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(configFileReader.getApplicationUrl());
			driver.manage().window().maximize();
		}
		if (browserId.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(configFileReader.getApplicationUrl());
			driver.manage().window().maximize();
	
		}
		webdwait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**************************************	
	***************************************
	****Set of tests for Login page********
	***************************************
	**************************************/	
		
		
		/**************************************************************************
		  Test for starting logging page
		 * @throws InterruptedException 
		 **************************************************************************/
		@Test(priority=1, enabled=true)
		public void StartLoginTest() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			//Click on registration
			driver.findElement(By.xpath("//*[@id=\"auto-test-subscribeButtonTop\"]/span")).click();
			//Click on login with Facebook
			driver.findElement(By.xpath("//*[@id=\"auto-subscription-facebookLogin\"]/span")).click();
			//Switching windows
			String[] windowHandles = driver.getWindowHandles().toArray(new String[0]);
			 driver.switchTo().window(windowHandles[1]);
			 //clicking on the email input
			 driver.findElement(By.id("email")).click();
			 //sending email
		        driver.findElement(By.id("email")).sendKeys(configFileReader.getUserFB());
             //clicking on the password input
		        driver.findElement(By.xpath("//*[@id=\"pass\"]")).click();
		        //sending password
		        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(configFileReader.getPasswordFB());
		        //clicking login
		        driver.findElement(By.id("loginbutton")).click();
		        driver.switchTo().window(windowHandles[0]);
		}
		@Test(priority=2, enabled=true)
		public void SelectProfile() throws InterruptedException   {
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			Thread.sleep(5000);
			//select profile
		driver.findElement(By.xpath("/html/body/streann-root/div/streann-select-profile/section/div/div[1]/div/div/a/img")).click();
		//continue without a plan FlexFlix
		driver.findElement(By.xpath("/html/body/streann-root/div/streann-entry-account/streann-plan-detail-bethelmedia/div[3]/div[4]/button")).click();
}
		
		
		@Test(priority=3, enabled=true)
		public void MyAccount() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			
			//webdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("\"//*[@id=\\\"auto-login-avatar-face\\\"]/a \""))).click()
			//click on my settings
			// Thread.sleep(10000);
		webdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"auto-login-avatar-face\"]/a")));
		driver.findElement(By.xpath("//*[@id=\"auto-login-avatar-face\"]/a")).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")))
			//click on my account
			 Thread.sleep(10000);
			driver.findElement(By.cssSelector("#auto-login-myAcc")).click();
			//click on change user details
			 Thread.sleep(10000);
			driver.findElement(By.xpath("/html/body/streann-root/div/streann-entry-account/streann-account/streann-membership/div[1]/a")).click();
			
			//click on edit profile
		driver.findElement(By.cssSelector("body streann-root div streann-entry-account streann-change-email section button")).click();
		//click on phone
	    driver.findElement(By.cssSelector("body > streann-root:nth-child(15) > div:nth-child(1) > streann-entry-account:nth-child(4) > streann-change-email:nth-child(2) > section:nth-child(2) > form:nth-child(2) > streann-custom-input:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).click();
	    //clear the field
	    driver.findElement(By.cssSelector("body > streann-root:nth-child(15) > div:nth-child(1) > streann-entry-account:nth-child(4) > streann-change-email:nth-child(2) > section:nth-child(2) > form:nth-child(2) > streann-custom-input:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).clear();
		//send phone number
		driver.findElement(By.cssSelector("body > streann-root:nth-child(15) > div:nth-child(1) > streann-entry-account:nth-child(4) > streann-change-email:nth-child(2) > section:nth-child(2) > form:nth-child(2) > streann-custom-input:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys(configFileReader.getPhoneNumber());
		//check if the number is correct
		//Assert.assertTrue(driver.findElement(By.cssSelector("body > streann-root:nth-child(15) > div:nth-child(1) > streann-entry-account:nth-child(4) > streann-change-email:nth-child(2) > section:nth-child(2) > form:nth-child(2) > streann-custom-input:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).getText().contains(configFileReader.getPhoneNumber()));
		//click Change
		driver.findElement(By.cssSelector("#auto-changeUserDetails-btnChange")).click();
		//navigate to home page
		driver.findElement(By.cssSelector("#autotest-navbar-logo")).click();
		
		}
		
		@Test(priority=4, enabled=true)
		public void NewsLetter() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			//click on Subscribe
				driver.findElement(By.cssSelector(".btn.btn-round.w-100")).click();
				//check if Field is required
				Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div[4]/form")).getText().contains(configFileReader.getFieldRequiredText()));
				//send invalid email
				driver.findElement(By.cssSelector("input[placeholder='Enter Your Email']")).sendKeys(configFileReader.getBadFormatedMailText());
				//check the error for invalid email
				Assert.assertTrue(driver.findElement(By.cssSelector("div[class='invalid-feedback ng-star-inserted']")).getText().contains(configFileReader.getNotValidMailText()));
				//correct mail
				driver.findElement(By.cssSelector("input[placeholder='Enter Your Email']")).sendKeys(configFileReader.getIncorrectMailText());
				//error is gone
				Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div[4]/form")).getText().contains(configFileReader.getNotValidMailText()));
				//select the checkbox
				driver.findElement(By.cssSelector("#vehicle1")).click();
				//error is gone
				Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div[4]/form")).getText().contains(configFileReader.getNotValidMailText()));
				Thread.sleep(configFileReader.getSleepTime());
				//click on subscribe
				driver.findElement(By.cssSelector(".btn.btn-round.w-100")).click();
				//Text for joining the newsletter
			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-title")).getText().contains(configFileReader.getToastTitle()));
		}
		
		@Test(priority=5, enabled=true)
		public void PlayingVideo() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("img[alt='Los recursos que nos brinda el mar']")).click();
			
			
			
			
			
			
			
			
			
		}
				@AfterTest
				public void Finilize() throws InterruptedException {
					Thread.sleep(configFileReader.getSleepTime());
					driver.close();	
			
			
}
}	

