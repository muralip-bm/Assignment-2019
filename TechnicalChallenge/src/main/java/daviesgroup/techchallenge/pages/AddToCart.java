package daviesgroup.techchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import daviesgroup.techchallenge.base.Base;

public class AddToCart extends Base {
	
	By menu_TShirts = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]");
	By item_TShirt = By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[1]");
	By item_Description = By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']");
	By iframe = By.className("fancybox-iframe");
	By addToCart_Button = By.xpath("//form[@id='buy_block']//*[@id='add_to_cart']/button");
	By success_Message = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");
	By checkout_Button = By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']");
	
public void addToCartAndVerifyAddedItem() throws InterruptedException {
		
		System.out.println("Adding an item to cart");
		
		driver.findElement(menu_TShirts).click();
		WebElement element=driver.findElement(item_TShirt);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		String itemselected = driver.findElement(item_Description).getText();
		element.click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(iframe));
		driver.findElement(addToCart_Button).click();
		//WebElement button = 
		//button.click();
		
		String successMessage = driver.findElement(success_Message).getText();
		if(successMessage.equalsIgnoreCase("Product successfully added to your shopping cart"))
		{
			System.out.println("Product successfully added to the cart");
			
		}
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.findElement(checkout_Button).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement wb = driver.findElement(By.xpath("//td[@class='cart_description']//p[1]"));
		String itemadded =wb.getText();
		if(itemselected.equals(itemadded))
		{
			System.out.println("The item selected is the one added to the cart and the item selected is: " + itemselected);
		}
	
}
}
