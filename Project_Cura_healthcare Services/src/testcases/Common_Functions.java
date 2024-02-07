package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Common_Functions {

	public static Properties prop;
	FileInputStream input;
	public	static WebDriver driver;

	public Properties setProperty() {

		try {
			input = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		prop = new Properties(); 
		try {
			prop.load(input);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}
	
	@BeforeSuite
	public void launchBrowser() {

		setProperty();
		String BaseUrl=	prop.getProperty("Url");
		String Browser=prop.getProperty("browser");
		String Drivelocation = prop.getProperty("driveLocation");

		if(Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", Drivelocation);
			driver= new ChromeDriver();
			driver.get(BaseUrl);

		}

		if(Browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", Drivelocation);
			driver= new FirefoxDriver();
			driver.get(BaseUrl);
		}
	}
	
	
	@AfterSuite
	public void TearDown() {
		driver.quit();
	}

}
