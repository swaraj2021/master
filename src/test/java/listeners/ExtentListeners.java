package listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentListeners {
	public static WebDriver driver;
	 public static ExtentReports extent;
		public static ExtentTest test;
		 public static Properties Repository = new Properties();
		 public File f;
		 public FileInputStream fis;
		 
		 public void loadProperties() throws Exception{
				
		              f = new File("D:/Nigeria/ConversionTest/src/test/java/Config/config.properties");
			          fis = new FileInputStream(f);
				      Repository.load(fis);	
						
			}
		static
		{
		
		extent= new ExtentReports("D:/Nigeria/ConversionTest/target/surefire-reports/ConversionTest_Report"+".html",true);
				
		}

		public void getResult(ITestResult result) throws IOException{
			  if(result.getStatus()== ITestResult.SUCCESS){
			   test.log(LogStatus.PASS, result.getName()+"test has passed.");
			  }else if(result.getStatus()== ITestResult.SKIP){
			   test.log(LogStatus.SKIP, result.getName()+"test has passed.");
			  }else if(result.getStatus()== ITestResult.FAILURE){
			   {
			      String screenShotPath = capture(driver, "screenShotName");
			      test.log(LogStatus.FAIL, result.getName()+"test has failed."+result.getThrowable());
			      test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
			      System.out.println("The error screenshot is:"+screenShotPath);
			             
			   }
			  } 
			   else if(result.getStatus()== ITestResult.SUCCESS){
			   test.log(LogStatus.INFO, result.getName()+"test has started.");
			  }
			 }
			  
			 @AfterMethod()
			 public void afterMethod(ITestResult result) throws IOException{
			  getResult(result);}
		
		@BeforeMethod()
		public void beforeMethod(Method result){
			test= extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName()+ "test has started");
		}
		
		@AfterClass(alwaysRun = true)
		public void endTest(){
			extent.endTest(test);
			extent.flush();
		}
		
		
		 public static String capture(WebDriver driver, String screenShotName) throws IOException
		 {
		  TakesScreenshot ts = (TakesScreenshot)driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		       String dest = "D:/Nigeria/ConversionTest/target/surefire-reports/"+screenShotName+System.currentTimeMillis()+".png";
               File destination = new File(dest);
		        FileUtils.copyFile(source, destination);        
		        System.out.println("The screenshot name for this issue is"+dest);            
		        return dest;
		     
		  
		 }
}
