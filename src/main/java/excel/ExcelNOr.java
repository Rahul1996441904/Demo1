package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelNOr {
	
	public static void main(String [] args) throws IOException
	{
		String path = "C:\\Users\\Rahul Patekar\\Downloads\\Book 10.xlsx";
		
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet = wb.getSheetAt(0);

		 int rowcount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columncount = row.getLastCellNum();
		
		Object data[][] = new Object[rowcount-1][columncount];
		 
		
		for(int i=0;i<rowcount-1;i++)
		{
			row=sheet.getRow(i+1);
			
			for(int j=0;j<columncount;j++)
			{
				data[i][j] =row.getCell(j);
				System.out.println(row.getCell(j));
			}
		
		}
		
	
	}

}
