package practice.AppiumFrameWork;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends Base{
	
	@Test
	public void ApiTest() throws MalformedURLException, IOException, InterruptedException
{
		
		service=startServer();
		
		AndroidDriver<AndroidElement> driver = Capibilities("ApiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h = new HomePage(driver);
        
		h.preferences.click();
		
		Preferences p = new Preferences(driver);
        
		p.dependencies.click();
		
		Dependencies d = new Dependencies(driver);
		
		d.getCheckbox().click();
		d.checkbox1.click();
        d.checkbox2.sendKeys("hello1");
        d.list.get(1).click();
        driver.closeApp();
        service.stop();
       
	}

}
