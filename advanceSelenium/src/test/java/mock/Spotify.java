package mock;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ObjectRepository.spotifyHomePage;
import com.comcast.crm.generic.fileutility.Excelutility;
import baseUtility.BaseClassSpotify;

public class Spotify extends BaseClassSpotify {
	public Excelutility elib = new Excelutility();
	String SongName;

	@Test
	public void spotify() throws IOException, InterruptedException {
		int i = 0;
		spotifyHomePage sp = new spotifyHomePage(driver);
		String Artist1 = elib.getStringDataFromExcel("singers", 1, 2);
		String Artist2 = elib.getStringDataFromExcel("singers", 2, 2);
		String Artist3 = elib.getStringDataFromExcel("singers", 3, 2);
		String Artist4 = elib.getStringDataFromExcel("singers", 4, 2);
		String Artist5 = elib.getStringDataFromExcel("singers", 5, 2);
		


		sp.getSearchTF().sendKeys(Artist1, Keys.ENTER);
		Thread.sleep(2000);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		driver.findElement(By.xpath("(//span[.='"+Artist1+"'])[1]")).click();
	
		Thread.sleep(3000);
		List<WebElement> songList = driver.findElements(By.xpath(
				"//div[.='Monica']/ancestor::div[@role='presentation']/descendant::div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']"));
		
		List<WebElement> views1 = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));
		for (WebElement song : songList) {
			System.out.println(song.getText());
			elib.setDataIntoExcel("Sheet3", i+1, 1, song.getText());
			i++;
		}
		i=0;
		for (WebElement views : views1) {
			System.out.println(views.getText());
				elib.setDataIntoExcel("Sheet3",  i+ 1, 2, views.getText());
				i++;
		}
		sp.getSearchTF().clear();
		Thread.sleep(2000);
/********************************************************************************************************/		

		sp.getSearchTF().sendKeys(Artist2, Keys.ENTER);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		driver.findElement(By.xpath("(//span[.='"+Artist2+"'])[1]")).click();
		

		Thread.sleep(3000);
		List<WebElement> songList2 = driver.findElements(By.xpath(
				"//div[.='Tere Bina']/ancestor::div[@role='presentation']/descendant::div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']"));
		
		List<WebElement> views2 = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));
		for (WebElement song4 : songList2) {
			System.out.println(song4.getText());
				elib.setDataIntoExcel("Sheet8", i+ 1, 1, song4.getText());
				i++;		
			}	
		i=0;
		for (WebElement views : views2) {
			System.out.println(views.getText());
				elib.setDataIntoExcel("Sheet8",  i+ 1, 2, views.getText());
				i++;
		}
		Thread.sleep(2000);	
        sp.getSearchTF().clear();
 /********************************************************************************************************/		
 
        
		sp.getSearchTF().sendKeys(Artist3, Keys.ENTER);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		driver.findElement(By.xpath("(//span[.='"+Artist3+"'])[1]")).click();
		Thread.sleep(3000);
		List<WebElement> songList3 = driver.findElements(By.xpath(
				"//div[.='Golden Sparrow (From \"Nilavuku En Mel Ennadi Kobam\")']/ancestor::div[@role='presentation']/descendant::div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']"));
        
		List<WebElement> views3 = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));
		for (WebElement song1 : songList3) {
			System.out.println(song1.getText());
		
				elib.setDataIntoExcel("Sheet5",i + 1, 1, song1.getText());
				i++;		
		}
		i=0;
		for (WebElement views : views3) {
			System.out.println(views.getText());
				elib.setDataIntoExcel("Sheet5",  i+ 1, 2, views.getText());
				i++;
		}

		sp.getSearchTF().clear();
		Thread.sleep(2000);
		/********************************************************************************************************/		

		sp.getSearchTF().sendKeys(Artist4, Keys.ENTER);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		driver.findElement(By.xpath("(//span[.='"+Artist4+"'])[1]")).click();
		Thread.sleep(3000);
		List<WebElement> songList4 = driver.findElements(By.xpath(
				"//div[.='Kannala Kannala - The Melting Point of Love']/ancestor::div[@role='presentation']/descendant::div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']"));
        
		List<WebElement> views4 = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));
		for (WebElement song2 : songList4) {
			System.out.println(song2.getText());
			
				elib.setDataIntoExcel("Sheet6",i+1, 1, song2.getText());
				i++;	
		}
		i=0;
		for (WebElement views : views4) {
			System.out.println(views.getText());
				elib.setDataIntoExcel("Sheet6",  i+ 1, 2, views.getText());
				i++;
		}
		

		sp.getSearchTF().clear();
		Thread.sleep(2000);
		/********************************************************************************************************/		

		sp.getSearchTF().sendKeys(Artist5, Keys.ENTER);
		wlib.javaScript(driver, "window.scrollBy(0,400);");
		WebElement artist = driver.findElement(By.xpath("(//span[.='"+Artist5+"'])[1]"));
        //sp.getYuvanLink().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",artist);
        
		int ROWCOUNT5 = elib.getRowCount("Sheet4");
		Thread.sleep(3000);
		List<WebElement> songList5 = driver.findElements(By.xpath(
				"//div[.='Thuli Thuli']/ancestor::div[@role='presentation']/descendant::div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']"));
        
		List<WebElement> views5 = driver.findElements(By.xpath("//div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));

		for (WebElement song3 : songList5) {
			System.out.println(song3.getText());
				elib.setDataIntoExcel("Sheet7",  i+ 1, 1, song3.getText());
				i++;
		}
		i=0;
		
		for (WebElement views : views5) {
			System.out.println(views.getText());
				elib.setDataIntoExcel("Sheet7",  i+ 1, 2, views.getText());
				i++;
		}
		
		

	}
	

}
