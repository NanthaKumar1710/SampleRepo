package baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.crm.generic.ObjectRepository.spotifyHomePage;
import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class BaseClassSpotify {
	public DataBaseutility dlib = new DataBaseutility();
	public Fileutility flib = new Fileutility();
	public WebDriver driver = null;
	public static WebDriver sDriver=null;
	public WebDriverutility wlib = new WebDriverutility();
	public Javautility jlib=new Javautility();
	public Excelutility elib=new Excelutility();
	
	@BeforeClass
	public void lounch() throws IOException {
	
		System.out.println("====Launch the browser====");
		
//		String BROWSER = browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url3");

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
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
			
	}
	
	@AfterMethod
	public void logOut() {
		
	}
	
//	@BeforeMethod
//	public void login() throws IOException, InterruptedException {
		
//		
//		spotifyHomePage sp=new spotifyHomePage(driver);
//		sp.getLogInBtn().click();
//		sp.getContinueWithPhNoBtn().click();
//		String PhoneNumber = flib.getDataFromPropertiesFile("phoneno");
//		sp.getPhoneNumberTF().sendKeys(PhoneNumber);
//		sp.getNextBtn().click();
//		
//		Thread.sleep(10000);
//		sp.getNextBtn2().click();
		
		
//	}
	
	

}
