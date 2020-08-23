package reportsMobi;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import MobilePackage.LoginTest;
import MobilePackage.PropertyTest;

public class SaleRegister  {

	@Test
	public void CheckSaleData() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/arijit/Documents/LIVETEST/MobileProject/src/main/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://fr.rancelab.com/361");
		Thread.sleep(5000L);
		driver.findElement(By.xpath(PropertyTest.getORvalue("sale_icon_xpath"))).click();
		
		driver.findElement(By.xpath("//span[contains(@id,'caption' )] [contains(text(),'Sale Register')]")).click();
		
		Thread.sleep(5000L);
		DateTimeClass today=new DateTimeClass();
		String x=(String)today.currentdate();
		
		List<WebElement> z=driver.findElements(By.xpath("//*[@id='cmbReport']/table/tbody/tr/td[1]"));
		System.out.println("Today is: "+driver.findElement(By.xpath("//*[@id='cmbReport']/table/tbody/tr[3]/td[1]")).getText());
		
		for(WebElement datecell:z) {
			if(datecell.getText().equals(x)) {
				datecell.click();	
			}
			else {
				System.out.println(datecell.getText()+" -It's not today");
				
			}
		};
		Thread.sleep(4000L);
		int count=driver.findElements(By.xpath("//*[@id='cmbReport']/table/tbody/tr/td[3]")).size();
		float sum_of_qty=0;
		float sum_bill_amount=0;
		for(int i=0;i<count;i++) {
		
		String qty_in_bill=driver.findElements(By.xpath("//*[@id='cmbReport']/table/tbody/tr/td[3]/span")).get(i).getText();
		//System.out.println(qty_in_bill);
		float qty_in_bill_float=Float.parseFloat(qty_in_bill);
		//System.out.println(qty_in_bill_float);
		sum_of_qty=sum_of_qty+qty_in_bill_float;
		
		}
		
		System.out.println("The calculated value of total sold quantities: "+sum_of_qty);
		System.out.println("The total sold quantities,which is shown at sale register: "+driver.findElement(By.xpath("//*[@id='cmbReport']/table/tfoot/tr/td[3]/span")).getText());
		
		for(int j=0;j<count;j++) {
			String bill_amount=driver.findElements(By.xpath("//*[@id=\"cmbReport\"]/table/tbody/tr/td[4]/span")).get(j).getText();
			float bill_amount_float=Float.parseFloat(bill_amount);
			sum_bill_amount=sum_bill_amount+bill_amount_float;
		};
		
		System.out.println("Calculated sum of Bill amount is :"+sum_bill_amount);
		System.out.println("The Total Bill amount which is shown at report is:"+driver.findElement(By.xpath("//*[@id='cmbReport']/table/tfoot/tr/td[4]/span")).getText());
	}
}
