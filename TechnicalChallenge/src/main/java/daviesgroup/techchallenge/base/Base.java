package daviesgroup.techchallenge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\daviesgroup\\techchallenge\\config\\configdetails.properties");
			prop.load(fip);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Files\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Please select browser option as chrome ");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.navigate().to(prop.getProperty("url"));
		System.out.println("Site launchced on browser is: " + driver.getCurrentUrl());
	}

}
