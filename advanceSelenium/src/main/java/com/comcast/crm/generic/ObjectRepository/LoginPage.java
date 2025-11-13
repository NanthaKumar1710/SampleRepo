package com.comcast.crm.generic.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverutility;

public class LoginPage extends WebDriverutility {

		WebDriver driver;
		
		@FindBy(name= "user_name")
		private WebElement UserNameTxtLink;
		
		@FindBy(name= "user_password")
		private WebElement passwordLink;
		
		@FindBy(id= "submitButton")
		private WebElement submitBtn;
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}

		public WebElement getUserNameTxtLink() {
			return UserNameTxtLink;
		}

		public WebElement getPasswordLink() {
			return passwordLink;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		
		
		public void getLogin(String userName,String Password) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			getUserNameTxtLink().sendKeys(userName);
			getPasswordLink().sendKeys(Password);
			getSubmitBtn().click();
		}
		

	

}
