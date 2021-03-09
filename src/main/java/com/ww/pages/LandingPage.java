package com.ww.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage extends Page{

	private WebElement arrowDropdown;
	private WebElement findWorkshop;


	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement arrowDropdown(){
		arrowDropdown = waitForElementDisplayed(By.className("Icon_icon__wrapper__3dIsp"));
		highlightElement(arrowDropdown);
		return arrowDropdown;
	}
	public WebElement findWorkshop(){
		findWorkshop = waitForElementDisplayed(By.xpath("//*[@class='MenuItem_menu-item__inner-wrapper__1trJ0']//span[contains(text(),\"Unlimited Workshops\")]"));
		highlightElement(findWorkshop);
		return findWorkshop;
	}
	
	public void VerifyPageTitle(){
		delayFor(2000);
		String expectedPageTitle = "WW (Weight Watchers): Weight Loss Program & Wellness Help | WW USA";
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
	}

	public void clickArrowDropdown(){
		arrowDropdown().click();
	}

	public void clickFindWorkshop(){
		findWorkshop().click();
	}
}
