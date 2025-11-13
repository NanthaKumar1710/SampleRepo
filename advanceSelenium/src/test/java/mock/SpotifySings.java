package mock;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ObjectRepository.spotifyHomePage;


import baseUtility.BaseClassSpotify;

public class SpotifySings extends BaseClassSpotify {
	
	@Test(dataProvider = "getData")
	public void spotify(String artistName) throws IOException, InterruptedException {
		int i = 0;
		spotifyHomePage sp = new spotifyHomePage(driver);

		sp.getSearchTF().sendKeys(artistName, Keys.ENTER);
		Thread.sleep(2000);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		driver.findElement(By.xpath("(//span[.='"+artistName+"'])[1]")).click();
	
		Thread.sleep(3000);
		List<WebElement> songName = driver
				.findElements(By.xpath("//div[@aria-colindex='2']/descendant::div[@class='hb8C1VAjyUg0VMxrwpix']"));
		
		for (WebElement song : songName) {
			System.out.println(song.getText());
			elib.setDataIntoExcel("Sheet3", i+1, 1, song.getText());
			i++;
		}
		sp.getSearchTF().clear();
	}


	@DataProvider
	public Object[][] getData() throws Throwable {

		int rowcount = elib.getRowCount("songss");
		int cellCount = elib.getCellCount("songss");
		Object[][] objArr = new Object[rowcount][cellCount];
		for (int i = 0; i < rowcount; i++) {
				for(int j = 0; j<=cellCount; j++){
			objArr[i][j] = elib.getStringDataFromExcel("songss", i + 1, j);
			}
		}
		return objArr;
	}
}
