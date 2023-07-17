package excel;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Excel1 {

	
	

		DataFormatter formatter = new DataFormatter();

		XSSFWorkbook wb;

		@Test(dataProvider="getData")

		public void getExcel(String Testcases, String Communication, String id) {

		System.out.println(Testcases+Communication+id);

		}

		@DataProvider

		public Object[][] getData() throws IOException  {

		       // String filePath = System.getProperty("user.dir")+"/excel/Demoexcel.xlsx";
			String filePath = System.getProperty("C:\\Users\\Rahul Patekar\\Downloads\\Book 8.xlsx");

		    FileInputStream fis = new FileInputStream(filePath);

		     wb = new XSSFWorkbook(fis);

		    XSSFSheet sheet = wb.getSheetAt(0);

		    int rowCount = sheet.getPhysicalNumberOfRows();

		    XSSFRow row = sheet.getRow(0);

		    int columnCount = row.getLastCellNum();

		   

		    Object data[][] = new Object[rowCount-1][columnCount];

		   

		    for(int i=0; i<rowCount-1; i++)

		    {

		       row = sheet.getRow(i+1);

		       for(int j=0; j<columnCount; j++)

		       {

		           XSSFCell cell = row.getCell(j);

		           //System.out.println(row.getCell(j));

		           //data[i][j]= row.getCell(j)

		           data[i][j]= formatter.formatCellValue(cell);

		       }

		    }

		    return data;



		

		}
	

}
