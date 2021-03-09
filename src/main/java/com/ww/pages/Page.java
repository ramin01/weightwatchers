package com.ww.pages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;


public class Page {
	
	protected WebDriver driver;

	public Page(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	public WebElement waitForElementDisplayed(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}

	public void jsScrollIntoView(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: yellow; border: 2px solid yellow;");
			delayFor(200);
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}
}
