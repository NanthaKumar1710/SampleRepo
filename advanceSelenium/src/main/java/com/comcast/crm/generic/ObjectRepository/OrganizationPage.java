package com.comcast.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement NewOrgTxtFld;
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(name = "phone")
	private WebElement phoneTF;
	
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getNewOrgTxtFld() {
		return NewOrgTxtFld;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneTF() {
		return phoneTF;
	}
	
	
	
	
	
	

}
