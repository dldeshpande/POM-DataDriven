package com.crm.qa.UtilTest;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.testbase.TestBase;

public class UtilTest1 extends TestBase {

	public UtilTest1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static long page_load = 40;
	public static long implicit_wait = 30;
	public static String DATA_PATH_SHEET = "C://Users//admin//selenium-workspace//200//src//main//java//com//crm//qa//testdata//testdata.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	
	public static void switchToFram()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) throws Exception, IOException
	{
		FileInputStream file = null;
		 try {
			file = new  FileInputStream(DATA_PATH_SHEET);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book= WorkbookFactory.create(file);
		sheet =  book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	public static void TakeScreenshotAttheEndOfTest()
	{
		File fileSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.Dir");
		try {
			FileUtils.copyFile(fileSrc, new File(currentDir+"//screenshot//"+System.currentTimeMillis()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
