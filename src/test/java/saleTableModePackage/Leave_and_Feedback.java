package saleTableModePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import MobilePackage.LoginTest;
import MobilePackage.POITest;
import MobilePackage.PropertyTest;

public class Leave_and_Feedback extends LoginTest {
	@Test
	public void leavetable() throws IOException, InterruptedException {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(PropertyTest.getORvalue("sale_icon_xpath"))).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"caption\"]")).click();
		driver.findElement(By.xpath(PropertyTest.getORvalue("point_of_sale_xpath_text"))).click();
		Thread.sleep(4000);
		driver.findElement(By.id(PropertyTest.getORvalue("layout_drop_down_id"))).click();
		Thread.sleep(2000);
		
		POITest t = new POITest();
		String x = t.readExcel(5, 1);
		driver.findElement(By.xpath("//div[@class='layoutItem-titleBox' and text()='" + x + "']")).click();
		Thread.sleep(800);
		

		int y = t.INTreadExcel(6, 1);
		driver.findElement(By.xpath("//div[@class='table-titleBox' and text()='" + y + "']")).click();

		Thread.sleep(200);
		String subgroup = t.readExcel(7, 1);
		driver.findElement(By.xpath("//div[@class='product-titleBox' and text()='" + subgroup + "']")).click();
		// div[@class='product-titleBox' and text()="Pernod"]
		String productname = t.readExcel(8, 1);
		driver.findElement(By.xpath("//div[@class='product-titleBox' and text()='" + productname + "']")).click();
		
		driver.findElement(By.id(PropertyTest.getORvalue("id_select_more_btn"))).click();
		driver.findElement(By.xpath(PropertyTest.getORvalue("xpath_select_customer_btn"))).click();
		Thread.sleep(400);
		driver.findElement(By.id(PropertyTest.getORvalue("id_select_customer_name_field"))).sendKeys(t.readExcel(9, 1));
		driver.findElement(By.id(PropertyTest.getORvalue("id_select_ok_btn_search_customer"))).click();
		Thread.sleep(400);
		String customer1 = t.readExcel(10, 1);
		driver.findElement(
				By.xpath("//div[@class='list-popup-item-box']//div[@class='list-popup-item-titleBox' and  text()='"
						+ customer1 + "']"))
				.click();
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		driver.navigate().back();
	}
	
	@Test
	public void feedback() throws IOException, InterruptedException {
		driver.findElement(By.linkText("Customer Feedback Entry")).click();
		driver.findElement(By.id(PropertyTest.getORvalue("layout_drop_down_id"))).click();
		Thread.sleep(2000);
		POITest t = new POITest();
		String x = t.readExcel(5, 1);
		driver.findElement(By.xpath("//div[@class='layoutItem-titleBox' and text()='" + x + "']")).click();
		Thread.sleep(800);
		

		int y = t.INTreadExcel(6, 1);
		driver.findElement(By.xpath("//div[@class='table-titleBox' and text()='" + y + "']")).click();
	}

}
