package com.digi;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.cons.Constants;

public class Manager {

	public  static WebDriver driver=null;
	private static PropertyReader  propertyReader;
	public static SeleniumManager seleniumManager;
	private String browser;
	private static LoggerManager logger;
	private String currentClassName=this.getClass().getName();

	@BeforeSuite(alwaysRun=true)
	public void setup(){
		initProperty();
		initLogger();
		initWebdriver();
	}


	//private Manager(){
		//		try {
		//			propertyReader=PropertyReader.getPropertyReader();
		//			browser=propertyReader.getbrowser();
		//			logger=Logtool.getLogger();
		//		} catch (Exception e) {
		//		logger.error(currentClassName, "Unable to read property File", e);
		//		}
	//}

	private void initLogger(){
		try{
			logger=LoggerManager.getLogger();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}

	}

	private void initProperty(){
		try {
			propertyReader=PropertyReader.getPropertyReader();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}
	}

	private void initWebdriver(){
		try {
			seleniumManager=SeleniumManager.getSeleniumManager();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}
	}
	
	public static WebDriver getDriver(){
		return driver;
	}

		
	@AfterSuite
	private void cleanup(){
		logger.info("killing driver");
		driver.close();
		logger.cleanup();		
	}
	

	//	
	//	@Test
	//	public void testSample(){
	//		driver =WebdriverManager.getDriver();
	//	}


	//	public static void main(String[] args){
	//		driver =WebdriverManager.getDriver();
	//	}

}
