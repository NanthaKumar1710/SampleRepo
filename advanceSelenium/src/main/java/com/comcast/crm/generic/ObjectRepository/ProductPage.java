package com.comcast.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateProductBtn;
	
	@FindBy(name = "productname")
	private WebElement productnameTF;
	
	@FindBy(name = "button")
	private WebElement Savebutton;
	
	@FindBy(xpath = "//a[text()='Create Filter']")
	private WebElement CreateFilterLink;
	
	@FindBy(name  = "search_text")
	private WebElement searchTextTF;
	
	@FindBy(name  = "search_field")
	private WebElement searchFieldDD;
	
	@FindBy(name  = "submit")
	private WebElement searchNoWBtn;
	
	@FindBy(xpath = "//a[@title=\"Products\"][1]")
	private WebElement resultItemsLink;
	

	@FindBy(xpath = "//a[.='Create Purchase Order']")
	private WebElement CreatePurchaseOrderLink;
	
	@FindBy(name  = "subject")
	private WebElement subjectTF;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement VendarPlusIcon;
	
	@FindBy(name  = "bill_street")
	private WebElement billingAdressTF;
	
	@FindBy(name  = "ship_street")
	private WebElement deliverAdressTF;
	
	@FindBy(name  = "Edit")
	private WebElement EditBtn;
	
	@FindBy(xpath = "//a[.='Create Invoice']")
	private WebElement CreateInvoiceLink;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[3]")
	private WebElement orgNamePlusIcon;
	
	@FindBy(xpath = "//a[.='Create Filter']")
	private WebElement createFilterLink;
	
	@FindBy(name  = "viewName")
	private WebElement viewNameTF;
	
	@FindBy(xpath = "//a[.='Create Quote']")
	private WebElement createQuoteLink;
	
	@FindBy(name  = "button2")
	private WebElement SaveBtn2;
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public WebElement getCreateProductBtn() {
		return CreateProductBtn;
	}

	public WebElement getProductnameTF() {
		return productnameTF;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	public WebElement getCreateFilterLink() {
		return CreateFilterLink;
	}

	public WebElement getSearchTextTF() {
		return searchTextTF;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNoWBtn() {
		return searchNoWBtn;
	}

	public WebElement getResultItemsLink() {
		return resultItemsLink;
	}

	public WebElement getCreatePurchaseOrderLink() {
		return CreatePurchaseOrderLink;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getVendarPlusIcon() {
		return VendarPlusIcon;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDeliverAdressTF() {
		return deliverAdressTF;
	}

	public WebElement getBillingAdressTF() {
		return billingAdressTF;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getCreateInvoiceLink() {
		return CreateInvoiceLink;
	}

	public WebElement getOrgNamePlusIcon() {
		return orgNamePlusIcon;
	}

	public WebElement setCreateFilterLink() {
		return createFilterLink;
	}

	public WebElement getViewNameTF() {
		return viewNameTF;
	}

	public WebElement getCreateQuoteLink() {
		return createQuoteLink;
	}

	public WebElement getSaveBtn2() {
		return SaveBtn2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
