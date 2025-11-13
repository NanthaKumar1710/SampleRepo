package mock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class Train {
	
	public static void main(String[] args) {
		 DataBaseutility dlib = new DataBaseutility();
		 Fileutility flib = new Fileutility();
	     WebDriverutility wlib = new WebDriverutility();
	   	Javautility jlib=new Javautility();
	     Excelutility elib=new Excelutility();
		WebDriver driver=new ChromeDriver();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		
		driver.get("https://www.confirmtkt.com/rbooking/trains/from/SBC/to/MAS/07-11-2025");
//		driver.findElement(By.xpath("//p[.='From']")).sendKeys("Sbc - Bengaluru - All ",Keys.ENTER);
//		driver.findElement(By.xpath("//p[.='To']")).sendKeys("Mas - Mgr Chennai Ctl",Keys.ENTER);
//		driver.findElement(By.xpath("//button[.='SEARCH']")).click();
//		
//		 List<WebElement> train1 = driver.findElements(By.xpath("//p[@class='body-xs inline-block text-secondary']"));
//		 for(WebElement t1:train1) {
//			String time = t1.getText();
//			if(time)
//			
//		 }
		
		
		

	}

}
