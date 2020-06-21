package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormData {
	
	public FormData(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement namefield;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement gender;

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement genderClick;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement btnLetsShop;//*[@text='Argentina']

	
}
