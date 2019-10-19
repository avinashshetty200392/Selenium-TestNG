package parallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParallelExecution {

	@Test
	public void initializingChrome() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path
				+ "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.meripustak.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginbutton = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		loginbutton.click();
		WebElement email = driver.findElement(By
				.id("ContentPlaceHolder1_txtLogEmail"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("avinash.shetty@gmail.com");
		driver.quit();
	}

	@Test
	public void initializingFirefox() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path
				+ "\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.meripustak.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginbutton = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		loginbutton.click();
		WebElement email = driver.findElement(By
				.id("ContentPlaceHolder1_txtLogEmail"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("avinash.shetty@gmail.com");
		driver.quit();
	}

}
