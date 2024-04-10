package POMproject.WebsiteTestingMay2023;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POMproject.websiteTestComponents.BaseTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ErrorValidationTest extends BaseTest {
	
	
	
	@Test(dataProvider="getdataerror")
	public void validateerrorcode(String email,String password) throws InterruptedException
	{
		ProductPage productpage=landpage.Login(email, password);
		Thread.sleep(1000);
		String errorreply=landpage.errormessege();
		Assert.assertEquals(errorreply, "Incorrect email or password.");
		
		
	}
	
	@Test
	public void producterrorvalidation() throws InterruptedException
	{	String productname="ZARA COAT 3";
		ProductPage productpage=landpage.Login("jaibirsingh1312@gmail.com", "123456");
		List<WebElement> products=productpage.getProductList();
		productpage.clickOnProduct(productname);
		CartPage cartpage=productpage.clickOnCart();
		Boolean Match=cartpage.getItemText("ZARA COAT 33");
		Assert.assertFalse(Match);

	}
	@DataProvider
	public Object[][] getdataerror()
	{
		return new Object[][] {{"jaibiirsingh1312@gmail.com","123456"},{"ajibirsingh1255@gmail.com","12345"}};
	}

	
	
}
