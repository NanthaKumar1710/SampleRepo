package myPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.ObjectRepository.LoginPage;

public class objectRep {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.getLogin("admin", "admin");

	}

}
