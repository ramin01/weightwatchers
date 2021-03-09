package util;

import com.ww.pages.WeightWatchersApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ScriptBase {

	protected WebDriver driver ;
	String appUrl = "https://www.weightwatchers.com/us/";
	private WeightWatchersApplication weightWatchers;

	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(@Optional("ch")String browser, Method method) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.navigate().to(appUrl);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.close();
		driver.quit();
		driver = null;
		weightWatchers = null;
	}

	public WeightWatchersApplication weightWatchers(){
		if(weightWatchers == null){
			weightWatchers = new WeightWatchersApplication(driver);
		}
		return weightWatchers;
	}
}
