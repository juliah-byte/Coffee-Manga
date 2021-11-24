package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsPage extends AbstractPage {
	
	WebDriver driver;

	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/transfer.jsp";
	}
	
	
	public void clickTransferFunds() {
		
		driver.findElement(By.id("MenuHyperLink3")).click();
	}
	

	public void fromCheckingtoSavings(String amount) {
		
		WebElement dropdown = driver.findElement(By.id("fromAccount"));
	    dropdown.findElement(By.xpath("//option[. = '800003 Checking']")).click();
	    driver.findElement(By.cssSelector("#fromAccount > option:nth-child(2)")).click();
	    driver.findElement(By.id("toAccount")).click();
	    driver.findElement(By.cssSelector("#toAccount > option:nth-child(1)")).click();
	    driver.findElement(By.id("transferAmount")).click();
	    driver.findElement(By.id("transferAmount")).sendKeys(amount);
	    driver.findElement(By.id("transfer")).click();
	}
	
	
	public void fromSavingstoChecking(String amount) {
		
		WebElement dropdown = driver.findElement(By.id("fromAccount"));
	    dropdown.findElement(By.xpath("//option[. = '800002 Savings']")).click();
	    driver.findElement(By.cssSelector("#fromAccount > option:nth-child(1)")).click();
	    driver.findElement(By.id("toAccount")).click();
	    driver.findElement(By.cssSelector("#toAccount > option:nth-child(2)")).click();
	    driver.findElement(By.id("transferAmount")).click();
	    driver.findElement(By.id("transferAmount")).sendKeys(amount);
	    driver.findElement(By.id("transfer")).click();
		
	}
}
