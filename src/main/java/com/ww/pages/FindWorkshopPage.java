package com.ww.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;


public class FindWorkshopPage extends Page {

	public FindWorkshopPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement studio;
	private WebElement locationBox;
	private WebElement searchButton;
	private WebElement studioSearchResult;
	private WebElement studioDistance;
	private WebElement currentStudioTitle;
	private WebElement studioName;
	
	public WebElement studio(){
		studio = driver.findElement(By.xpath("//*[@class='buttonText-3DCCO'][contains(text(),'Studio')]"));
		highlightElement(studio);
		return studio;
	}

	public WebElement locationBox(){
		locationBox = driver.findElement(By.id("location-search"));
		highlightElement(locationBox);
		return locationBox;
	}

	public WebElement searchButton(){
		searchButton = driver.findElement(By.id("location-search-cta"));
		highlightElement(searchButton);
		return searchButton;
	}

	public WebElement studioSearchResult(){
		studioSearchResult = driver.findElement(By.xpath("//*[@class='linkUnderline-1_h4g']"));
		highlightElement(studioSearchResult);
		return studioSearchResult;
	}

	public WebElement studioDistance(){
		studioDistance = driver.findElement(By.xpath("//*[@class='distance-OhP63']"));
		highlightElement(studioDistance);
		return studioDistance;
	}

	public void VerifyPageTitle(){
		delayFor(2000);
		String expectedPageTitle = "Find WW Studios & Meetings Near You | WW USA";
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
	}

	public void clickStudio(){
		studio().click();
	}

	public void clickLocationBox(String zipCode){
		locationBox().clear();
		locationBox().sendKeys(zipCode);
		searchButton().click();
	}

	public void studioLocationAndDistance(){
		System.out.println("The nearest studio name is " + studioSearchResult().getText() + " And it is "
				+ studioDistance().getText() + " away from you.");
	}

	public void verifyStudioNameMultiplePages(){
		currentStudioTitle = driver.findElement(By.className("linkUnderline-1_h4g"));
		List<String> savedStudioTitle = new ArrayList<>();
		savedStudioTitle.add(currentStudioTitle.getText());
		studioSearchResult().click();
		studioName = driver.findElement(By.className("locationName-1jro_"));
		Assert.assertEquals(savedStudioTitle.get(0),studioName.getText());
	}
}
