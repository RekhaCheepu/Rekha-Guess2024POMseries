package com.qa.guess.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.guess.factory.DriverFactory;
import com.qa.guess.pages.AccountsPage;
import com.qa.guess.pages.LoginPage;
import com.qa.guess.pages.ProductInfoPage;
import com.qa.guess.pages.ResultsPage;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ProductInfoPage productInfoPage;
	protected ResultsPage resultsPage;
    protected SoftAssert softAssert;
	protected Properties prop;
	@Parameters({"browser","browserversion"})
	
	@BeforeTest
	public void setUp(String browserName,String browserVersion) {
	    df = new DriverFactory();
	    prop = df.initProp();
	    
	    if(browserName!=null) {
	    	prop.setProperty("browser", browserName);
	    	prop.setProperty("browserversion", browserVersion);
	    }
	    driver = df.initDriver(prop);
	    loginPage = new LoginPage(driver);
	    productInfoPage = new ProductInfoPage(driver); // Initialize productInfoPage
	    softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}