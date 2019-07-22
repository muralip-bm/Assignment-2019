package daviesgroup.techchallenge.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import daviesgroup.techchallenge.base.Base;
import daviesgroup.techchallenge.pages.AddToCart;
import daviesgroup.techchallenge.pages.Login;

public class Tests extends Base {
	
	Login loginPage;
	AddToCart addToCartPage;
	SoftAssert softalert = new SoftAssert();
	
	public Tests() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new Login();
		
	}
	
	@Test(priority=1)
	public void accountCreationMandatoryFieldsValidationTest() {
	Assert.assertTrue( currenturl.contains(givenurl), "Correct URL not loaded");
	System.out.println("The given url is:" + givenurl + "  and the url loaded is: " +  currenturl);
	loginPage.accountCreationMandatoryFieldsValidation();
	softalert.assertAll();
	System.out.println("All the mandatory fields are validated");
    }
	
	@Test(priority=2)
	public void createAccountTest() throws InterruptedException {
		loginPage.createAccount();
	}
	
	@Test(dependsOnMethods="createAccountTest")
	public void accountCreationWithExistingMailIDValidationTest() {
		String errorMessage = loginPage.accountCreationWithExistingMailIDValidation(prop.getProperty("loginMailID"));
		Assert.assertEquals((errorMessage.contains("email address has already been registered")), true, "Existing email ID validation failed");
		System.out.println("Account creation with existing user email ID is not allowed");
		
	}
		
	@Test(dependsOnMethods="createAccountTest")
	public void loginAndAddToCartTest() throws InterruptedException{
		addToCartPage = loginPage.login();
		addToCartPage.addToCartAndVerifyAddedItem();	
		loginPage.signOut();

	}
	
	@AfterClass
	public void tearDown(){
		 driver.close();
		
		 
	}
}
