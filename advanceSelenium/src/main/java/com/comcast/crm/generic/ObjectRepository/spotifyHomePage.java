package com.comcast.crm.generic.ObjectRepository;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseUtility.BaseClassSpotify;

public class spotifyHomePage extends BaseClassSpotify{
	
	@FindBy(xpath = "//span[.='Log in']")
	private WebElement logInBtn;
	
	@FindBy(xpath = "//a[.='Continue with phone number']")
	private WebElement continueWithPhNoBtn;
	
	@FindBy(name  = "inputPhoneNumber")
	private WebElement PhoneNumberTF;
	
	@FindBy(xpath = "(//span[.='Next'])[1]")
	private WebElement NextBtn;
	
	@FindBy(xpath = "(//span[.='Next'])[2]")
	private WebElement NextBtn2;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTF;
	
	
	@FindBy(xpath = "//div[.='Anirudh All Time Hits | Telugu']")
	private WebElement AnirudhLink;
	
	@FindBy(xpath = "(//span[.='Yuvan Shankar Raja'])[1]")
	private WebElement YuvanLink;
	
	@FindBy(xpath = "//div[.='GV Prakash Melody Hits 💝']")
	private WebElement GVLink;
	
//	@FindBy(xpath = "//div[.='']")
//	private WebElement GVLink;
	
	
//	@FindBy(xpath   = "//div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']")
//	private List<WebElement> Songlist;
	
//	@FindBy(xpath   = "//div[@class='e-91000-text encore-text-body-medium encore-internal-color-text-base eYJgrgW01l7dHKuMJidG standalone-ellipsis-one-line']")
//	private  List<WebElement> SongsList;
//	//div[.='Yuvan All Songs ❤️‍🩹']
	
	public spotifyHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}


	public WebElement getLogInBtn() {
		return logInBtn;
	}


	public WebElement getContinueWithPhNoBtn() {
		return continueWithPhNoBtn;
	}


	public WebElement getPhoneNumberTF() {
		return PhoneNumberTF;
	}


	public WebElement getNextBtn() {
		return NextBtn;
	}


	public WebElement getNextBtn2() {
		return NextBtn2;
	}


	public WebElement getSearchTF() {
		return searchTF;
	}


	public WebElement getAnirudhLink() {
		return AnirudhLink;
		
	}


	public WebElement getYuvanLink() {
		return YuvanLink;
	}
	
	
	
	


//	public List<WebElement> getSonglist() {
//		return Songlist;
//	}


//	public WebElement getSongsList() {
//		return SongsList;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
