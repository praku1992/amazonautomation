package com.automation.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class baseclass {

	 
		//pre conditions
		
		Test_1 testObject = new Test_1();
		
		@BeforeSuite
		public void setup() {
			System.out.println("Setting the Driver");
			testObject.invoke("CHROME");
		}
		
		@BeforeTest
		public void launchbrowser()
		{
			System.out.println("launch chrome browser");
			testObject.open("https://www.amazon.in");
			
		}
		@Test 
		public void testCase()
		{
			System.out.println("Main Test");
			testObject.test("HeadPhone");
			
		}
		
		
		
		//Post condition
		
		@AfterClass
		public void Closebrowser()
		{
			System.out.println("close  browser");
			testObject.close();	
		}
		
		
		
		
		

	

}
