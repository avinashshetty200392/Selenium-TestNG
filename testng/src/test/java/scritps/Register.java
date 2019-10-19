package scritps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Waits;

public class Register {

	WebDriver driver;

	public Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerbutton;
	@FindBy(id = "ContentPlaceHolder1_txtUserName")
	private WebElement namefield;
	@FindBy(id = "ContentPlaceHolder1_txtRegisterEmail")
	private WebElement emailfield;

	public void entername(String name) {
		Waits.waitInSecsClickable(driver, namefield, 10);
		namefield.clear();
		namefield.sendKeys(name);
	}

	public void enteremail(String email) {
		Waits.waitInSecsClickable(driver, emailfield, 10);
		emailfield.clear();
		emailfield.sendKeys(email);

	}

}
