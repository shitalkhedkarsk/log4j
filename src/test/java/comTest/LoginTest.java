package comTest;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest
{

	WebDriver driver;
	Logger log= Logger.getLogger("logger");
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","F:\\webdriver\\chromedriver_win32 (2)\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
		Reporter.log("launch browser successfully....",true);	
		log.info("launch browser successfully...>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
		log.warning("just a warning message!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	@Test
	public void freeCrmTitleTest()
	{
		String title = driver.getTitle();
		System.out.println("browser title is:>>> "+title);
		Reporter.log("Browser title dispay successfully .....",true);
		String expectedResult = "Free CRM software for customer relationship management, sales, marketing campaigns and support.";
		Assert.assertEquals(title, expectedResult,"expectected title is not equal to browser title");
		
	}
	
	@Test
	public void freeCrmLogoTest()
	{
		WebElement logo = driver.findElement(By.xpath("//img[@class='img-responsive']//parent::a[@class='navbar-brand']"));
		boolean l = logo.isDisplayed();
		Assert.assertTrue(l, "logo is not dispay");
	}
	
	
	
	
	@AfterMethod
	public void testclose()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
