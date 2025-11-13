package vtigerAssignmentOnProducts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.ObjectRepository.ProductPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;
 
public class CreateProducts {

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
		int value = jlib.getRandomNumbers();

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		if (driver.findElement(By.xpath("(//a[text()='Products'])[2]")).isDisplayed()) {
			System.out.println("product page was displayed");
		} else {
			System.out.println("product page  was not displayed");
		}

		pg.getCreateProductBtn().click();
		pg.getProductnameTF().sendKeys(productName + value);
		pg.getSavebutton().click();

		String productConfim = driver.findElement(By.id("mouseArea_Product Name")).getText();
		if (productConfim.contains(productName)) {
			System.out.println("new product was created sucessfully");
		} else {
			System.out.println("new product was not created");
		}

	}
	

}
