package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTheApp extends Common_Functions {



	@Test
	public void Appointment() {

		WebElement appointmentButton = driver.findElement(By.id("btn-make-appointment"));
		appointmentButton.click();
	}

	@Test
	public void login() {

		WebElement username = driver.findElement(By.id("txt-username"));
		username.sendKeys(prop.getProperty("Username"));

		WebElement password=driver.findElement(By.id("txt-password"));
		password.sendKeys(prop.getProperty("Password"));

		WebElement loginBtn = driver.findElement(By.id("btn-login"));
		loginBtn.click();

	}




	/*
	 * public static void main(String[] args) { LoginTheApp app=new LoginTheApp();
	 * app.Appointment(); app.login(); }
	 */
}




