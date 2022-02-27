package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		List<WebElement> tbColumns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		
		System.out.println("The total number of rows are " + tbRows.size());
		System.out.println("The total number of columns are " + tbColumns.size());
		
		List<WebElement> tbData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[4]/td"));
		
		for (WebElement elm:tbData) {
			
			System.out.println(elm.getText());
		}
		
		int column = 1;
		String xpath = "//table[@id='customers']//td[" + column + "]";
		//td[text()='Island Trading']/following-sibling::td
		
		List<WebElement> tbFirstColumn = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]"));
		
		for (WebElement elm1:tbFirstColumn) {
			
			System.out.println(elm1.getText());
		}
		
		driver.close();

	}

}
