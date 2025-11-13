package vtigerAssignment;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.ObjectRepository.OrganizationPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class CreateOrgWithIndustry {
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

		if (driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		} else {
			System.out.println("login page was not displayed");
		}

		LoginPage lp = new LoginPage(driver);
		lp.getLogin(USERNAME, PASSWORD);

		if (driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		} else {
			System.out.println("home page was not displayed");
		}

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

		WebElement OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (OrgInfo.isDisplayed()) {

			System.out.println("organization name:" + driver.findElement(By.id("dtlview_Organization Name")).getText());
		} else {
			System.out.println("organization not created");
		}

		if (driver.findElement(By.id("mouseArea_Industry")).getText().contains("Education")) {
			System.out.println("industry dropdown working fine");
		} else {
			System.out.println("industry dropdown not working ");
		}

		System.out.println("industry dropdown value:" + driver.findElement(By.id("dtlview_Industry")).getText());
		System.out.println("type dropdown value:" + driver.findElement(By.id("dtlview_Type")).getText());

		driver.quit();

	}

}
