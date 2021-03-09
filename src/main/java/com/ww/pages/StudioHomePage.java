package com.ww.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudioHomePage extends Page {

    public StudioHomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement dayName;
    private WebElement weekDay;
    private WebElement arrowButton;

    public WebElement arrowButton(){
        arrowButton = driver.findElement(By.xpath("//*[@class='hoursIcon-II-H2']"));
        highlightElement(arrowButton);
        return arrowButton;
    }

    public void clickArrowButton(){
        arrowButton().click();
        delayFor(5000);
    }

    public void businessHour(String wDay){
        List<WebElement> openingTime = driver.findElements(By.xpath("//div[@class='hoursWrapper-1KHIv show-1db4o']/div/div/div[2]"));
        weekDay = driver.findElement(By.xpath("//*[text()=\"" + wDay + "\"]"));
        jsScrollIntoView(weekDay);

        for (WebElement ele : openingTime){
            String hoursOfOperation = ele.getText();
            if (!hoursOfOperation.equals("Closed")){
                System.out.println("The studio is open on " + weekDay.getText() + " at " + hoursOfOperation);
            }
        }
    }


    public void dateAndAppointment(String day, String name) {
        dayName = driver.findElement(By.xpath("(//*[text()=\"" + day + "\"])[2]"));
        List<WebElement> appointment = driver.findElements(By.xpath("//span[text()= \"" + name + "\"]"));
        Map<String, Integer> appList = new HashMap();

        for (WebElement ele : appointment) {
            String currentAppNum = ele.getText();
            if (!currentAppNum.equals(null) && !currentAppNum.equals("")) {
                if (appList.containsKey(currentAppNum)) {
                    appList.put(currentAppNum, appList.get(currentAppNum) + 1);
                } else appList.put(currentAppNum, 1);
            }
        }

        for (String key : appList.keySet()) {
            if (appList.get(key) > 1) {
                System.out.println("There are: " + appList.get(key) + " appointment for " + key +
                        " on " + dayName.getText() + "DAY");
            }
        }
    }
}

