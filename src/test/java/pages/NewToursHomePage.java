package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	WebDriver driver;
	WebElement registartionLink;
	

	public NewToursHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRegistartionLink() {
		setRegistartionLink();
		return registartionLink;
	}

	public void setRegistartionLink() {
		this.registartionLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	}

	public void clickOnRegistrationLink() {
		getRegistartionLink().click();
	}
}
