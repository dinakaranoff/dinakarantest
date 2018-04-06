package steps;

import org.openqa.selenium.WebDriver;

import com.digi.PropertyReader;
import com.digi.TestContext;
import com.digi.WebdriverManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	
	private static WebDriver driver;
	private PropertyReader propertyReader;
	public TestContext txt;
	
	@Before
	public void setUp(){
		try{
		propertyReader=PropertyReader.getPropertyReader();
		driver=WebdriverManager.getDriver(propertyReader.getbrowser());		
		driver.get(propertyReader.getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@After
	public void cleanUp(){
		driver.close();	
		driver.quit();
	}	

}
