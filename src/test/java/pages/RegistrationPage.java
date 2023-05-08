package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	WebDriver driver;
	WebElement firstNameTextField;
	WebElement lastNameTextField;
	WebElement phoneTextField;
	WebElement emailTextField;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameTextField() {
		setFirstNameTextField();
		return firstNameTextField;
	}

	public void setFirstNameTextField() {
		this.firstNameTextField = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastNameTextField() {
		setLastNameTextField();
		return lastNameTextField;
	}

	public void setLastNameTextField() {
		this.lastNameTextField = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getPhoneTextField() {
		setPhoneTextField();
		return phoneTextField;
	}

	public void setPhoneTextField() {
		this.phoneTextField = driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement getEmailTextField() {
		setEmailTextField();
		return emailTextField;
	}

	public void setEmailTextField() {
		this.emailTextField = driver.findElement(By.xpath("//input[@name='userName']"));
	}
}
