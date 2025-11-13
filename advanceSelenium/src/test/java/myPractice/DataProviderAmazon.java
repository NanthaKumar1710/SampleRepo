package myPractice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;

public class DataProviderAmazon {
	@Test(dataProvider = "dataSender")
	public void search(String brandName, String productName) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		WebElement x = driver.findElement(By.xpath("//span[text()='" + productName
				+ "']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		System.out.println(x.getText());
		driver.quit();

	}


	@DataProvider
	public Object[][] dataSender() throws EncryptedDocumentException, IOException {
		Excelutility elib = new Excelutility();
		int rowCount = elib.getRowCount("Sheet2");
		Object[][] objArr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = elib.getStringDataFromExcel("Sheet2", i + 1, 0);
			objArr[i][1] = elib.getStringDataFromExcel("Sheet2", i + 1, 1);
		}
		return objArr;
	}
}
