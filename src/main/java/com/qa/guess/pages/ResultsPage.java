package com.qa.guess.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.guess.utils.ElementUtil;
import com.qa.guess.utils.JavaScriptUtil;
import com.qa.guess.utils.TimeUtil;

public class ResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
private	JavaScriptUtil js;
	String frameId="attentive_creative";
			private By closeBtn=By.xpath("//*[local-name()='svg']");
			
	private By searchProducts=By.cssSelector("div.product ");
	private By finalProduct=By.xpath("//a[text()='mainProductName']");
	
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		js=new JavaScriptUtil(driver);
		
		}
	public  void frameExist() {
		 eleUtil.waitForFramePresentAndSwitch(frameId, TimeUtil.DEFAULT_TIME_OUT);
//		eleUtil.doClick(closeBtn);
//		return driver.switchTo().defaultContent();
	}
	


public String getSearchPageTitle(String productName) {
	return eleUtil.waitForTitleContains(productName, TimeUtil.DEFAULT_TIME_OUT);
	}

public int getSearchProductCount() {
	
	int productCount=eleUtil.waitForElementsVisible(searchProducts, TimeUtil.DEFAULT_TIME_OUT).size();
	System.out.println("product count is :"+productCount);
	return productCount;

}
public ProductInfoPage selectProduct(String mainProductName) {
    String xpathExpression = "//a[text()='"+ mainProductName +"']";
    WebElement product = eleUtil.waitForElementVisible(By.xpath(xpathExpression), TimeUtil.DEFAULT_TIME_OUT);
    
    if (product != null) {
    //	js.scrollIntoViewIfNeeded(product);
    	
    	
       product.click();
    }

    return new ProductInfoPage(driver);
}


	
	
	
	
	
}

