package daviesgroup.techchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import daviesgroup.techchallenge.base.Base;


public class AddToCart extends Base {
	
	public static final By menu_TShirts = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]");
	public static final By item_TShirt = By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[1]");
	public static final By item_Description = By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']");
	public static final By itemPrice = By.xpath("//*[@class='price']//*[@id='our_price_display']");
	
	public static final By iframe = By.className("fancybox-iframe");
	public static final By addToCart_Button = By.xpath("//form[@id='buy_block']//*[@id='add_to_cart']/button");
	public static final By success_Message = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");
	public static final By checkout_Button = By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']");
	public static final By cartItemPrice = By.xpath("//*[@class='cart_unit']//span[@class='price']");
	public WebDriverWait wait = new WebDriverWait(driver, 20);
	
	
public void addToCartAndVerifyAddedItem() throws InterruptedException {
		
		System.out.println("Adding an item to cart");
		
		driver.findElement(menu_TShirts).click();
		wait.until(ExpectedConditions.elementToBeClickable(item_TShirt));
		WebElement element=driver.findElement(item_TShirt);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		String itemSelected = driver.findElement(item_Description).getText();
		element.click();
		
		driver.switchTo().frame(driver.findElement(iframe));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart_Button));
		String itemSelectedPrice = driver.findElement(itemPrice).getText();
		driver.findElement(addToCart_Button).sendKeys(Keys.RETURN);
		
		
		String successMessage = driver.findElement(success_Message).getText();
		Assert.assertTrue(successMessage.contains("Product successfully added to your shopping cart"), "Item addition to cart failed"); 
		System.out.println("Product successfully added to the cart");
			
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.elementToBeClickable(checkout_Button));
		driver.findElement(checkout_Button).sendKeys(Keys.ENTER);
		
		WebElement wb = driver.findElement(By.xpath("//td[@class='cart_description']//p[1]"));
		String itemAdded =wb.getText();
		String itemAddedPrice = driver.findElement(cartItemPrice).getText();
		System.out.println("Prices of item: "+ itemAddedPrice + "  " + itemSelectedPrice);
		Assert.assertTrue(itemSelected.equals(itemAdded), "Description of item selected and item added in the cart not matching"); 
		Assert.assertTrue(itemSelectedPrice.equals(itemAddedPrice), "Price of item selected and item added in the cart not matching"); 
		System.out.println("The description and price of item selected and item added are matching. Item selected: " + itemSelected + "tem Price: " + itemSelectedPrice );
	
		driver.findElement(Login.home).click();
		
			
}

}
