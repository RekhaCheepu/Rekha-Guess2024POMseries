package com.qa.guess.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser").trim();
		System.out.println("Browser Name is:"+browserName);
		highlight=prop.getProperty("highlight");
		optionsManager=new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}
		else if(browserName.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("please passs the right browser:"+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	
	public Properties initProp() {
		Properties prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	public static String getScreenshot() {
	    File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	    String directoryPath = System.getProperty("user.dir") + "/screenshot/";
	    File directory = new File(directoryPath);

	    // Create the directory if it does not exist
	    if (!directory.exists()) {
	        directory.mkdirs();  // This creates any necessary but nonexistent parent directories
	    }

	    String path = directoryPath + System.currentTimeMillis() + ".png";
	    File destination = new File(path);
	    
	    try {
	        FileHandler.copy(srcFile, destination);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return path;
	}

	
	public synchronized static WebDriver getDriver() {
		
		return tlDriver.get();
	}

}
	


