package com.qa.guess.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guess.utils.AppConstants;
import com.qa.guess.utils.ElementUtil;
import com.qa.guess.utils.TimeUtil;


public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By searchIcon=By.id("header-search-btn");	
	
	private By searchBar=By.name("q");
	
	private By name=By.xpath("(//span[text()='Rekha'])[2]");
	private By logout=By.xpath(" (//li[@class='header-user__nav-item'])[4]");
	private By accSecHeaders=By.xpath("//li[@class='nav-item tabs__navigation-item']");
	
	String frameId="attentive_creative";
	private By closeBtn=By.xpath("//*[local-name()='svg']");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
//	public String getAccPageTitle() {
//		return eleUtil.waitForTitleContains(AppConstants.ACCOUNT_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
//		//return eleUtil.waitForTitleContains(com.qa.guess.utils.AppConstants.ACCOUNT_PAGE_TITLE,TimeUtil.DEFAULT_TIME_OUT);
//	}
	public String getAccPageTitle() {
		return driver.getTitle();
																													
	}
	public String getAccountPageUrl() {
		return driver.getCurrentUrl();
	}
	public boolean isSearchExist() {
		eleUtil.doClick(searchIcon);
		//return driver.findElement(searchIcon).isDisplayed();
		return eleUtil.waitForElementVisible(searchBar, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	public boolean isLogoutExist() {
		eleUtil.doClick(name);
	//	return driver.findElement(logout).isDisplayed();
		return eleUtil.waitForElementVisible(logout, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	public List<String> getAccountPageSectionHeaders() {
		List<WebElement>secHeadersList=driver.findElements(accSecHeaders);
		List<String>secHeadersListValue=new ArrayList<String>();
		
		for(WebElement e:secHeadersList) {
			String text=e.getText();
			secHeadersListValue.add(text);
		}
		return secHeadersListValue;
			
		}
//	public ResultsPage performSearch(String productName) {
//		if(isSearchExist()) {
//			
//		    eleUtil.doActionsClick(searchIcon);
//			
//		//    WebElement search = eleUtil.waitForElementVisible(searchBar, TimeUtil.DEFAULT_TIME_OUT); 
//			WebElement search=driver.findElement(By.name("q"));
//			search.sendKeys(productName);
//			search.sendKeys(Keys.ENTER);
//			
//   					
////			List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
////			if(iframes.size()>0) {
////			driver.switchTo().frame(frameId);
////			driver.findElement(closeBtn).click();
////			driver.switchTo().defaultContent();
////		}else {
//			return new ResultsPage(driver);
//		}
//		return null;
//	}
	public ResultsPage performSearch(String productName) {
	    if (isSearchExist()) {
	        eleUtil.doActionsClick(searchIcon);
	        WebElement search = eleUtil.waitForElementVisible(searchBar, TimeUtil.DEFAULT_TIME_OUT);
	        if (search != null) {
	            search.sendKeys(productName);
	            search.sendKeys(Keys.ENTER);
	            return new ResultsPage(driver);
	        } else {
	            System.out.println("Search bar element not found.");
	        }
	    } else {
	        System.out.println("Search icon not found.");
	    }
	    return null;
	}

}


		


