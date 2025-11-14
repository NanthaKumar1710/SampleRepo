package vtigerSingleAssignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Author;
import com.comcast.crm.generic.ObjectRepository.ContactPage;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import baseUtility.BaseClass;

/**
 * @author NANTHAKUMAR
 */
@Listeners(com.comcast.crm.generic.ListenerUtility.ListenerUtility.class)
public class ContactSingleScriptTest extends BaseClass {
	@Test(groups = { "smokeTest" })
	public void createNewContactTest() throws IOException {
        wlib.waitForPageToLoad(driver);

		boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();
		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		int value = jlib.getRandomNumbers();
		String LastName = elib.getStringDataFromExcel("sheet1", 1, 1) + value;

		cp.getLastnameTF().sendKeys(LastName);
		cp.getSavebutton().click();

		String SucessMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		boolean expectedMsg = SucessMsg.contains(LastName);
		Assert.assertTrue(expectedMsg);

		UtilityClassObject.getTest().log(Status.INFO, "new contact added sucessfully");

		UtilityClassObject.getTest().log(Status.INFO,
				"new contact name:" + driver.findElement(By.id("mouseArea_Last Name")).getText());

	}

	@Test(groups = { "regressionTest" })
	public void CreateNewContactWithPreOrgTest() throws InterruptedException, IOException {
        wlib.waitForPageToLoad(driver);
		String parentid = driver.getWindowHandle();

		boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();
		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		int value = jlib.getRandomNumbers();
		String OrgName = elib.getStringDataFromExcel("sheet1", 5, 1) + value;
		op.getNewOrgTxtFld().sendKeys(OrgName);
		op.getSaveBtn().click();

		WebElement OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));

		Assert.assertTrue(OrgInfo.isDisplayed());
		UtilityClassObject.getTest().log(Status.INFO,
				"organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());

		HomePage hp1 = new HomePage(driver);
		hp1.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		int value1 = jlib.getRandomNumbers();
		String LastName = elib.getStringDataFromExcel("sheet1", 1, 1) + value1;

		cp.getLastnameTF().sendKeys(LastName);

		cp.getOrgNamePlusIcon().click();

		wlib.switchToWindow(driver);

		cp.getNewWindowSearchTF().sendKeys(OrgName, Keys.ENTER);

		Thread.sleep(1000);

		cp.getSearchResult().click();

		driver.switchTo().window(parentid);
		cp.getSavebutton().click();

		String SucessMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		boolean expectedMsg = SucessMsg.contains(LastName);
		Assert.assertTrue(expectedMsg);

		UtilityClassObject.getTest().log(Status.INFO, "new contact added sucessfully");

		UtilityClassObject.getTest().log(Status.INFO,
				"new contact name:" + driver.findElement(By.id("mouseArea_Last Name")).getText());

	}

	@Test(groups = { "regressionTest" })
	public void enteringDateTest() throws IOException {
        wlib.waitForPageToLoad(driver);

		boolean expected = driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();
		Assert.assertTrue(expected, "home page was not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "home page was displayed");

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		int value = jlib.getRandomNumbers();
		String LastName = elib.getStringDataFromExcel("sheet1", 1, 1) + value;

		cp.getLastnameTF().sendKeys(LastName);

		wlib.javaScript(driver, "window.scrollBy(400,500);");

		cp.getSupportStartDateTF().clear();
		cp.getSupportEndDateTF().clear();

		String actDate = jlib.getSystemDateYYYYDDMM();
		String expectedDate = jlib.getRequiredDateYYYYDDMM(30);

		cp.getSupportStartDateTF().sendKeys(actDate);
		cp.getSupportEndDateTF().sendKeys(expectedDate);
		cp.getSavebutton().click();

		String stDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		Assert.assertEquals(stDate, actDate, "Support Start Date not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Support Start Date displayed sucessfully");

		String edDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		Assert.assertEquals(edDate, expectedDate, "Support End Date not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Support End Date displayed sucessfully");

		String SucessMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		boolean expectedMsg = SucessMsg.contains(LastName);
		Assert.assertTrue(expectedMsg);
		UtilityClassObject.getTest().log(Status.INFO, "new contact added sucessfully");

		UtilityClassObject.getTest().log(Status.INFO,
				"new contact name:" + driver.findElement(By.id("mouseArea_Last Name")).getText());

	}

}
