package MobilePackage;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
*/
//import MobilePackage.PropertyTest.*;
//import MobilePackage.POILoginTest.*;

import java.io.IOException;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class LoginTest{
	protected WebDriver driver;
	@BeforeClass
	public void setupapplication() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/arijit/Documents/LIVETEST/MobileProject/src/main/chromedriver");
		driver= new ChromeDriver();
		POITest t=new POITest();//creating object of that class and calling the method of it.
		driver.get(t.readExcel(0, 1));
		
		Thread.sleep(3500);
		Reporter.log("***Application Started***", true);
		
		driver.findElement(By.xpath(PropertyTest.getORvalue("setting_icon"))).click();
		driver.findElement(By.xpath(PropertyTest.getORvalue("sub_setting"))).click();
	
		driver.findElement(By.id(PropertyTest.getORvalue("service_address_id"))).clear();
		driver.findElement(By.id(PropertyTest.getORvalue("service_address_id"))).sendKeys(t.readExcel(3, 1));
		
		/* clicks on the space between service address and station box */ 
		driver.findElement(By.xpath(PropertyTest.getORvalue("space_btween_service_&_station_xpath"))).click(); 
		Thread.sleep(1000);
		//Station selection from the Station drop down box
		Select sl = new Select(driver.findElement(By.id(PropertyTest.getORvalue("station_drop_down_id"))));
		sl.selectByVisibleText(t.readExcel(4, 1));  
		
		//clicks the Submit button of settings pop up
		driver.findElement(By.id(PropertyTest.getORvalue("Setting_submit_id"))).click();
		
		//insert user-name at UserNamefield login box
		driver.findElement(By.cssSelector(PropertyTest.getORvalue("user_password_cssselector_id"))).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END,Keys.DELETE),t.readExcel(1, 1));
		
		//insert password at  Password field of login box
		driver.findElement(By.cssSelector(PropertyTest.getORvalue("username_cssselector_id"))).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END,Keys.DELETE),t.readExcel(2, 1));
		
		//click on Login button
		driver.findElement(By.cssSelector(PropertyTest.getORvalue("login_btn_cssselector_id"))).click();
		Thread.sleep(4000);
		System.out.println("login successfull");
		
	}
	


	/*
	 * @AfterClass public void closeapplication() {
	 * 
	 * driver.quit(); Reporter.log("***Browser sesson end***", true); }
	 */
}
