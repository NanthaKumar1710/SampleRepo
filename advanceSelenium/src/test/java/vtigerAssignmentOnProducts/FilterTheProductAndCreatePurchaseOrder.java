package vtigerAssignmentOnProducts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.ContactPage;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class FilterTheProductAndCreatePurchaseOrder {

	public static void main(String[] args) throws IOException, InterruptedException {
		Fileutility flib = new Fileutility();
		WebDriverutility wlib = new WebDriverutility();
		Excelutility elib = new Excelutility();
		Javautility jlib = new Javautility();

		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		WebDriver driver = new ChromeDriver();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);

		driver.get(URL);
		String parentid = driver.getWindowHandle();

		if (driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		} else {
			System.out.println("login page was not displayed");
		}

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		} else {
			System.out.println("home page was not displayed");
		}
        
		
		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);
		
		hp.getProductsLink().click();
//		driver.findElement(By.xpath("//a[text()='Products']")).click();
		if (driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed()) {
			System.out.println("product page was displayed");
		} else {
			System.out.println("product page  was not displayed");
		}
        Thread.sleep(1000);
		pg.getCreateFilterLink().click();
//		driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);
		pg.getViewNameTF().sendKeys(productName);
		pg.getSaveBtn2().click();
//		driver.findElement(By.name("viewName")).sendKeys(productName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//		driver.findElement(By.xpath("(//a[@title='Last'])[1]")).click();
		pg.getSearchTextTF().sendKeys(productName,Keys.ENTER);
		pg.getResultItemsLink().click();
//		driver.findElement(By.xpath("(//a[@title=\"Products\"])[3]")).click();
        pg.getCreatePurchaseOrderLink().click();
//		driver.findElement(By.xpath("//a[text()='Create Purchase Order']")).click();

		String subject = elib.getStringDataFromExcel("Sheet1", 3, 4);
		pg.getSubjectTF().sendKeys(subject);
		pg.getVendarPlusIcon().click();
//		driver.findElement(By.xpath("//a[text()='Create Purchase Order']")).sendKeys(subject);
//		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();

		wlib.switchToWindow(driver);
		String vendar = elib.getStringDataFromExcel("Sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(vendar,Keys.ENTER);
//		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(vendar);
//		driver.findElement(By.name("search")).click();
		ContactPage cp=new ContactPage(driver);
		cp.getSearchResult().click();
//		driver.findElement(By.xpath("(//a[text()='Amazon'])[1]")).click();
		driver.switchTo().window(parentid);
        
		
	
		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		driver.findElement(By.name("subject")).sendKeys(subject);
		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);
//		driver.findElement(By.name("bill_street")).sendKeys(billingAdress);
//		driver.findElement(By.name("ship_street")).sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

	}
	

}
