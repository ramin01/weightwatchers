package com.ww.tests;


import org.testng.annotations.Test;
import util.ScriptBase;


public class weightWatchersTest extends ScriptBase {


	@Test
	public void wWTest() {
			weightWatchers().landingPage().VerifyPageTitle();
			weightWatchers().landingPage().clickArrowDropdown();
			weightWatchers().landingPage().clickFindWorkshop();

			weightWatchers().findWorkshopPage().VerifyPageTitle();
			weightWatchers().findWorkshopPage().clickStudio();
			weightWatchers().findWorkshopPage().clickLocationBox("10011");
			weightWatchers().findWorkshopPage().studioLocationAndDistance();
		    weightWatchers().findWorkshopPage().verifyStudioNameMultiplePages();

		    weightWatchers().studioHomePage().clickArrowButton();
		    weightWatchers().studioHomePage().businessHour("Thursday");
		    weightWatchers().studioHomePage().dateAndAppointment("SUN","JOHN B.");
	}
}
