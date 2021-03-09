package com.ww.pages;

import org.openqa.selenium.WebDriver;

public class WeightWatchersApplication extends Page {

	private LandingPage landingPage;
	private FindWorkshopPage findWorkshopPage;
	private StudioHomePage studioHomePage;

	
	public WeightWatchersApplication(WebDriver driver) {
		super(driver);
	}

	
	public LandingPage landingPage(){
		if(landingPage == null){
			landingPage = new LandingPage(driver);
		}
		return landingPage;
	}
	
	public FindWorkshopPage findWorkshopPage(){
		if(findWorkshopPage == null){
			findWorkshopPage = new FindWorkshopPage(driver);
		}
		return findWorkshopPage;
	}
	
	public StudioHomePage studioHomePage(){
		if(studioHomePage == null){
			studioHomePage = new StudioHomePage(driver);
		}
		return studioHomePage;
	}
}
