package vtigerSingleAssignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.ObjectRepository.ContactPage;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import baseUtility.BaseClass;
/**
 * @author NANTHAKUMAR
 */

@Listeners(com.comcast.crm.generic.ListenerUtility.ListenerUtility.class)
public class ProductSingleScriptTest extends BaseClass {
	@Test
	public void createProductTest() throws IOException {
		ProductPage pg = new ProductPage(driver);

	    boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();
		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);
		int value = jlib.getRandomNumbers();

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

		pg.getCreateProductBtn().click();
		pg.getProductnameTF().sendKeys(productName + value);
		pg.getSavebutton().click();

		boolean productConfim = driver.findElement(By.id("mouseArea_Product Name")).getText().contains(productName);
		Assert.assertTrue(productConfim);
		UtilityClassObject.getTest().log(Status.INFO, "new product was created sucessfully");

	}

	@Test
	public void changeTheProductAndVendarNameTest() throws IOException {
		ProductPage pg = new ProductPage(driver);
		String parentid = driver.getWindowHandle();

		 boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();

//		String expected = "Admin123@ Administrator1 - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		 boolean ActTitle = driver.getTitle().contains(expected);

		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

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

	@Test
	public void CreateInvoiceForTheProductTest() throws IOException, InterruptedException {
		OrganizationPage op = new OrganizationPage(driver);
		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);

		 boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();

//		String expected = "Admin123@ Administrator1 - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		 boolean ActTitle = driver.getTitle().contains(expected);

		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		hp.getOrganizationLink().click();
		op.getCreateOrgBtn().click();

		int value = jlib.getRandomNumbers();
		String OrgName = elib.getStringDataFromExcel("sheet1", 5, 1) + value;
		op.getNewOrgTxtFld().sendKeys(OrgName);

		op.getSaveBtn().click();

		boolean OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).isDisplayed();
		Assert.assertTrue(OrgInfo);
		UtilityClassObject.getTest().log(Status.INFO,
				"organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());

		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);

		hp.getProductsLink().click();

		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

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
		Assert.assertTrue(msg.contains(productName));
		UtilityClassObject.getTest().log(Status.INFO, "invoice created sucessfully");

	}

	@Test
	public void createPurchaseOrderTest() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);

		String parentid = driver.getWindowHandle();
//		String expected = "Admin123@ Administrator1 - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		 boolean ActTitle = driver.getTitle().contains(expected);
		 boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();

		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);

		hp.getProductsLink().click();

		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

		WebElement listBox = pg.getSearchFieldDD();
		pg.getSearchTextTF().sendKeys(productName);

		wlib.selectDropDwon(listBox, "productname");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		pg.getResultItemsLink().click();

		pg.getCreatePurchaseOrderLink().click();

		String subject = elib.getStringDataFromExcel("Sheet1", 3, 4);

		pg.getVendarPlusIcon().click();

		wlib.switchToWindow(driver);
		String vendar = elib.getStringDataFromExcel("Sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(vendar, Keys.ENTER);
		driver.findElement(By.id("1")).click();

		driver.switchTo().window(parentid);

		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		pg.getSubjectTF().sendKeys(subject);
		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();

	}

	@Test
	public void CreateQuoteForNewlyAddedProductTest() throws IOException {

		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);

		String parentid = driver.getWindowHandle();

//		String expected = "Admin123@ Administrator1 - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		 boolean ActTitle = driver.getTitle().contains(expected);
		 boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();

		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);
		int value = jlib.getRandomNumbers();

		hp.getProductsLink().click();
		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

		pg.getCreateProductBtn().click();
		pg.getProductnameTF().sendKeys(productName + value);
		pg.getSavebutton().click();

		boolean productConfim = driver.findElement(By.id("mouseArea_Product Name")).getText().contains(productName);
		Assert.assertTrue(productConfim);
		UtilityClassObject.getTest().log(Status.INFO, "new product was created sucessfully");

		pg.getCreateQuoteLink().click();

		String subject = elib.getStringDataFromExcel("Sheet1", 3, 4);
		pg.getSubjectTF().sendKeys(subject);

		pg.getOrgNamePlusIcon().click();

		wlib.switchToWindow(driver);
		String OrgName = elib.getStringDataFromExcel("sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(OrgName, Keys.ENTER);

		driver.findElement(By.id("1")).click();

		wlib.switchToAlert(driver).accept();
		driver.switchTo().window(parentid);

		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);

		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();

		String confMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertTrue(confMsg.contains(productName));

		UtilityClassObject.getTest().log(Status.INFO, "product quote created sucessfully");

	}

	@Test
	public void FilterTheProductAndCreatePurchaseOrderTest() throws IOException, InterruptedException {

		String parentid = driver.getWindowHandle();

	//	String expected = "Admin123@ Administrator1 - Home - vtiger CRM 5 - Commercial Open Source CRM";
	//	 boolean ActTitle = driver.getTitle().contains(expected);
		 boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();

		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");


		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);

		hp.getProductsLink().click();
		boolean ProdPg = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed();
		Assert.assertTrue(ProdPg);
		UtilityClassObject.getTest().log(Status.INFO, "product page was displayed");

		Thread.sleep(1000);
		pg.getCreateFilterLink().click();

		String productName = elib.getStringDataFromExcel("sheet1", 3, 2);
		pg.getViewNameTF().sendKeys(productName);
		pg.getSaveBtn2().click();

		pg.getSearchTextTF().sendKeys(productName, Keys.ENTER);
		pg.getResultItemsLink().click();

		pg.getCreatePurchaseOrderLink().click();

		String subject = elib.getStringDataFromExcel("Sheet1", 3, 4);
		pg.getSubjectTF().sendKeys(subject);
		pg.getVendarPlusIcon().click();

		wlib.switchToWindow(driver);
		String vendar = elib.getStringDataFromExcel("Sheet1", 9, 1);
		pg.getSearchTextTF().sendKeys(vendar, Keys.ENTER);

		ContactPage cp = new ContactPage(driver);
		cp.getSearchResult().click();
		driver.switchTo().window(parentid);

		String deliverAdress = elib.getStringDataFromExcel("sheet1", 1, 3);
		String billingAdress = elib.getStringDataFromExcel("sheet1", 2, 3);
		driver.findElement(By.name("subject")).sendKeys(subject);
		pg.getBillingAdressTF().sendKeys(billingAdress);
		pg.getDeliverAdressTF().sendKeys(deliverAdress);

		wlib.javaScript(driver, "window.scrollBy(851,590);");
		pg.getSavebutton().click();

	}

}
