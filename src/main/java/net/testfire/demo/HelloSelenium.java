package net.testfire.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
	
	static String url = "https://demo.testfire.net/";
	static long waitTime = 20;
	static String user = "jsmith";
	static String password = "Demo1234";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// poll the page looking for an element (waith before throwing an error)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		
		// assert
		System.out.println(driver.getTitle());
		
		WebElement signInLink = driver.findElement(By.id("LoginLink"));
		signInLink.click();
		
		//find the login form
		//WebElement loginForm = driver.findElement(By.id("login"));
		//System.out.println(loginForm.getTagName());
	
		// find the login form
		WebElement loginForm = driver.findElement(By.id("login"));
		System.out.println(loginForm.getTagName());
		
		
		// type in the user/pass
		driver.findElement(By.id("uid")).sendKeys(user);
		driver.findElement(By.id("passw")).sendKeys(password);
		driver.findElement(By.name("btnSubmit")).click();
		
		
		
		//view account summary
		WebElement menuLink = driver.findElement(By.id("listAccounts"));
		System.out.println(menuLink.getTagName());
		menuLink.click();
		menuLink.findElement(By.xpath("//option[. = '800003 Checking']")).click();
		
		
		//account summary
		
		//System.out.println(menuLink.getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		
		// should be on the Hello {User} page
		WebElement signOutLink = driver.findElement(By.id("LoginLink"));
		System.out.println(signOutLink.getText());
		
		
		
		// clear
		driver.quit();
		
		
	}

}