package practice.AppiumFrameWork;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import pageObjects.Cart;
import pageObjects.FormData;
import pageObjects.Products;
import pageObjects.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;





public class Ecommerce_TC_4 extends Base{

@BeforeTest
public void KillAllNodes() throws IOException, InterruptedException {
	Runtime.getRuntime().exec("taskKill /F /IM node.exe");
	Thread.sleep(3000);
}

@Test	
 public void totolValidation() throws MalformedURLException, IOException, InterruptedException {
	
//General.Store.apk
	service=startServer();
	
AndroidDriver<AndroidElement> driver=Capibilities("GeneralStoreApp");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     FormData f = new FormData(driver);

     f.namefield.sendKeys("Hello");

     driver.hideKeyboard();

     f.gender.click();

     f.genderClick.click();

     Utilities u = new Utilities(driver);
     u.scrolltoText("Argentina");
  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     f.country.click();

     f.btnLetsShop.click();

     Products p = new Products(driver);
     p.products.get(0).click();
     p.products.get(0).click();

     p.appbar_btn_cart.click();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    Cart c = new Cart(driver);
int count=c.productList.size();

double sum=0;

for(int i=0;i<count;i++)

{

String amount1= c.productList.get(i).getText();

double amount=getAmount(amount1);

sum=sum+amount;//280.97+116.97

}

System.out.println(sum+"sum of products");



String total=c.totalAmount.getText();



total= total.substring(1);

double totalValue=Double.parseDouble(total);

System.out.println(totalValue+"Total value of products");

Assert.assertEquals(sum, totalValue); 

service.stop();

}

@AfterTest
public void killEmulator() throws IOException, InterruptedException {

//	stopEmulator();
	
}

public static double getAmount(String value)

{

value= value.substring(1);

double amount2value=Double.parseDouble(value);

return amount2value;


}

}

