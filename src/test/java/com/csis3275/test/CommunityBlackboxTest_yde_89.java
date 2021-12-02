package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

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

class CommunityBlackboxTest_yde_89 {
	
	  private static WebDriver driver;
	  private static Map<String, Object> vars;
	  static JavascriptExecutor js;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
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
	    driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(1296, 696));
	    driver.findElement(By.linkText("Community")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("YingD");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("yingdeng");
	    driver.findElement(By.id("loginBtn")).click();
	    driver.findElement(By.linkText("Community")).click();
	    driver.findElement(By.id("content")).click();
	    driver.findElement(By.id("content")).sendKeys("New post test");
	    driver.findElement(By.id("postBtn")).click();
	    assertEquals("YingD", driver.findElement(By.cssSelector(".poster")).getText());
	    assertEquals("New post test", driver.findElement(By.cssSelector(".postcontent")).getText());
	    driver.findElement(By.id("likeimg")).click();
	    assertEquals("1", driver.findElement(By.cssSelector(".likesNum")).getText());
	    driver.findElement(By.linkText("Delete")).click();
	    driver.findElement(By.cssSelector("#secondAside > a")).click();

	}

}
