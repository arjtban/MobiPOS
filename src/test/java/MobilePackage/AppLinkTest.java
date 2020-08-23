package MobilePackage;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
 * Test the link element in the 'About' popup box.First link element is an email link.
 * In browser it will not work properly ,so skip that one only.  
*/

public class AppLinkTest {
	@Test
	public void linktest() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/arijit/Documents/LIVETEST/MobileProject/src/main/chromedriver");
		WebDriver driver= new ChromeDriver();
		POITest t=new POITest();
		driver.get(t.readExcel(0, 1));
		//Explicit wait (selenium 4) until the setting icon gets appeared to the page.
		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyTest.getORvalue("setting_icon"))));
		
		System.out.println(driver.findElement(By.xpath(PropertyTest.getORvalue("setting_icon"))).getText());
		driver.findElement(By.xpath(PropertyTest.getORvalue("setting_icon"))).click();
		driver.findElement(By.id(PropertyTest.getORvalue("id_About"))).click();
		
		
		//confine the webdriver to the popup section and target it to the parent DOM of all link tags

	    WebElement popupdriver=driver.findElement(By.xpath(PropertyTest.getORvalue("xpath_about_popup_window")));
		System.out.println("The no of link elements in the page:" + popupdriver.findElements(By.tagName("a")).size());
		
		for(int i = 1;i<popupdriver.findElements(By.tagName("a")).size();i++) {
			String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			popupdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(5000L);
			
			Set<String> counts=driver.getWindowHandles();
			Iterator<String> itr=counts.iterator();
			while(itr.hasNext()) {
				driver.switchTo().window((itr.next()));
				Thread.sleep(2000L);
				System.out.println("The title is:" + driver.getTitle());
				
			} 
			
			break; //break from the for loop.
			
		}
		
		driver.quit();
	}

}
