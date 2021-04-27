package ireach.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IntelliswiftiReach {
	
	public static WebDriver driver;
	public static int i = 1;
	public static int j = 0;
	
	@Test
	public void alaunch() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/Intelliswift/Drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ireach.darwinbox.in/user/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("UserLogin_username")).sendKeys("hardik.bhatt@intelliswift.com");
		driver.findElement(By.id("UserLogin_password")).sendKeys("hkbhkb@11");
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"dasboard-bigheader\"]/header/div[4]/ul/li[1]/span/a"))));
		driver.findElement(By.xpath("//*[@id=\"dasboard-bigheader\"]/header/div[4]/ul/li[1]/span/a")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"clokInClockout\"]/div/div/div[2]/div[3]/button"))));
		//driver.findElement(By.xpath("//*[@id=\\\"clokInClockout\\\"]/div/div/div[2]/div[3]/button")).click();
		
		String clockTime = driver.findElement(By.xpath("//*[@id=\"dasboard-bigheader\"]/header/div[4]/ul/li[1]/div/span[2]")).getText();
		Date date = new Date();
		System.out.println("Date: "+java.time.LocalDate.now()+" Time : "+clockTime);
	}
	
}
