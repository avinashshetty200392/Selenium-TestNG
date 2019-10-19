package testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import scritps.Login;
import scritps.Register;
import utility.InitializeBrowser;

public class MethodCallingTest {

	InitializeBrowser init;
	WebDriver driver;
	Login login;
	Register register;

	@BeforeTest
	public void navigateToApplication() {
		init = InitializeBrowser.intialize();
		driver = init.getDriver();
		driver.get("https://www.meripustak.com/");
	}

	@Test(priority = 1, enabled = true)
	public void loginfeature() {
		login=new Login(driver);
		login.clickonhomeloginbutton();
		login.enterusername("avinash.shetty@gmail.com");
		login.enterpassword("shetty");
		login.clickonloginbutton();
		login.verifyvalidationmessgage();
	}

	@Test(priority=2,enabled=true,dependsOnMethods="loginfeature")
	public void registerfeature()
	{
		register = new Register(driver);
		register.entername("Avinash");
		register.enteremail("avinash.shetty@gmail.com");
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
