package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dependencies {
 
			

	public Dependencies(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="android:id/checkbox")
	private WebElement checkbox;
	

	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement checkbox1;

	@AndroidFindBy(className="android.widget.EditText")
	public WebElement checkbox2;

	@AndroidFindBy(className="android.widget.Button")
	public List <WebElement> list;
	
	
	public WebElement getCheckbox() {
		System.out.println("User on "+Dependencies.class.getName()+" page");
		System.out.println("Locator "+checkbox);
		return checkbox;
	}
}

    