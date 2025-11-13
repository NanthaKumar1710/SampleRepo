package vtigerAssignmentOnProducts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class ChangeTheProductNameAndVendarName {

	public static void main(String[] args) throws IOException {
		Fileutility flib = new Fileutility();
		WebDriverutility wlib = new WebDriverutility();
		Excelutility elib = new Excelutility();
		Javautility jlib = new Javautility();

		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		WebDriver driver = new ChromeDriver();

		driver.get(URL);
		String parentid = driver.getWindowHandle();

		if (driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		} else {
			System.out.println("login page was not displayed");
		}

		ProductPage pg = new ProductPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.getLogin(USERNAME, PASSWORD);

		if (driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		} else {
			System.out.println("home page was not displayed");
		}

		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		if (driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed()) {
			System.out.println("product page was displayed");
		} else {
			System.out.println("product page  was not displayed");
		}
		pg.getSearchTextTF().sendKeys(productName);

		WebElement listBox = pg.getSearchFieldDD();

		wlib.selectDropDwon(listBox, "productname");
		pg.getSearchNoWBtn().click();

		pg.getResultItemsLink().click();

		pg.getCreatePurchaseOrderLink().click();

		String subject = elib.getStringDataFromExcel("Sheet1", 3, 4);

		pg.getSubjectTF().sendKeys(subject);

		pg.getVendarPlusIcon().click();

		wlib.switchToWindow(driver);
		String vendar = elib.getStringDataFromExcel("Sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(vendar, Keys.ENTER);

		driver.findElement(By.xpath("(//a[text()='Amazon'])[1]")).click();
		driver.switchTo().window(parentid);

		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		pg.getSubjectTF().sendKeys(subject);

		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();

		pg.getEditBtn().click();

		String NewproductName = elib.getStringDataFromExcel("sheet1", 4, 2);
		WebElement editName = pg.getProductnameTF();

		editName.clear();
		editName.sendKeys(NewproductName);

		pg.getVendarPlusIcon().click();

		wlib.switchToWindow(driver);
		String vendar1 = elib.getStringDataFromExcel("Sheet1", 8, 1);
		pg.getSearchTextTF().sendKeys(vendar1, Keys.ENTER);

		driver.findElement(By.id("1")).click();
		driver.switchTo().window(parentid);
		pg.getSavebutton().click();

	}

}
