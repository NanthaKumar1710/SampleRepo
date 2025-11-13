package myPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class PracticeForUtilityClasses {

	public static void main(String[] args) throws IOException {
		Fileutility flib=new Fileutility();
		Excelutility elib=new Excelutility();
		WebDriverutility wlib=new WebDriverutility();
		DataBaseutility dlib=new DataBaseutility();
		
	    String URL = flib.getDataFromPropertiesFile("url");
		System.out.println(flib.getDataFromPropertiesFile("browser"));
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		System.out.println(elib.getStringDataFromExcel("sheet1", 5, 1));
		System.out.println(elib.getStringDataFromExcel("sheet1", 6, 2));
		System.out.println(elib.getStringDataFromExcel("sheet1", 7, 1));
		System.out.println(elib.getStringDataFromExcel("sheet1", 8, 2));
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		wlib.getPhoto(driver);
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		WebElement newOrg = driver.findElement(By.xpath("//input[@name='accountname']"));
		WebElement newOrgElemet = driver.findElement(By.xpath("//span[text()='Creating New Organization']"));

		
		wlib.javaScript(driver, "window.scrollBy(100,500);");
		
		WebElement indDrop = driver.findElement(By.name("industry"));
		
		wlib.selectDropDwon(indDrop, "Banking");
		
		
		
		


		


	}

}
