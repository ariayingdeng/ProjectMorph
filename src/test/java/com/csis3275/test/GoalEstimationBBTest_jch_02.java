package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GoalEstimationBBTest_jch_02 {

	private static WebDriver driver;
	private static Map<String, Object> vars;
	static JavascriptExecutor js;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// set up chrome driver
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(1936, 1096));
	    driver.findElement(By.linkText("Goal-Estimation")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("JinC");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("jin");
	    driver.findElement(By.id("loginBtn")).click();
	    driver.findElement(By.linkText("Goal-Estimation")).click();
	    driver.findElement(By.id("workoutHours")).click();
	    driver.findElement(By.id("workoutHours")).sendKeys("5");
	    driver.findElement(By.id("averageCaloriesIntakePerDay")).click();
	    driver.findElement(By.id("averageCaloriesIntakePerDay")).sendKeys("2000");
	    driver.findElement(By.id("TargetWeightLost")).click();
	    driver.findElement(By.id("TargetWeightLost")).sendKeys("5");
	    driver.findElement(By.id("btn")).click();
	    assertEquals("Hi JinC, This Is Your Estimation Result\n"
	    		+ "Target Weight Lost : 5 Kg\n"
	    		+ "Calories Burned Per Week : 2383.5Kcal\n"
	    		+ "\n"
	    		+ "The Estimated Time To Achieve Your Goal Is : 20 Weeks.",driver.findElement(By.cssSelector(".alert")).getText());
	    driver.findElement(By.id("workoutHours")).click();
	    driver.findElement(By.id("workoutHours")).sendKeys("1");
	    driver.findElement(By.id("averageCaloriesIntakePerDay")).click();
	    driver.findElement(By.id("averageCaloriesIntakePerDay")).sendKeys("8000");
	    driver.findElement(By.id("TargetWeightLost")).click();
	    driver.findElement(By.id("TargetWeightLost")).sendKeys("10");
	    driver.findElement(By.id("btn")).click();
	    assertEquals("Hi JinC, This Is Your Estimation Result\n"
	    		+ "Target Weight Lost : 10 Kg\n"
	    		+ "Calories Burned Per Week : -40750.5Kcal\n"
	    		+ "\n"
	    		+ "Your intake calories is more than what you burned. Follow our provided work-out plans and meal plans to achieve your goal.",driver.findElement(By.cssSelector(".alert")).getText());
	    driver.findElement(By.cssSelector("#secondAside > a")).click();
	    
	    
	    
	}

}
