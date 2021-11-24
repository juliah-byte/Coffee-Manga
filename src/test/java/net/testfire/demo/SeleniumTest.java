package net.testfire.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import net.testfire.demo.pom.AccountPage;
import net.testfire.demo.pom.LoginPage;
import net.testfire.demo.pom.RecentTransactionsPage;
import net.testfire.demo.pom.TransferFundsPage;
import net.testfire.demo.pom.AccountSummaryPage;


public class SeleniumTest {
	
	WebDriver driver;
	static String url = "https://demo.testfire.net/";
	static long waitTime = 10;
	static String user = "jsmith";
	static String password = "Demo1234";
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		
	}
	
	@Test(priority = 0)
	public void navToLogin() {
		driver.get(url);
		assertEquals("Altoro Mutual", driver.getTitle());
		WebElement signInLink = driver.findElement(By.id("LoginLink"));
		signInLink.click();
	
	} // very tightly coupled TestNG - Selenium
	
	@Test(priority = 1)
	public void login() {
////		WebElement loginForm = driver.findElement(By.id("login"));
//		System.out.println(loginForm.getTagName());
//		
//		// type in the user/pass
//		driver.findElement(By.id("uid")).sendKeys(user);
//		driver.findElement(By.id("passw")).sendKeys(password);
//		driver.findElement(By.name("btnSubmit")).click();
//		
//		// should be on the Hello {User} page
//		WebElement signOutLink = driver.findElement(By.id("LoginLink"));
//		System.out.println(signOutLink.getText());
		
		
		//Self-documenting code : reads like a story, English sentences
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(user);
		loginPage.setPassword(password);
		loginPage.clickLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		
		
		// asserts belong here
		assertEquals("Sign Off", accountPage.getLogoutText());
	}
	
	@Test(priority = 2)
	public void accountSummary() {
		
		AccountSummaryPage vAccountSum = new AccountSummaryPage(driver);
		vAccountSum.clickAccountSummmary();
		vAccountSum.savingsSummary();
		
	}
	
	
	@Test(priority = 3)

	public void recentTransacations() {
		
		RecentTransactionsPage rTransactions = new RecentTransactionsPage(driver);
		rTransactions.clickRecentTransactionsPage();
	}
	
	
	@Test(priority = 4)
	
	public void transferFunds() {
		
		TransferFundsPage tFunds = new TransferFundsPage(driver);
		tFunds.clickTransferFunds();
		tFunds.fromCheckingtoSavings("315");
		tFunds.fromSavingstoChecking("101");
	}
	
	@AfterSuite
	public void teardown() {
		// clean up
		driver.quit();
	}
	
	

}
