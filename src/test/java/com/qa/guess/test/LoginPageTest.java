package com.qa.guess.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.guess.base.BaseTest;
import com.qa.guess.utils.AppConstants;
import com.qa.guess.utils.AppErrors;

public class LoginPageTest extends BaseTest {
	@Test
	public void loginPageUrlTest() {
		String actUrl=loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL),AppErrors.NO_URL_MATCHED);
	}
	@Test
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE,AppErrors.NO_TITLE_MATCHED);
		
		}
	@Test
	public void logoPresenceTest() {
		Assert.assertTrue(loginPage.logoPresence());
	}

	

	@Test
	public void loginTest() {
	    
	    accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutExist(),AppErrors.LOGIN_UNSUCCESSFUL);
	}

}
