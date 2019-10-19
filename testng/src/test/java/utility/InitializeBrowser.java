package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeBrowser {

	private static InitializeBrowser ib;
	public WebDriver driver;

	private InitializeBrowser() {
		String path = System.getProperty("user.dir");
		System.out.println("Project dir path: " + path);
		System.setProperty("webdriver.gecko.driver", path
				+ "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static InitializeBrowser intialize() {
		if (ib == null) {
			ib = new InitializeBrowser();
		}
		return ib;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
