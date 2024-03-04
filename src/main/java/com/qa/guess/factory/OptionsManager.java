package com.qa.guess.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
private Properties prop;
private ChromeOptions co;
private FirefoxOptions fo;

OptionsManager(Properties prop){
	this.prop=prop;
	}
public ChromeOptions getChromeOptions() {
	co=new ChromeOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		System.out.println("running test cases in headless----");
		co.addArguments("--headless");
		}
	if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		System.out.println("running test cases in incognito");
		co.addArguments("--incognito");
	}
	return co;
	
}
public FirefoxOptions getFirefoxOptions() {
	fo=new FirefoxOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		System.out.println("running test cases in headless----");
		fo.addArguments("--headless");
	}
	if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		System.out.println("running test cases in incognito");
		fo.addArguments("--incognito");
	
}
	return fo;

}
}
