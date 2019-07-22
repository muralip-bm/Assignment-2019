package daviesgroup.techchallenge.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import daviesgroup.techchallenge.base.Base;
import daviesgroup.techchallenge.pages.AddToCart;
import daviesgroup.techchallenge.pages.Login;

public class Tests extends Base {
	
	Login loginPage;
	AddToCart addToCartPage;
	
	public Tests() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new Login();
	}
	
	@Test(priority=1)
	public void createAccountTest() {
		loginPage.createAccount();
	}
		

	/*
	@Test(priority=2)
	public void LoginTest() throws InterruptedException{
		loginPage.login();
		//Assert.assertEquals(actError,"Please try again.","Error message not displayed");
		addToCartPage = new AddToCart();
		
	}
	
	@Test(priority=3 )
	public void AddToCartAndVerifyItemTest() throws InterruptedException{
		addToCartPage.addToCartAndVerifyAddedItem();				
	}	
		
	@Test
	public void createAccountWithExistingMailIDTest() {
		String errorMessage = loginPage.accountCreationWithExistingMailID(prop.getProperty("loginMailID"));
		if (errorMessage.contains("email address has already been registered")) {
			
			System.out.println("Account creation with existing user Mail ID is not allowed");
		}
		
	}
	
	@Test(priority=5)
	
	public void accountCreationWithoutMandatoryDataTest() {
		loginPage.accountCreationWithoutMandatoryData();
	}
	
	
	@Test(priority=6)	
	public void SignOutTest(){
		 loginPage.signOut();
	}*/
}
