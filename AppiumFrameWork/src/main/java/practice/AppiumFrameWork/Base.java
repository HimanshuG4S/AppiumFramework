package practice.AppiumFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer() {
	boolean flag = checkIfServerIsRunnning(4723);
	if(!flag) {
	 service = AppiumDriverLocalService.buildDefaultService();
	 service.start();
	}
	 return service;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(120000);
	}
	
	public static void stopEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("adb -e emu kill");
		Thread.sleep(10000);
	}
	
	public static AndroidDriver<AndroidElement> Capibilities(String appName) throws MalformedURLException, IOException, InterruptedException {
	
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\AppiumFrameWork\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		File f = new File("src");
		File fs = new File(f,(String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();

//		String device = (String) prop.get("Device");
		
		String device = System.getProperty("deviceName");
		
		if(!device.contains("Android"))
			startEmulator();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
	public static boolean checkIfServerIsRunnning(int port) {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    try {
	        serverSocket = new ServerSocket(port);
	        serverSocket.close();
	    } catch (IOException e) {
	        //If control comes here, then it means that the port is in use
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}
	

	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
}
