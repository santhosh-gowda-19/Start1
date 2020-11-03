package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test implements framework_constants
{
	public WebDriver driver;
	@BeforeMethod
	public void openappln()
	{
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
	}
	@AfterMethod
	public void closeappln(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Generic_ScreenShot.getPhoto(driver);
		}
		
		driver.quit();
	}

}
