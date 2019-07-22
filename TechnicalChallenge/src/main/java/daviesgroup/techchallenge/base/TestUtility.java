package daviesgroup.techchallenge.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtility extends Base {
	
	public static void main(String args[]){
	
	System.setProperty("webdriver.chrome.driver", "C:\\Files\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com");
	takeScreenShot();
	System.out.println("Newly created mail id is:"+newMailID("murali"));
	System.out.println("current url: " + driver.getCurrentUrl());
	}
	
	public static void takeScreenShot() {
	File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+System.currentTimeMillis()+".png");
	try {
		
		FileUtils.copyFile(source, destination);
		} catch(Exception e) {
			System.out.println("Failed to take screenshot");
		}

	}
	
	public static String newMailID(String name) {
		int num = (int) (1000000*Math.random());
		return name+num+"@gmail.com";
	
	}
}
