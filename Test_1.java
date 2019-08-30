package com.automation.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_1 {
	
	WebDriver driver;
	
	public void invoke(String browserType)
	{
		if(browserType.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\automation\\drivers\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--disable-popup-blocking--");
			driver = new ChromeDriver(options);	
			
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\eclipse-workspace\\automation\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	}
	
	public void open(String URL)
	{
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void test(String search) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(search);;
		driver.findElement(By.xpath("//input [@type = 'submit']")).click();
		driver.findElement(By.cssSelector("span[data-a-badge-color='sx-orange']")).isDisplayed();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//List <WebElement> elements =driver.findElements(By.cssSelector("span[data-a-badge-color='sx-orange']"));
		
			driver.findElement(By.xpath("//span[text()='Best seller']/../../../../../../../../..//a//span[contains(@class,'a-text-normal')]")).click();
			//window handle
			String parent=driver.getWindowHandle();
			Set<String>s1=driver.getWindowHandles();
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext()){
			   String child_window=I1.next();
			 
			// Here we will compare if parent window is not equal to child window then we            will close
			 
			if(!parent.equals(child_window)){
			driver.switchTo().window(child_window);
			 
			System.out.println(driver.switchTo().window(child_window).getTitle());
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 JavascriptExecutor js =(JavascriptExecutor)driver;
			 WebElement ele = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
			 js.executeScript("arguments[0].click()",ele);
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}
	
	public void teardown()
	{
		driver.quit();
	}

	
	public void close() {
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
