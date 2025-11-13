package vtigerAssignmentOnProducts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class CreateInvoiceForTheProduct {

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
		OrganizationPage op = new OrganizationPage(driver);
		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);

		driver.get(URL);

		if (driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		} else {
			System.out.println("login page was not displayed");
		}

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		if (driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		} else {
			System.out.println("home page was not displayed");
		}

		hp.getOrganizationLink().click();
		op.getCreateOrgBtn().click();

		int value = jlib.getRandomNumbers();
		String OrgName = elib.getStringDataFromExcel("sheet1", 5, 1) + value;
		op.getNewOrgTxtFld().sendKeys(OrgName);

		op.getSaveBtn().click();

		WebElement OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (OrgInfo.isDisplayed()) {

			System.out.println("organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());
		} else {
			System.out.println("organization not created");
		}

		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);

		hp.getProductsLink().click();

		if (driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed()) {
			System.out.println("product page was displayed");
		} else {
			System.out.println("product page  was not displayed");
		}

		WebElement listBox = driver.findElement(By.id("bas_searchfield"));
		wlib.selectDropDwon(listBox, "productname");
		pg.getSearchTextTF().sendKeys(productName, Keys.ENTER);

		Thread.sleep(1000);

		pg.getResultItemsLink().click();

		pg.getCreateInvoiceLink().click();

		String parentId = driver.getWindowHandle();

		pg.getOrgNamePlusIcon().click();

		wlib.switchToWindow(driver);
		pg.getSearchTextTF().sendKeys(OrgName, Keys.ENTER);

		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();
		wlib.switchToAlert(driver).accept();
		driver.switchTo().window(parentId);
		Thread.sleep(4000);

		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		String subject = elib.getStringDataFromExcel("sheet1", 2, 4);

		pg.getSubjectTF().sendKeys(subject);
		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();

		String msg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (msg.contains(productName)) {
			System.out.println("invoice created sucessfully");
		} else {
			System.out.println("invoice not created sucessfully");
		}

	}

}
