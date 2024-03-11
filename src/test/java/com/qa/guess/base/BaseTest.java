package com.qa.guess.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	protected Properties prop;
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
	prop=df.initProp();
	 System.out.println("Properties: " + prop);
	driver=df.initDriver(prop);
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}