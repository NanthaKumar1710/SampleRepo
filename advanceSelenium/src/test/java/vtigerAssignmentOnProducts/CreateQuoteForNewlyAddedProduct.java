package vtigerAssignmentOnProducts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class CreateQuoteForNewlyAddedProduct {

	public static void main(String[] args) throws IOException {
	
		
		Fileutility flib=new Fileutility();
		WebDriverutility wlib=new WebDriverutility();
		Excelutility elib=new Excelutility();
		Javautility jlib=new Javautility();
		
		
		String URL =flib.getDataFromPropertiesFile("url");
		String USERNAME =flib.getDataFromPropertiesFile("username");
		String PASSWORD =flib.getDataFromPropertiesFile("password");
		
		WebDriver driver=new ChromeDriver();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		
		HomePage hp=new HomePage(driver);
		ProductPage pg=new ProductPage(driver);
		
		
		driver.get(URL);
		String parentid = driver.getWindowHandle();
		
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		}else {
			System.out.println("login page was not displayed");
		}
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		}else {
			System.out.println("home page was not displayed");
		}
		
		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);
		int value = jlib.getRandomNumbers();
         
		hp.getProductsLink().click();
//		driver.findElement(By.xpath("//a[text()='Products']")).click();
		if(driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed()) {
			System.out.println("product page was displayed");
		}else {
			System.out.println("product page  was not displayed");
		}
		
		pg.getCreateProductBtn().click();
		pg.getProductnameTF().sendKeys(productName+value);
		pg.getSavebutton().click();
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		driver.findElement(By.name("productname")).sendKeys(productName+value);
		
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String productConfim = driver.findElement(By.id("mouseArea_Product Name")).getText();
		if(productConfim.contains(productName)) {
			System.out.println("new product was created sucessfully");
		}else {
			System.out.println("new product was not created");
		}
		
		pg.getCreateQuoteLink().click();
//		driver.findElement(By.xpath("//a[text()='Create Quote']")).click();
		String subject = elib.getStringDataFromExcel("Sheet1",3,4);
		pg.getSubjectTF().sendKeys(subject);
//		driver.findElement(By.name("subject")).sendKeys(subject);

		pg.getOrgNamePlusIcon().click();
//		driver.findElement(By.xpath("(//img[@title='Select'])[3]")).click();
		wlib.switchToWindow(driver);
		String OrgName =elib.getStringDataFromExcel("sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(OrgName,Keys.ENTER);
//		driver.findElement(By.id("search_txt")).sendKeys(OrgName);

//		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
//		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();
		wlib.switchToAlert(driver).accept();
		driver.switchTo().window(parentid);
		
		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		
		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);
//		driver.findElement(By.name("bill_street")).sendKeys(billingAdress);
//		driver.findElement(By.name("ship_street")).sendKeys(deliverAdress);
		
		
		
		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		String confMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertTrue(confMsg.contains(productName));
//		Assert.assertEquals(confMsg, productName);
		System.out.println("product quote created sucessfully");
//		if(confMsg.contains(productName)) {
//			System.out.println("product quote created sucessfully");
//		}else {
//			System.out.println("product quote not created ");
//		}


	}
	

}
