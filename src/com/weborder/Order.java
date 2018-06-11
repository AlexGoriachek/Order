package com.weborder;

	import java.util.Random;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;


	public class Order {
		
		public static void main(String[] args) throws InterruptedException {
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(20);
			sb.append("John ");
			Random random = new Random();
			for (int i = 0; i < 6; i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			sb.append(" Smith");
			String output = sb.toString();
			
			Random r =new Random();
			
			System.setProperty("webdriver.chrome.driver", 
					"/Users/primaryuser/Documents/selenium dependencies/drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
			
			driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
			driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
			driver.findElement(By.name("ctl00$MainContent$login_button")).click();
			driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
			Actions action = new Actions(driver);
			WebElement btn = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
			action.doubleClick(btn).perform();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(r.nextInt(100)+1+"");

			driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(output);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
			
			
			int luck =r.nextInt(3);
			
			switch (luck) {
			case 0:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+(long) (Math.random() * 1000000000000000L)+"");
			break;
			case 1:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+(long) (Math.random() * 1000000000000000L)+"");

			
			break;
			case 2:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+(long) (Math.random() * 100000000000000L)+"");

			break;
				
			}
			int temp=r.nextInt(2); 
			String rm= temp==1 ? temp+""+r.nextInt(3) : temp+""+r.nextInt(10);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(rm+"/"+r.nextInt(82)+18);
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
			
			if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText().contains("New order has been successfully added")) {
			      System.out.println("Pass");
			    } else {
			      System.out.println("Fail");
			    }
				
		}

}
