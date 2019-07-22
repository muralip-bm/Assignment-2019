package daviesgroup.techchallenge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import daviesgroup.techchallenge.base.Base;
import daviesgroup.techchallenge.base.Utility;


public class Login extends Base{
	
	public String login_MailID = null;
	public String login_Password = null;
	public String createMailID = null;
	public String firstName = null;
	public String lastName = null;	
	public String pwd =  null;
	public String day = null;
	public String month = null;
	public String monthInNumber = null;
	public String year = null;
	public String company = null;
	public String addressline1 = null;
	public String addressline2 = null;
	public String city = null;
	public String state =null;
	public String zipCode = null;
	public String homePhone = null;
	public String mobile = null;
	public String addressAlias = null;
	public String newMailID = null;
	public WebDriverWait wait = new WebDriverWait(driver, 20);
	public String dynamicMailID = null;
	public String pHeading = null;
	public String subHeading = null;
	SoftAssert softalert = new SoftAssert();
	
	public Login() {
	
	login_MailID = prop.getProperty("loginMailID");
	login_Password = prop.getProperty("loginPassword");	
	createMailID = prop.getProperty("createAccountMailID");
	firstName = prop.getProperty("firstname");
	lastName = prop.getProperty("lastname");	
	pwd =  prop.getProperty("passwd");
	day = prop.getProperty("day");
	month = prop.getProperty("month");
	monthInNumber = prop.getProperty("monthInNum");
	year = prop.getProperty("year");
	company = prop.getProperty("company");
	addressline1 = prop.getProperty("addressline1");
	addressline2 = prop.getProperty("addressline2");
	city = prop.getProperty("city");
	state = prop.getProperty("state");
	zipCode = prop.getProperty("zipcode");
	homePhone = prop.getProperty("homephone");
	mobile = prop.getProperty("mobile");
	addressAlias = prop.getProperty("addressalias");	
	newMailID = prop.getProperty("newMailID");
	dynamicMailID = Utility.newMailID(firstName);
}
	
	public static final By signInLink = By.xpath("//a[@class='login']");
	
	public static final By emailAddressLogin = By.id("email");
	public static final By passwordLogin = By.id("passwd");
	public static final By signIn_Button = By.id("SubmitLogin");
	public static final By home = By.xpath("//a[@class='home']");
	
	public static final By emailAddress_CreateAccount = By.id("email_create");
	public static final By createAccount_Button = By.name("SubmitCreate");
	
	public static final By Mr_RadioButton = By.id("id_gender1");
	public static final By Mrs_RadioButton = By.id("id_gender2");
	public static final By firstName_Input = By.id("customer_firstname");
	public static final By lastName_Input = By.id("customer_lastname");
	public static final By emailID_Input = By.id("email");
	public static final By passwordLogin1 = By.id("passwd");
	public static final By dateOfBirth_Day = By.id("days");
	public static final By dateOfBirth_Month = By.id("months");
	public static final By dateOfBirth_Year = By.id("years");
	public static final By company_Input = By.id("company");
	public static final By addressLine1_Input = By.id("address1");
	public static final By addressLine2_Input = By.id("address2");
	public static final By city_Input = By.id("city");
	public static final By state_Select = By.id("id_state");
	public static final By zipCode_Input = By.id("postcode");
	public static final By country_Select = By.id("id_country"); 
	public static final By homePhone_Input = By.id("phone");
	public static final By mobilePhone_Input = By.id("phone_mobile");
	public static final By aliasAddress_Input = By.id("alias");
	public static final By register_Button = By.id("submitAccount");
	public static final By createAccountError = By.xpath("//*[@id='create_account_error']/ol/li");
	public static final By alert_Registration = By.className("alert alert-danger");
	public static final By error_Heading = By.xpath("//*[@class='alert alert-danger']/p");
	public static final By sign_Out = By.className("logout");
	public static final By signInLink2 = By.xpath("//a[@class='login' and @title='Log in to your customer account']");
	public static final By alertWarning = By.xpath("//*[@class='alert alert-warning']");
	public static final By errorMessages = By.xpath("//*[@class='alert alert-danger']//ol/li");
	public static final By pageHeading = By.xpath("//h1[@class='page-heading']");
	public static final By pageSubHeading = By.xpath("//h3[@class='page-subheading']");
	public static final By custAccount = By.xpath("//*[@class='header_user_info']//a[@title='View my customer account']");
	
	
	public void accountCreationMandatoryFieldsValidation() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(signInLink));
		driver.findElement(signInLink).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		
		driver.findElement(emailAddress_CreateAccount).sendKeys(Utility.newMailID(firstName));
		System.out.println("Dynamic mail id used for validation:"+ driver.findElement(emailAddress_CreateAccount).getAttribute("value"));
		driver.findElement(createAccount_Button).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(firstName_Input));
		driver.findElement(emailID_Input).clear();
		
		Utility.selectByValue(country_Select,"");  
		
		driver.findElement(aliasAddress_Input).clear();
		
		driver.findElement(register_Button).click();
		
		WebElement errorBlock = driver.findElement(error_Heading);
		
		wait.until(ExpectedConditions.visibilityOf(errorBlock));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", errorBlock);
		String errorHeading = errorBlock.getText();
		List<WebElement> listOfMessages = driver.findElements(errorMessages);
		System.out.println(errorHeading + " and the errors are for following fields" );
		
		softalert.assertEquals(errorHeading, "There are 11 errors", "All mandatory fields validation at one time failed");
		softalert.assertEquals(listOfMessages.size()==11,11, "All mandatory fields validation at one time failed");

		for (WebElement we: listOfMessages ) {
			System.out.println(we.getText());
		}
		Utility.takeScreenShot("MandatoryFieldsValidation");
 }	

	
	public void createAccount() {
		
		wait.until(ExpectedConditions.elementToBeClickable(signInLink));	
		driver.findElement(signInLink).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		
		
		driver.findElement(emailAddress_CreateAccount).sendKeys(dynamicMailID);
		driver.findElement(createAccount_Button).click();
		wait.until(ExpectedConditions.elementToBeClickable(Mr_RadioButton));
		
		
		
		driver.findElement(Mr_RadioButton).click();
		//driver.findElement(Mrs_RadioButton).click();
		
		driver.findElement(firstName_Input).sendKeys(firstName);
		driver.findElement(lastName_Input).sendKeys(lastName);
		driver.findElement(passwordLogin1).sendKeys(pwd);
		System.out.println("Account creation with credentials:\n Mail ID: "+ dynamicMailID + "  Passwword: " +pwd);
		Utility.takeScreenShot("AccountCreation");
		Utility.selectByValue(dateOfBirth_Day, day);
		Utility.selectByValue(dateOfBirth_Month, monthInNumber);
		//Utility.selectByVisibleText(dateOfBirth_Month, month+" ");
		Utility.selectByValue(dateOfBirth_Year, year);
		
		driver.findElement(company_Input).sendKeys(company);
		
		driver.findElement(addressLine1_Input).sendKeys(addressline1);
		driver.findElement(addressLine2_Input).sendKeys(addressline2);
		driver.findElement(city_Input).sendKeys(city);
		Utility.selectByVisibleText(state_Select,state);
		driver.findElement(zipCode_Input).sendKeys(zipCode);
		
		driver.findElement(homePhone_Input).sendKeys(homePhone);
		driver.findElement(mobilePhone_Input).sendKeys(mobile);
		driver.findElement(register_Button).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(home)));
		Assert.assertTrue(driver.findElement(custAccount).isDisplayed());	
		System.out.println("New Account is successfully created");
		signOut();
		
 }
		
	public AddToCart login() {
		
		driver.navigate().to(prop.getProperty("url"));
		wait.until(ExpectedConditions.elementToBeClickable(signInLink));
		driver.findElement(signInLink).click();		
		driver.findElement(emailAddressLogin).sendKeys(dynamicMailID);
		driver.findElement(passwordLogin).sendKeys(pwd);
		Utility.takeScreenShot("Login");
		driver.findElement(signIn_Button).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(home)));
		Assert.assertTrue(driver.findElement(custAccount).isDisplayed());	
		Utility.takeScreenShot("Login");
		System.out.println("Successfully logged in to the system with credentials:\n Mail ID: " + dynamicMailID + "  Password: "+ pwd);	
		
		return new AddToCart();
	}
	
	public String accountCreationWithExistingMailIDValidation(String existingMailID) {
		
		
		driver.findElement(signInLink).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		driver.findElement(emailAddress_CreateAccount).sendKeys(dynamicMailID);
		driver.findElement(createAccount_Button).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountError));		
		Utility.takeScreenShot("ExistingID");	
		return driver.findElement(createAccountError).getText();
		
	}
	
	public void signOut() {
		driver.findElement(sign_Out).click();
		wait.until(ExpectedConditions.elementToBeClickable(signInLink));
						
		if(driver.findElement(signInLink2).isDisplayed()) {
			System.out.println("Successfully logged out of the system");
		} 
	}
}
