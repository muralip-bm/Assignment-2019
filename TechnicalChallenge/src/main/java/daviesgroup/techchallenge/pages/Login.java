package daviesgroup.techchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import daviesgroup.techchallenge.base.Base;
import daviesgroup.techchallenge.base.Utility;

public class Login extends Base{
	
	Utility utility = new Utility();
	
	Select sel = null;
	String login_MailID = prop.getProperty("loginMailID");
	String login_Password = prop.getProperty("loginPassword");
	
	String mail_ID = prop.getProperty("createAccountMailID");
	//String new_MailID = ((Utility) utility).newMailID();
	String first_Name = prop.getProperty("firstname");
	String last_Name = prop.getProperty("lastname");
	String pwd =  prop.getProperty("passwd");
	String day = prop.getProperty("day");
	String month = prop.getProperty("month");
	String year = prop.getProperty("year");
	String company = prop.getProperty("company");
	String addressline1 = prop.getProperty("addressline1");
	String addressline2 = prop.getProperty("addressline2");
	String city = prop.getProperty("city");
	String state = prop.getProperty("state");
	String zipCode = prop.getProperty("zipcode");
	String homePhone = prop.getProperty("homephone");
	String mobile = prop.getProperty("mobile");
	String addressAlias = prop.getProperty("addressalias");
			
	By signIn_Link = By.xpath("//a[@class='login']");
	
	By emailAddress_Input = By.id("email");
	By password_Input = By.id("passwd");
	By signIn_Button = By.id("SubmitLogin");
	
	By emailAddress_CreateAccount = By.id("email_create");
	By createAccount_Button = By.name("SubmitCreate");
	
	By Mr_RadioButton = By.id("id_gender1");
	By Mrs_RadioButton = By.id("id_gender2");
	By firstName_Input = By.id("customer_firstname");
	By lastName_Input = By.id("customer_lastname");
	By emailID_Input = By.id("email");
	By password_Input1 = By.id("passdriver");
	By dateOfBirth_Day = By.id("days");
	By dateOfBirth_Month = By.id("months");
	By dateOfBirth_Year = By.id("years");
	By company_Input = By.id("company");
	By addressLine1_Input = By.id("address1");
	By addressLine2_Input = By.id("address2");
	By city_Input = By.id("city");
	By state_Select = By.id("id_state");
	By zipCode_Input = By.id("postcode");
	By country_Select = By.id("id_country"); 
	By homePhone_Input = By.id("phone");
	By mobilePhone_Input = By.id("phone_mobile");
	By aliasAddress_Input = By.id("alias");
	By register_Button = By.id("submitAccount");
	By createAccountError = By.xpath("//*[@id='create_account_error']/ol/li");
	By alert_Registration = By.className("alert alert-danger");
	By error_Heading = By.xpath("//*[@class='alert alert-danger']/p");
	By sign_Out = By.className("logout");
	By createAccountForm = By.id("create-account_form");
	By alertWarning = By.className("alert alert-warning");
	
	
	public void accountCreationWithoutMandatoryData() {
		
		driver.findElement(signIn_Link).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		
		driver.findElement(emailAddress_CreateAccount).sendKeys(mail_ID);
		driver.findElement(createAccount_Button).click();
		
		driver.findElement(emailID_Input).clear();
		
		sel = new Select(driver.findElement(country_Select));
		sel.selectByValue("");  
		
		
		driver.findElement(register_Button).click();
		String errorHeading = driver.findElement(error_Heading).getText();
		System.out.println("The error heading is: " + errorHeading );
		if(errorHeading.contains("10")) {
			System.out.println("All the 10 mandatory fields are validated");
		} else {
			System.out.println("One or more mandatory fields not validated or filledin");
		}
		
		
 }	
public void createAccount() {
		
		//System.out.println(System.getProperty("user.dir"));
		
			
		driver.findElement(signIn_Link).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		
		driver.findElement(emailAddress_CreateAccount).sendKeys(mail_ID);
		driver.findElement(createAccount_Button).click();
		driver.findElement(Mr_RadioButton).click();
		//driver.findElement(Mrs_RadioButton).click();
		
		driver.findElement(firstName_Input).sendKeys(prop.getProperty("firstname"));
		driver.findElement(lastName_Input).sendKeys(prop.getProperty("lastname"));
		driver.findElement(password_Input1).sendKeys(prop.getProperty("passwd"));
		
		sel = new Select(driver.findElement(dateOfBirth_Day));
		sel.selectByValue(day);
		sel= new Select(driver.findElement(dateOfBirth_Month));
		sel.selectByVisibleText(month+" ");
		sel = new Select(driver.findElement(dateOfBirth_Year));
		sel.selectByValue(year);
		
		driver.findElement(company_Input).sendKeys(company);
		
		driver.findElement(addressLine1_Input).sendKeys(addressline1);
		driver.findElement(addressLine2_Input).sendKeys(addressline2);
		driver.findElement(city_Input).sendKeys(city);
		sel = new Select(driver.findElement(state_Select));
		sel.deselectByVisibleText(state);
		driver.findElement(zipCode_Input).sendKeys(zipCode);
		
		driver.findElement(homePhone_Input).sendKeys(homePhone);
		driver.findElement(mobilePhone_Input).sendKeys(mobile);
		driver.findElement(aliasAddress_Input).sendKeys(addressAlias);
		
		driver.findElement(register_Button).click();
 }
	
	
	public void createAccount12() {
		
		//System.out.println(System.getProperty("user.dir"));
		
			
		driver.findElement(signIn_Link).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		
		driver.findElement(emailAddress_CreateAccount).sendKeys(mail_ID);
		driver.findElement(createAccount_Button).click();
		driver.findElement(Mr_RadioButton).click();
		//driver.findElement(Mrs_RadioButton).click();
		
		driver.findElement(firstName_Input).sendKeys(first_Name);
		driver.findElement(lastName_Input).sendKeys(last_Name);
		driver.findElement(password_Input1).sendKeys(pwd);
		
		sel = new Select(driver.findElement(dateOfBirth_Day));
		sel.selectByValue(day);
		sel= new Select(driver.findElement(dateOfBirth_Month));
		sel.selectByVisibleText(month+" ");
		sel = new Select(driver.findElement(dateOfBirth_Year));
		sel.selectByValue(year);
		
		driver.findElement(company_Input).sendKeys(company);
		
		driver.findElement(addressLine1_Input).sendKeys(addressline1);
		driver.findElement(addressLine2_Input).sendKeys(addressline2);
		driver.findElement(city_Input).sendKeys(city);
		sel = new Select(driver.findElement(state_Select));
		sel.deselectByVisibleText(state);
		driver.findElement(zipCode_Input).sendKeys(zipCode);
		
		driver.findElement(homePhone_Input).sendKeys(homePhone);
		driver.findElement(mobilePhone_Input).sendKeys(mobile);
		driver.findElement(aliasAddress_Input).sendKeys(addressAlias);
		
		driver.findElement(register_Button).click();
 }
	
	public void login() {
		driver.findElement(signIn_Link).click();		
		driver.findElement(emailAddress_Input).sendKeys(login_MailID);
		driver.findElement(password_Input).sendKeys(login_Password);
		driver.findElement(signIn_Button).click();
		System.out.println("Successfully logged in to the system with mail ID " + login_MailID);		
	}
	

	public String accountCreationWithExistingMailID(String existingMailID) {
		
		driver.findElement(signIn_Link).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress_CreateAccount));
		driver.findElement(emailAddress_CreateAccount).sendKeys(login_MailID);
		driver.findElement(createAccount_Button).click();
		return driver.findElement(createAccountError).getText();
		
		
	}
	
	public void signOut() {
		driver.findElement(sign_Out).click();
		
				
		if(driver.findElement(createAccountForm).isDisplayed()) {
			System.out.println("Successfully logged out from the system");
		} else if (driver.findElement(alertWarning).isDisplayed()){
			System.out.println("Successfully logged out from the system");
		}
		
		
	}
}
