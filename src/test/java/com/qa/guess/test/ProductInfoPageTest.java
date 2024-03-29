package com.qa.guess.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guess.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
@BeforeClass
	
	public void accSetUp() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
}
@DataProvider
public Object[][] getProductTestData() {
	return new Object[][] {
		
		{"Overall Dress ","Leopard Denim Overalls (2-7)"},
		{"Reversible Belt Gold","Reversible Jacquard Quattro G Belt"},
		{"GUESS Bella","GUESS Bella Vita Rosa, 3.4 oz"},
		{"Floral Jewelery","14K Gold-Plated Floral Statement Earrings"},
		{"Small Bag","Ederlo Small Necessity Bag"},
	};
	
}
@Test(dataProvider="getProductTestData")
public void productHeaderTest(String searchKey, String searchProductName) {
	//
resultsPage=accPage.performSearch(searchKey);
productInfoPage=resultsPage.selectProduct(searchProductName);
String actHeader=productInfoPage.getProductHeader();
Assert.assertEquals(actHeader, searchProductName);
}

@DataProvider
public Object[][] getProductImagesTestData() {
	return new Object[][] {
		
		{"Overall Dress ","Leopard Denim Overalls (2-7)",2},
		{"Reversible Belt Gold","Reversible Jacquard Quattro G Belt",3},
		{"GUESS Bella","GUESS Bella Vita Rosa, 3.4 oz",2},
		{"Floral Jewelery","14K Gold-Plated Floral Statement Earrings",3},
		{"Small Bag","Ederlo Small Necessity Bag",4},
	};
	
}
@Test(dataProvider="getProductImagesTestData")
public void productImagesTest(String searchKey,String mainProduct,int imagesCount) {
	resultsPage=accPage.performSearch(searchKey);
	productInfoPage=resultsPage.selectProduct(mainProduct);
	int actImgCount=productInfoPage.getProductImagesCount();
	Assert.assertEquals(actImgCount, imagesCount);
	}
//@DataProvider
//public Object[][] getproductImagesTestData() {
//	Object[][] imgData=ExcelUtil.getTestData(AppConstants.IMAGESCOUNT_SHEET_NAME);
//	return imgData;
//}
//
//@Test(dataProvider="getproductImagesTestData")
//public void productImagesTest(String searchKey,String mainProduct,int imagesCount) {
//	resultsPage=accPage.performSearch(searchKey);
//	productInfoPage=resultsPage.selectProduct(mainProduct);
//int actImgCount=	productInfoPage.getProductImagesCount();
//Assert.assertEquals(actImgCount, imagesCount);
//}
@DataProvider
public Object[][] getProductPriceAndColorTestData() {
	return new Object[][] {
		
		{"Overall Dress ","Leopard Denim Overalls (2-7)"},
		{"Reversible Belt Gold","Reversible Jacquard Quattro G Belt"},
		{"GUESS Bella","GUESS Bella Vita Rosa, 3.4 oz"},
		{"Floral Jewelery","14K Gold-Plated Floral Statement Earrings"},
		{"Small Bag","Ederlo Small Necessity Bag"},
	};
	
}
@Test (dataProvider="getProductPriceAndColorTestData")
public void productPriceAndColorTest(String searchKey,String mainProduct) {
	resultsPage=accPage.performSearch(searchKey);
	productInfoPage=resultsPage.selectProduct(mainProduct);
	String priceText=productInfoPage.getProductPrice();
	String colorText=productInfoPage.getProductColor();
	softAssert.assertTrue(colorText.contains("Color"));	
	Assert.assertTrue(priceText.contains("$"));
}
}


