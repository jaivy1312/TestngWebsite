package POMproject.WebsiteTestingMay2023;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import POMproject.websiteTestComponents.BaseTest;

public class IndidualTest extends BaseTest{
	
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
}
