package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	private WebElement pageTitle;
	WebElement searchTextBox;
	WebElement dropDown;
	WebElement collegeImege;
	WebElement maleRadioButton;
	WebElement femaleRadioButton;
	WebElement orageCheckbox;
	WebElement blueCheckbox;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPageTitle() {
		setPageTitle();
		return pageTitle;
	}

	public void setPageTitle() {
		pageTitle = driver.findElement(By.xpath("//h1[@class='title']"));
	}

	public WebElement getSearchTextBox() {
		setSearchTextBox();
		return searchTextBox;
	}

	public void setSearchTextBox() {
		this.searchTextBox = driver.findElement(By.xpath("//input[@name='q' and @title='search']"));
	}

	public WebElement getDropdown() {
		setDropdown();
		return dropDown;
	}

	public void setDropdown() {
		dropDown = driver.findElement(By.xpath("//select[@id='drop1']"));
	}

	public WebElement getCollegeImege() {
		setCollegeImege();
		return collegeImege;
	}

	public void setCollegeImege() {
		this.collegeImege = driver.findElement(By.xpath("//img[contains(@src,'college')]"));
	}

	public WebElement getMaleRadioButton() {
		setMaleRadioButton();
		return maleRadioButton;
	}

	public void setMaleRadioButton() {
		this.maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

	public WebElement getFemaleRadioButton() {
		setFemaleRadioButton();
		return femaleRadioButton;
	}

	public void setFemaleRadioButton() {
		this.femaleRadioButton = driver.findElement(By.xpath("//input[@id='radio2']"));

	}

	public WebElement getOrageCheckbox() {
		setOrageCheckbox();
		return orageCheckbox;
	}

	public void setOrageCheckbox() {
		this.orageCheckbox = driver.findElement(By.xpath("//input[@id='checkbox1']"));
	}

	public WebElement getBlueCheckbox() {
		setBlueCheckbox();
		return blueCheckbox;
	}

	public void setBlueCheckbox() {
		this.blueCheckbox = driver.findElement(By.xpath("//input[@id='checkbox2']"));
	}

	public void setTextInSearchTextField(String textToSearch) {
		getSearchTextBox().sendKeys(textToSearch);
	}

	public boolean verifySearchTextFieldIsEnabled() {
		return getSearchTextBox().isEnabled();
	}

	public String getValueSelectedInDropdown() {

		Select select = new Select(getDropdown());
		return select.getFirstSelectedOption().getText();
	}

	public List<String> getTableData() {
		ArrayList<String> table = new ArrayList<String>();
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
		for (WebElement elm : tableData) {
			table.add(elm.getText());
		}
		return table;
	}

}
