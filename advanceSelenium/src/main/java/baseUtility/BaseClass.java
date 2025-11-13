package baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class BaseClass {
	public DataBaseutility dlib = new DataBaseutility();
	public Fileutility flib = new Fileutility();
	public WebDriver driver = null;
	public static WebDriver sDriver=null;
	public WebDriverutility wlib = new WebDriverutility();
	public Javautility jlib=new Javautility();
	public Excelutility elib=new Excelutility();


	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		dlib.getDbConnection();
		System.out.println("======Database Connected sucessfully=======");

	}
//    @Parameters("BROWSER")
//	@BeforeClass(groups = {"smokeTest","regressionTest"})
	@BeforeClass
//	public void configBC(String browser) throws IOException {
	public void configBC() throws IOException, InterruptedException {
		Thread.sleep(1000);
		System.out.println("====Launch the browser====");
//		String BROWSER = browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		UtilityClassObject.setDriver(driver);
		driver.get(Url);

	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("=====login=====");
		LoginPage lp = new LoginPage(driver);
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		lp.getLogin(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		WebElement signOutIcon = hp.getSignOutIcon();
		wlib.moveToelement(driver, signOutIcon);
		hp.getSignOutLink().click();
		Thread.sleep(1000);
		System.out.println("====signout=====");

	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("======close the browser====");
		driver.quit();

	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("=====close the DB connecxtion and report backup=====");
		dlib.closeDbConnection();

	}

}
