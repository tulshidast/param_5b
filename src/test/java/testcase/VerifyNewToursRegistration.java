package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.NewToursHomePage;
import pages.RegistrationPage;

public class VerifyNewToursRegistration {
	WebDriver driver;
	NewToursHomePage newToursHomePage;
	RegistrationPage registrationPage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		newToursHomePage = new NewToursHomePage(driver);
		registrationPage = new RegistrationPage(driver);
	}

	@Test(dataProvider = "registration")
	public void VerifyRegistartion(String firstName, String lastName, String phone, String email) {
		newToursHomePage.clickOnRegistrationLink();
		registrationPage.getFirstNameTextField().sendKeys(firstName);
		registrationPage.getLastNameTextField().sendKeys(lastName);
		registrationPage.getPhoneTextField().sendKeys(phone);
		registrationPage.getEmailTextField().sendKeys(email);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.getScreenshot(driver, result.getName());
		}
		//driver.quit();
	}

	@DataProvider(name = "registration")
	public String[][] registrationDataProvider() {
		String[][] registration = { { "sachin", "tendulkar", "0204545454", "sachin@email.com" } };
		return registration;
	}

}
