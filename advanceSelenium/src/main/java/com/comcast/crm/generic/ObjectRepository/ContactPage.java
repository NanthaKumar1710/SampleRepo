package com.comcast.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewContact;
	
	@FindBy(name = "lastname")
	private WebElement lastnameTF;
	
	@FindBy(name =  "button")
	private WebElement Savebutton;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement orgNamePlusIcon;
	
	@FindBy(name =  "search_text")
	private WebElement NewWindowSearchTF;
	
	@FindBy(xpath = "//a[@id='1']")
	private WebElement SearchResult;
	
	@FindBy(name  = "support_start_date")
	private WebElement SupportStartDateTF;
	
	@FindBy(name  = "support_end_date")
	private WebElement SupportEndDateTF;
	
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public WebElement getCreateNewContact() {
		return createNewContact;
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	public WebElement getOrgNamePlusIcon() {
		return orgNamePlusIcon;
	}

	public WebElement getNewWindowSearchTF() {
		return NewWindowSearchTF;
	}

	public WebElement getSearchResult() {
		return SearchResult;
	}

	public WebElement getSupportStartDateTF() {
		return SupportStartDateTF;
	}

	public WebElement getSupportEndDateTF() {
		return SupportEndDateTF;
	}
	
	
	

	
	
	

}
