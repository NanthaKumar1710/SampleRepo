package vtigerContacts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.ContactPage;
import com.comcast.crm.generic.ObjectRepository.HomePage;
import com.comcast.crm.generic.ObjectRepository.LoginPage;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class CreateNewContact {

	public static void main(String[] args) throws IOException {
		Fileutility flib=new Fileutility();
		WebDriverutility wlib=new WebDriverutility();
		Excelutility elib=new Excelutility();
		Javautility jlib=new Javautility();
		
		
		String URL =flib.getDataFromPropertiesFile("url");
		String USERNAME =flib.getDataFromPropertiesFile("username");
		String PASSWORD =flib.getDataFromPropertiesFile("password");
		
		WebDriver driver=new ChromeDriver();
	
		driver.get(URL);
		
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) {
			System.out.println("login page was displayed");
		}else {
			System.out.println("login page was not displayed");
		}
		
		LoginPage lp=new LoginPage(driver);
		lp.getLogin(USERNAME, PASSWORD);


		if(driver.getTitle().contains("Admin123@ Administrator1 - Home")) {
			System.out.println("home page was displayed");
		}else {
			System.out.println("home page was not displayed");
		}
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContact().click();

		int value =jlib.getRandomNumbers();
		String LastName =elib.getStringDataFromExcel("sheet1", 1, 1)+value;
		
	
		cp.getLastnameTF().sendKeys(LastName);
		cp.getSavebutton().click();

		
		 String SucessMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(SucessMsg.contains(LastName)) {
        	System.out.println("new contact added sucessfully");
        }else{
        	System.out.println("new contact not added ");
        }
        
        System.out.println("new contact name:"+ driver.findElement(By.id("mouseArea_Last Name")).getText());
		
	}

}
