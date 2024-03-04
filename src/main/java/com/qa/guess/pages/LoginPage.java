package com.qa.guess.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guess.utils.ElementUtil;
import com.qa.guess.utils.TimeUtil;

public class LoginPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By signIn=By.xpath("(//span[text()='Sign in or Register'])[2]");
	private By email=By.id("login-form-email");
	private By password=By.id("form-password");
	private By signInbtn=By.xpath("//button[text()='Sign in']");
	
	private By logoutCheck=By.xpath("(//div[@class='header-user p-0 '])[last()]");
	private By logo=By.xpath("//img[@alt='Guess US']");
	public By logout=By.xpath("//a[text()=' Sign out']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	public boolean logoPresence() {
		return eleUtil.doIsDisplayed(logo);
	}
	public AccountsPage doLogin(String un,String pwd) {
		eleUtil.doActionsClick(signIn);
		eleUtil.waitForElementVisible(email,TimeUtil.DEFAULT_TIME_OUT).sendKeys(un);
				eleUtil.doSendKeys(password, pwd);
		eleUtil.doActionsClick(signInbtn);
		
		eleUtil.waitForElementPresence(logoutCheck, TimeUtil.DEFAULT_TIME_OUT).click();
		eleUtil.doIsDisplayed(logout);
		
		//return driver.findElement(By.xpath("(//span[text()='Rekha'])[2]")).isDisplayed();
		return new AccountsPage(driver);
	}
}
