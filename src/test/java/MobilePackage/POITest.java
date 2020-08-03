package MobilePackage;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;*/
import org.testng.annotations.Test;

public class POITest {
	@Test
	public String readExcel(int row,int col) throws IOException {
		File f1=new File("/home/arijit/Documents/LIVETEST/MobileProject/src/test/poidata.xlsx");
		FileInputStream fis=new FileInputStream(f1);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheetAt(0);
		XSSFRow rw=st.getRow(row);
		XSSFCell cel=rw.getCell(col);
		String data=cel.getStringCellValue();
		wb.close();
		return data;
	}
	
	@Test
	public int  INTreadExcel(int row,int col) throws IOException {
		File f1=new File("/home/arijit/Documents/LIVETEST/MobileProject/src/test/poidata.xlsx");
		FileInputStream fis=new FileInputStream(f1);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheetAt(0);
		XSSFRow rw=st.getRow(row);
		XSSFCell cel=rw.getCell(col);
		int data1=(int) cel.getNumericCellValue();
		wb.close();
		return data1;
	}
	
	@Test
	public int getrowcount() throws IOException {
		
		File f2=new File("/home/arijit/Documents/LIVETEST/MobileProject/src/test/poidata.xls");
		FileInputStream fis1=new FileInputStream(f2);
		Workbook wb1=new XSSFWorkbook(fis1);
		Sheet st= wb1.getSheetAt(0);
		int rowcount=st.getLastRowNum()-st.getFirstRowNum();
		wb1.close();
		return rowcount;
	}

}
