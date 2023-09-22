package net.testfire.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
	
	//static String url = "https://demo.testfire.net/";
	static String url = "https://coffeemanga.io/";
	
	static long waitTime = 20;
	static String user = "jsmith";
	static String password = "Demo1234";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(url);
		
		// poll the page looking for an element (waith before throwing an error)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		// assert
		System.out.println(driver.getTitle());
		
		WebElement signInLink = driver.findElement(By.className("open-search-main-menu"));
		signInLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		
		//WebElement searchBar = driver.findElement(By.className("manga-search-field ui-autocomplete-input"));
		WebElement searchBar = driver.findElement(By.cssSelector("input[type='text']"));
		//WebElement submit = driver.findElement(By.tagName("input"));
		//searchBar.click();
		searchBar.sendKeys("Betrayal of Dignity");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		
		WebElement Elements = driver.findElement(By.className("post-title"));
		js.executeScript("arguments[0].scrollIntoView();", Elements);
		
		//find the login form
		//WebElement loginForm = driver.findElement(By.id("login"));
		//System.out.println(loginForm.getTagName());
	
		// find the login form
		//WebElement loginForm = driver.findElement(By.id("login"));
		//System.out.println(loginForm.getTagName());
		
		
		// type in the user/pass
		//driver.findElement(By.id("uid")).sendKeys(user);
		//driver.findElement(By.id("passw")).sendKeys(password);
		//driver.findElement(By.name("btnSubmit")).click();
		
		
		
		//view account summary
		//WebElement menuLink = driver.findElement(By.id("listAccounts"));
		//System.out.println(menuLink.getTagName());
		//menuLink.click();
		//menuLink.findElement(By.xpath("//option[. = '800003 Checking']")).click();
		
		
		//account summary
		
		//System.out.println(menuLink.getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		
		// should be on the Hello {User} page
		//WebElement signOutLink = driver.findElement(By.id("LoginLink"));
		//System.out.println(signOutLink.getText());
		
		
		
		// clear
		driver.quit();
		
		
	}

}
