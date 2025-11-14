package vtigerSingleAssignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import baseUtility.BaseClass;

/**
 * @author NANTHAKUMAR
 */
@Listeners(com.comcast.crm.generic.ListenerUtility.ListenerUtility.class)

public class OrgSingleScriptTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void createOrgTest() throws IOException {
        wlib.waitForPageToLoad(driver);


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

	}

	@Test(groups = { "regressionTest" })
	public void createOrgWithIndustryTest() throws IOException, InterruptedException {
        wlib.waitForPageToLoad(driver);


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

		WebElement industryBtn = op.getIndustryDD();

		Select sc = new Select(industryBtn);
		sc.selectByValue("Education");

		WebElement TypeBtn = op.getTypeDD();

		Select sc1 = new Select(TypeBtn);
		sc1.selectByValue("Analyst");
		op.getSaveBtn().click();

		boolean OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).isDisplayed();

		Assert.assertTrue(OrgInfo);
		UtilityClassObject.getTest().log(Status.INFO,
				"organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());

		ProductPage pg = new ProductPage(driver);
		OrganizationPage og = new OrganizationPage(driver);
		boolean IndustryAttribute = driver.findElement(By.id("mouseArea_Industry")).getText().contains("Education");

		Assert.assertTrue(IndustryAttribute);
		UtilityClassObject.getTest().log(Status.INFO, "industry dropdown working fine");

		UtilityClassObject.getTest().log(Status.INFO,
				"industry dropdown value:" + driver.findElement(By.id("dtlview_Industry")).getText());
		UtilityClassObject.getTest().log(Status.INFO,
				"type dropdown value:" + driver.findElement(By.id("dtlview_Type")).getText());
		Thread.sleep(1000);

	}

	@Test(groups = { "regressionTest" })
	public void verifyPhNoTest() throws IOException {
        wlib.waitForPageToLoad(driver);


		String PhNo = flib.getDataFromPropertiesFile("phoneno");

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

		WebElement industryBtn = op.getIndustryDD();

		Select sc = new Select(industryBtn);
		sc.selectByValue("Education");
		WebElement TypeBtn = op.getTypeDD();
		Select sc1 = new Select(TypeBtn);
		sc1.selectByValue("Analyst");

		op.getPhoneTF().sendKeys(PhNo);

		op.getSaveBtn().click();

		boolean PhNoTF = driver.findElement(By.id("mouseArea_Phone")).getText().contains(PhNo);
		Assert.assertTrue(PhNoTF);
		UtilityClassObject.getTest().log(Status.INFO, "phone number enter to the text field sucessfully");

	}

}
