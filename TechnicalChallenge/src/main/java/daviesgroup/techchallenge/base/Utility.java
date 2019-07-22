package daviesgroup.techchallenge.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

public class Utility extends Base {
	
	public static Select sel = null;
	//public static WebDriverWait wait = new WebDriverWait(driver, 20);
	
	public static void takeScreenShot(String transaction) {
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+transaction+System.currentTimeMillis()+".png");
		try {
		
			FileUtils.copyFile(source, destination);
			} catch(Exception e) {
				System.out.println("Failed to take screenshot");
			}

	}
	
	public static String newMailID(String name) {
		long num = (long) (1000000*Math.random());
		return name+num+num+"@gmail.com";
	
	}
	
	public static void selectByValue(By by, String option) {
		sel = new Select(driver.findElement(by));
		sel.selectByValue(option);
		
	}
	
	public static void selectByVisibleText(By by, String option) {
		sel = new Select(driver.findElement(by));
		sel.selectByVisibleText(option);
	}

}