package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Eccel3 {

	@Test
	public void demo() throws IOException
	{
		String path = "C:\\Users\\Rahul Patekar\\Downloads\\Book 6.xlsx";
		
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet = wb.getSheetAt(0);
		 int rowcount = sheet.getPhysicalNumberOfRows();
		 XSSFRow row = sheet.getRow(0);
		 int columncount = row.getLastCellNum();
	
		
		Object data[][] = new Object[rowcount][columncount];
		
		
		 
		for(int i=0;i<rowcount;i++)
		{
			
		
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				System.out.println( row.getCell(j));
			}
		}
	}


}
