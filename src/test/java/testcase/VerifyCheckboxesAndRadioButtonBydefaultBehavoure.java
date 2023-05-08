package testcase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyCheckboxesAndRadioButtonBydefaultBehavoure {
	WebDriver driver;
	HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
	}

	@Test(priority = 1, groups = { "e2e" }, enabled = true)
	public void verifyCheckboxesAndRadioButtonBehaviours() throws IOException {
		/*
		 * Verify that male and female radio button are unchecked Make sure orage
		 * checkbox is checked and blue checkbox is unchecked
		 */
		assertFalse(homePage.getMaleRadioButton().isSelected());
		assertFalse(homePage.getFemaleRadioButton().isSelected());

		assertTrue(homePage.getOrageCheckbox().isSelected());
		assertFalse(homePage.getBlueCheckbox().isSelected());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
