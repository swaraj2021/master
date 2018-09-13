package sanityTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import listeners.ExtentListeners;

public class IphoneX_Mini extends ExtentListeners{
	
	@Test(priority=1)
	public void rt1y() throws Exception
	{
		driver = new FirefoxDriver();
		loadProperties();
		driver.get(Repository.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        
	    Select model_select = new Select(driver.findElement(By.xpath(".//*[@id='productForm']/div[1]/div[1]/div/button")));
		model_select.selectByVisibleText(Repository.getProperty("model"));
				
		Select deviceprice_select = new Select(driver.findElement(By.xpath(".//*[@id='productForm']/div[2]/div[1]/div/button")));
		deviceprice_select.selectByVisibleText("0 - 250 €");
		
 		String offerprice=driver.findElement(By.xpath(".//*[@id='offerBlock']/div/div[2]/div[1]/div[2]/div[2]/div[1]/div")).getAttribute("value");
	
		if(offerprice.contains(Repository.getProperty("rt1y0-250")))
		{
			System.out.println(offerprice);
			System.out.println("Offer price for one year iPhoneX with price 0-250 matched");
			System.out.println("rt1y TC passed");
		}
		else
		{
			System.out.println("Offer price for one year iPhoneX with price 0-250 does not matched");
			System.out.println("rt1y TC passed");
		}
	}

	@Test(priority=2, dependsOnMethods = { "rt1y" }, alwaysRun = true)
	public void rt1ywithtp() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='theftOption']")).click();
		
		String offerprice=driver.findElement(By.xpath(".//*[@id='offerBlock']/div/div[2]/div[1]/div[2]/div[2]/div[1]/div")).getAttribute("value");
		
		if(offerprice.contains(Repository.getProperty("rt1y0-250withtp")))
		{
			System.out.println(offerprice);
			System.out.println("Offer price for one year with tp iPhoneX with price 0-250 matched");
			System.out.println("rt1ywithtp TC passed");
		}
		else
		{
			System.out.println("Offer price for one year with tp iPhoneX with price 0-250 does not matched");
			System.out.println("rt1ywithtp TC passed");
		}
	}
	
	@Test(priority=3, dependsOnMethods = { "rt1ywithtp" }, alwaysRun = true)
	public void rt2y() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='theftOption']")).click();
		
		driver.findElement(By.xpath(".//*[@id='radioButtons']/div[2]")).click();
		
		String offerprice=driver.findElement(By.xpath(".//*[@id='offerBlock']/div/div[2]/div[1]/div[2]/div[2]/div[1]/div")).getAttribute("value");
		
		if(offerprice.contains(Repository.getProperty("rt2y0-250")))
		{
			System.out.println(offerprice);
			System.out.println("Offer price for two year iPhoneX with price 0-250 matched");
			System.out.println("rt2y TC passed");
		}
		else
		{
			System.out.println("Offer price for two year iPhoneX with price 0-250 does not matched");
			System.out.println("rt2y TC passed");
		}
	}
	
	
	@Test(priority=4, dependsOnMethods = { "rt2y" }, alwaysRun = true)
	public void rt2ywithtp() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='theftOption']")).click();
		
		String offerprice=driver.findElement(By.xpath(".//*[@id='offerBlock']/div/div[2]/div[1]/div[2]/div[2]/div[1]/div")).getAttribute("value");
		
		if(offerprice.contains(Repository.getProperty("rt2y0-250withtp")))
		{
			System.out.println(offerprice);
			System.out.println("Offer price for two year with tp iPhoneX with price 0-250 matched");
			System.out.println("rt2ywithtp TC passed");
		}
		else
		{
			System.out.println("Offer price for two year with tp iPhoneX with price 0-250 does not matched");
			System.out.println("rt2ywithtp TC passed");
		}
		
		driver.quit();
	}
}
