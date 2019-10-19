package scritps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Waits;

public class Login {
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElements
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginhomebutton;
	@FindBy(id="ContentPlaceHolder1_txtLogEmail")
	private WebElement usernamefield;
	@FindBy(id="ContentPlaceHolder1_txtLogPassword")
	private WebElement passwordfield;
	@FindBy(id="ContentPlaceHolder1_btnLogin")
	private WebElement loginbutton;
	@FindBy(xpath="//div[@class='member_login']/span[2]")
	private WebElement validationmessage;
	
	
	public void clickonhomeloginbutton()
	{
		Waits.waitInSecsClickable(driver, loginhomebutton, 10);
		loginhomebutton.click();	
	}
	public void enterusername(String user)
	{
		Waits.waitInSecsClickable(driver, usernamefield, 10);
		usernamefield.clear();
		usernamefield.sendKeys(user);
	}
	public void enterpassword(String password)
	{
		Waits.waitInSecsClickable(driver, passwordfield, 10);
		passwordfield.clear();
		passwordfield.sendKeys(password);
	}
	public void clickonloginbutton()
	{
		Waits.waitInSecsClickable(driver, loginbutton, 10);
		loginbutton.click();
	}
	public void verifyvalidationmessgage()
	{
		Waits.waitInSecsClickable(driver, validationmessage, 10);
		String actual = validationmessage.getText();
		Assert.assertEquals(actual, "Entered Email/Password is Invalid","Validation message does not match");
	}
}
