package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Make_Appointment extends Common_Functions {

	@Test
	public void SelectFaculty() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement faculty=	driver.findElement(By.xpath("//select[@name=\'facility\']"));
		Select select= new Select(faculty);
		select.selectByVisibleText("Seoul CURA Healthcare Center");
	}

	@Test(dependsOnMethods = "SelectFaculty")
	public void ApplyCheckbox() {

		WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
		checkbox.click();
	}

	@Test(dependsOnMethods = "ApplyCheckbox")
	public void SelectHealthProgram() {

		WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ratioBtn =driver.findElement(By.xpath("//input[@value=\'Medicaid\']"));	
		Wait.until(ExpectedConditions.elementToBeClickable(ratioBtn));
		ratioBtn.click();

	}

	@Test(dependsOnMethods =  "SelectHealthProgram")
	public void AppointmentDate() {

		WebElement date =	driver.findElement(By.id("txt_visit_date"));
		date.sendKeys("07/02/2024");

	}

	@Test(dependsOnMethods = "AppointmentDate")
	public void comment() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement commentBox = driver.findElement(By.xpath("//textarea[@placeholder=\"Comment\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(commentBox));
		commentBox.click();
		commentBox.sendKeys("I will come for health checkup in the date! ");

	}

	@Test(dependsOnMethods = "comment")
	public void BooKAppointment() {

		WebElement BooKBtn = driver.findElement(By.id("btn-book-appointment"));
		BooKBtn.click();
	}

	@Test(dependsOnMethods = "BooKAppointment")
	public void Confirmation() {

		WebElement text	= driver.findElement(By.tagName("h2"));
		String txt=text.getText();
		System.out.println(txt);

	}

	@Test(dependsOnMethods = "Confirmation")
	public void Menu() {

		WebElement taggle = driver.findElement(By.id("menu-toggle"));
		taggle.click();
	}

	@Test(dependsOnMethods = "Menu")
	public void history() {

		WebElement historytab =	driver.findElement(By.linkText("History"));
		historytab.click();

	}

	@Test(dependsOnMethods = "history")
	public void SnapHistoryrecord() {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./ScreenshotFile/HistoryRecordSnap.png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = "Historyrecord")
	public void logout() {
		WebElement taggle1 = driver.findElement(By.id("menu-toggle"));
		taggle1.click();
		WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
		logoutBtn.click();
	}
}
