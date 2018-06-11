package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderPractice{
public static void main(String[] args) throws InterruptedException {
	Random random = new Random();

	//1 open chrome
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\annya\\OneDrive\\Documents\\Selenium dependencies\\drivers\\chromedriver.exe");
	//2 tells compliler where to find the chrome driver
	WebDriver driver = new ChromeDriver();
	//3 go to page
	Thread.sleep(100);
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	Thread.sleep(100);
	driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	// chrome driver has 
	Thread.sleep(100);
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	 // finding the loging botton
	Thread.sleep(100);
	driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	// 
	driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
	
	
	Actions action = new Actions(driver);
	WebElement btn = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
	action.doubleClick(btn).perform();
	int j = random.nextInt(100)+1;
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(j+"");
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
	
	String zipCode = random.nextInt(90000)+10000+"";
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);
	
	char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	
    StringBuilder sb = new StringBuilder(20);
    sb.append("John ");
  
    for (int i = 0; i < 6; i++) {
        char c = chars[random.nextInt(chars.length)];
        sb.append(c);
    }
    sb.append(" Smith");
    String output = sb.toString();
    driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(sb);

    Thread.sleep(5000);
    driver.close();
    int luck=random.nextInt(3);
	if (luck==0 ) {
		
		int temp=random.nextInt(2);
        String randomMonth= temp==1 ? temp+""+random.nextInt(3): temp+""+random.nextInt(10);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(randomMonth+"/"+randomNumber.nextInt(82)+18);
       Thread.sleep(2000);
       driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
       
       
       String expected = "New order has been successfully added.";
       String actual = driver.findElement(By.xpath("[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
    
       
       if ( actual.contains(expected)) {
           System.out.println("pass");
           
       }else {
           System.out.println("fail");
           System.out.println("Expected:\t" + expected);
           System.out.println("Actual:\t" + actual);
       }
        }
	}
}
}
