package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		
		UserName.sendKeys("fgfdgfd@fgf.com");
		Password.sendKeys("Abcd@1234");
		RememberMe.click();
		LoginButton.click();
		
		WebElement ErrorMessage = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMessage.getText();
		String ExpectedMsg = "The email or password you have entered is invalid.";
		
		if (ActualMsg.equals(ExpectedMsg)) {
			System.out.println("The Test Case is Pass");
		}else {
			System.out.println("The Test Case is Fail");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links in the page are " + Links.size());
		
		for (WebElement elm:Links) {
			System.out.println(elm.getAttribute("href"));
		}
		
		driver.close();
		

	}

}
