package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CheckInSystemBlackBoxTest_tch_06 {

	private static WebDriver driver;
	private static Map<String, Object> vars;
	static JavascriptExecutor js;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);		
		driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(1722, 976));
	    driver.findElement(By.linkText("Check-In")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("James");
	    driver.findElement(By.id("password")).sendKeys("james");
	    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("JamesC");
	    driver.findElement(By.id("password")).sendKeys("james");
	    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
	    driver.findElement(By.linkText("Check-In")).click();
	    driver.findElement(By.id("calendarButton")).click();
	    driver.findElement(By.cssSelector(".inputButtonClass:nth-child(1) .inputButton")).click();
	    
	    assertEquals("rgba(255, 165, 0, 1)",
				driver.findElement(By.id("calendarButtonHalf")).getCssValue("background-color"));
	    
	    driver.findElement(By.id("calendarButtonHalf")).click();
	    driver.findElement(By.cssSelector(".inputButton")).click();
	    assertEquals("rgba(0, 128, 0, 1)",
				driver.findElement(By.id("calendarButtonComplete")).getCssValue("background-color"));
	    
	    driver.findElement(By.id("calendarButtonComplete")).click();
	    
	    assertEquals("rgba(255, 165, 0, 1)",
				driver.findElement(By.cssSelector(".unCheckButton")).getCssValue("background-color"));
	    driver.findElement(By.cssSelector(".inputButtonClass:nth-child(2) .unCheckButton")).click();
	    driver.findElement(By.cssSelector("form:nth-child(3) > input")).click();
	    driver.findElement(By.cssSelector("#calendarTop > form:nth-child(1) > input")).click();
	    driver.findElement(By.cssSelector("#calendarTop > form:nth-child(1) > input")).click();

	    driver.findElement(By.cssSelector("form:nth-child(3) > input")).click();
	    driver.findElement(By.cssSelector("#secondAside > a")).click();


	}
	
	

}
