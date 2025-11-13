package taskOn2510;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class AutomationPractice {

	@Test(priority = 1)

	public void DragAndDropTest() {
		WebDriver driver = new ChromeDriver();
		WebDriverutility wlib = new WebDriverutility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

		wlib.javaScript(driver, "window.scrollBy(968,200);");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		

	}

	@Test(priority = 2)
	public void sliderTest() {
		WebDriver driver = new ChromeDriver();
		WebDriverutility wlib = new WebDriverutility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

		wlib.javaScript(driver, "window.scrollBy(1000,600);");

		WebElement minimun = driver.findElement(By.xpath("//DIV[@id='slider-range']/child::span[1]"));
		WebElement maximum = driver.findElement(By.xpath("//DIV[@id='slider-range']/child::span[2]"));

		Actions act = new Actions(driver);
		act.dragAndDropBy(maximum, -57, 0).perform();
		act.dragAndDropBy(minimun, 9, 0).perform();

	}

	@Test(priority = 3)
	public void firefoxTest() {
		WebDriver driver = new ChromeDriver();
		WebDriverutility wlib = new WebDriverutility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

		wlib.javaScript(driver, "window.scrollBy(1000,600);");

		System.out.println(driver.findElement(By.xpath("//td[text()='Firefox']/..")).getText());

	}

	@Test(priority = 4)
	public void uploadFileTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverutility wlib = new WebDriverutility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.scrollByAmount(1000, 400).perform();
		WebElement FILE = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		FILE.sendKeys("C:\\Users\\NANTHAKUMAR\\Pictures\\file.jpg");

	}

	@Test(priority = 5)
	public void routerTest() {
		WebDriver driver = new ChromeDriver();
		WebDriverutility wlib = new WebDriverutility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		wlib.javaScript(driver, "window.scrollBy(0,1200);");

		WebElement table = driver.findElement(By.xpath("//th[text()='ID']/ancestor::table"));

		List<WebElement> nextPageBtn = driver.findElements(By.xpath("//a[@href='#']"));
		for (WebElement next : nextPageBtn) {
			String tabelContent = table.getText();
			if (tabelContent.contains("Router")) {
				System.out.println("Router was present");

				break;
			} else {
				next.click();
			}
		}

		driver.findElement(By.xpath("//td[text()='Router']/ancestor::tr/descendant::input")).click();
		WebElement priceOfRouter = driver
				.findElement(By.xpath("//td[text()='Router']/ancestor::tr/descendant::td[text()='$24.99']"));
		System.out.println(priceOfRouter.getText());

	}

}