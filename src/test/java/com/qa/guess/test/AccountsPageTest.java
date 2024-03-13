package com.qa.guess.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guess.base.BaseTest;
import com.qa.guess.utils.AppConstants;

public class AccountsPageTest extends BaseTest {
	@BeforeClass
	
	
	public void accSetUp() {
		 accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void accPageTitletest() {
		String actTitle=accPage.getAccPageTitle();
		System.out.println("acc page title:"+actTitle);
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE);
		
	}
	@Test
	public void accPageUrlTest() {
		String actUrl=accPage.getAccountPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.ACCOUNT_PAGE_FRACTIONURL));
	}
	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	@Test
	public void isLogoutExist() {
		Assert.assertTrue(accPage.isLogoutExist());
	}
	@Test
	public void accPageHeaderTest() {
		List<String>actHeaderList=accPage.getAccountPageSectionHeaders();
		Assert.assertEquals(actHeaderList, AppConstants.EXPECTED_ACC_HEADERS_LIST);
	}
	@DataProvider
	public Object[][] getProductName() {
		return new Object[][] {
			{"Belts"},
			{"Totes"},
			{"Shoe"},
			
			
		};
	}
	@Test//(dataProvider="getProductName")
	public void productSearchTest(String productName) {
		
	resultsPage=accPage.performSearch(productName);
	String actTitle=resultsPage.getSearchPageTitle(productName);

	System.out.println("searchPage title is:"+actTitle);
	
	//Assert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_FRACTION_TILE+productName+" | "+"GUESS");

	Assert.assertTrue(actTitle.contains(productName));
	Assert.assertTrue(resultsPage.getSearchProductCount()>0);
	}
	
	 

}