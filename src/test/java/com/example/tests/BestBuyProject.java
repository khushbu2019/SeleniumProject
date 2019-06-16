package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BestBuyProject {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
      
    System.setProperty("webdriver.chrome.driver","c:\\QA\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver(); 
    baseUrl = "https://www.katalon.com/";
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
    
  }

  @Test
  public void testBestBuy2() throws Exception {
    driver.get("https://www.bestbuy.com/site/computers-pcs/laptop-computers/abcat0502000.c?id=abcat0502000");
    driver.findElement(By.id("gh-search-input")).click();
    driver.findElement(By.id("gh-search-input")).clear();
    driver.findElement(By.id("gh-search-input")).sendKeys("Dell laptop");
    driver.findElement(By.name("frmSearch")).submit();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(13)'])[1]/following::i[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(150)'])[1]/following::i[1]")).click();
    driver.findElement(By.id("min-price-input")).click();
    driver.findElement(By.id("min-price-input")).clear();
    driver.findElement(By.id("min-price-input")).sendKeys("200");
    driver.findElement(By.id("max-price-input")).click();
    driver.findElement(By.id("max-price-input")).clear();
    driver.findElement(By.id("max-price-input")).sendKeys("700");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::i[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(6)'])[1]/following::i[1]")).click();
    driver.findElement(By.linkText("Dell - Inspiron 2-in-1 13.3\" Touch-Screen Laptop - AMD Ryzen 5 - 8GB Memory - 256GB Solid State Drive - Era Gray")).click();
    driver.findElement(By.id("gsp-sku-5802822")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Store'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Continue shopping'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to Cart'])[1]/following::button[1]")).click();
    driver.findElement(By.linkText("Continue as Guest")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Text me updates about my Best Buy order.'])[1]/following::button[1]")).click();
  }

  @After
  public void tearDown() throws Exception {
   // driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
