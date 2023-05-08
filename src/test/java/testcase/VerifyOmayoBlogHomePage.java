package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyOmayoBlogHomePage {
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
	public void verifyOmayoHomePage() throws IOException {
		// Verify user is on omayo home page.
		assertEquals(homePage.getPageTitle().getText(), "omayo (QAFox.com)");

		String value = "doc 1";
		// Verify that value is selected from dropdown
		Utility.selectValueFromDropdown(homePage.getDropdown(), value);
		assertEquals(homePage.getValueSelectedInDropdown(), value);

		// Make sure Image is displayed at left upper side.
		assertTrue(homePage.getCollegeImege().isDisplayed());

		// Verify table contents.
		List<String> expectedTableData = new ArrayList<String>();
		expectedTableData = Arrays.asList("Kishore", "22", "Delhi", "Manish", "25", "Pune", "Praveen", "29",
				"Bangalore", "Dheepthi", "31", "Mumbai");
		assertTrue(homePage.getTableData().equals(expectedTableData));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
