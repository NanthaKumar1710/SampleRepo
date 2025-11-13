package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseUtility.BaseClass;

public class WebDriverutility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void fullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void mouseHover(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement element, CharSequence keys ) {
		Actions act = new Actions(driver);
		act.sendKeys(element).perform();
	}
	
	public void scroll(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	
	public void selectDropDwon(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectDropDwon(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectDropDwon(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void SwitchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void SwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void getPhoto(WebDriver sDriver) throws IOException {
		String date = LocalDateTime.now().toString().replace(":", "-");
		Javautility jutil = new Javautility();
		TakesScreenshot ts = (TakesScreenshot)sDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+date+"image.png");
		FileUtils.copyFile(temp, dest);
		
	}
	
	public void switchToWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parent);
		for(String id : allWindowIds) {
			driver.switchTo().window(id);
//			String actUrl = driver.getCurrentUrl();
//			if(actUrl.equals(expUrl)) {
//				break;
//			}
		}
	}
	
	public void switchToWindow(String expTitle, WebDriver driver) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id : allWindowIds) {
			driver.switchTo().window(id);
//			String actTitle = driver.getTitle();
//			if(actTitle.equals(expTitle)) {
//				break;
//			}
		}
	}
	
	public void clickAndPause(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void javaScript(WebDriver driver,String jsCode) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(jsCode);
		
		
	}
	public void moveToelement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	

}
