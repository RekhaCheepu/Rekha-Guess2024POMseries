package com.qa.guess.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guess.utils.ElementUtil;
import com.qa.guess.utils.TimeUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productHeader=By.cssSelector("div.row.mb-lg-3");
	private By productImages=By.cssSelector("div.css-1bn8s1b");
	private By productPriceData=By.xpath("(//div[@class='row'])[2]");
	private By productColor=By.xpath("(//div[contains(@class ,'js-color-status')])[1]");
	private By addToCart=By.cssSelector("div.cart-and-ipay__cta.flex-grow-1.flex-shrink-1");
	private By viewCart=By.id("action_item_minicart");
	private By productsInBag=By.xpath("//h1/span");
public ProductInfoPage(WebDriver driver) {
	this.driver=driver;
	eleUtil=new ElementUtil(driver);
}
public String getProductHeader() {
	System.out.println("Getting product header...");
String prodHeader=	eleUtil.doGetElementText(productHeader);
System.out.println("Getting product header..."+prodHeader);
return prodHeader;
	
	
}
public int getProductImagesCount() {
	System.out.println("Getting product images count...");
	int imagesCount=eleUtil.waitForElementsVisible(productImages, TimeUtil.DEFAULT_TIME_OUT).size();
	
System.out.println("images count is------>"+imagesCount);
return imagesCount;
}
public String getProductPrice() {
String price=	eleUtil.waitForElementVisible(productPriceData, TimeUtil.DEFAULT_TIME_OUT).getText();
System.out.println("price of the product is:"+price);
return price;
	}
public String getProductColor() {
String color=	eleUtil.getElement(productColor).getText();
System.out.println("color of the product is:"+color);
return color;
}
public String toCheckProductsInCart() {
	eleUtil.getElement(addToCart).click();
	eleUtil.waitForElementVisible(viewCart, TimeUtil.DEFAULT_TIME_OUT).click();
	String productsInCart=eleUtil.getElement(productsInBag).getText();
	return productsInCart;
	
	
	
	
	
}
}






