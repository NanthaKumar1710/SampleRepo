package vtigerAssignment;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

import baseUtility.BaseClass;
@Listeners( com.comcast.crm.generic.ListenerUtility.ListenerUtility.class)
public class CreateOrganizationTc1 extends BaseClass {
	

	@Test
	public void createOrgTest() throws IOException {
	//	UtilityClassObject.getTest().log

		if (driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
		UtilityClassObject.getTest().log(Status.INFO,"home page was displayed");
		} else {
		UtilityClassObject.getTest().log(Status.INFO,"home page was not displayed");
		}

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		int value = jlib.getRandomNumbers();
		String OrgName = elib.getStringDataFromExcel("sheet1", 5, 1) + value;
		op.getNewOrgTxtFld().sendKeys(OrgName);
		op.getSaveBtn().click();

		WebElement OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (OrgInfo.isDisplayed()) {

		UtilityClassObject.getTest().log(Status.INFO,"organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());
		} else {
		UtilityClassObject.getTest().log(Status.INFO,"organization not created");
		}

	}
	

}
