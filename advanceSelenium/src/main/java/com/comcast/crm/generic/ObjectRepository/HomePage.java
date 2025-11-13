package com.comcast.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getSignOutIcon() {
		return signOutIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	
	
	
	
	

}
