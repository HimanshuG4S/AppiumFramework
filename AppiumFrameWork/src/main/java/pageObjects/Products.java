package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products {
	
	public Products(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath ="//*[@text='ADD TO CART']")
	public List<WebElement> products;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement appbar_btn_cart;
}
