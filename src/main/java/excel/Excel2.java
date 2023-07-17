package excel;

import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel2 {
	
	DataFormatter df = new DataFormatter();
	@Test(dataProvider="Datadriven") 
	public void TestCase(String Test1, String Test2, String Test3) throws Exception
	{
		
		System.out.println(Test3+Test1+Test2);
	}

	@DataProvider(name="Datadriven")
	public Object[][] getdata() throws IOException {
		
		String path = "C:\\Users\\Rahul Patekar\\OneDrive - Clarion Technologies\\Desktop\\DemoData.xlsx";
		
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
				XSSFCell cell = row.getCell(j);
						
				data[i][j] =df.formatCellValue(cell);
			}
		}
		
		return data;

	}

}
