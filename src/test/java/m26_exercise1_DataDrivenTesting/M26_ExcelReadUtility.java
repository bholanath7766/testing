package m26_exercise1_DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class M26_ExcelReadUtility 
{ 
  public static FileInputStream fileRead;
  public static XSSFWorkbook workbook;
  public static XSSFSheet sheet;
  public static DataFormatter formatter=new DataFormatter();
  //public static XSSFRow row;
  //public static XSSFCell cell;
  
  @Test
  public static Object[][] readData(String filePath,String sheetName) throws IOException 
  {
	fileRead=new FileInputStream(new File(filePath));
	workbook=new XSSFWorkbook(fileRead);
	sheet=workbook.getSheet(sheetName);
	
	int rowCount1=sheet.getLastRowNum();//(if last row 6 then count=5)
	//int rowCount=sheet.getPhysicalNumberOfRows();//((if last row 6 then count=6)
	//In actual both rows amd cell index start from 0
	int columnCount=sheet.getRow(0).getLastCellNum();//(if last cell 2 then count=2)
	
	//Object[][] testData=new Object[rowCount-1][columnCount] ;
	Object[][] testData=new Object[rowCount1][columnCount] ;
	
	//for(int i=0;i<rowCount-1;i++)
	for(int i=0;i<rowCount1;i++)  //4
	{
	  XSSFRow row=sheet.getRow(i+1);
	  for(int j=0;j<columnCount;j++)
	  {
		XSSFCell cell=row.getCell(j);

		if(cell==null)
		{
		  testData[i][j]="";
		}
		else
		  testData[i][j]=formatter.formatCellValue(cell);
	  }
	}
	
	workbook.close();

	return testData;
	
  }
}
/*package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_ReadData 
{
  public static XSSFWorkbook workbook;
  public static XSSFSheet sheet;
  public static DataFormatter formatter=new DataFormatter();

  public static Object[][] readExcelData(String filePath,String sheetName) throws IOException
  {
	 FileInputStream excelInput=new FileInputStream(new File(filePath));
	 workbook=new XSSFWorkbook(excelInput);
	 sheet=workbook.getSheet(sheetName);
	 
	 int rowCount=sheet.getPhysicalNumberOfRows();
	 int columnCount=sheet.getRow(0).getLastCellNum();
	 
	 Object[][] testData=new Object[rowCount-1][columnCount];
	 
	 for(int i=0;i<rowCount-1;i++)
	 {
	   XSSFRow row=sheet.getRow(i+1);
	   for(int j=0;j<columnCount;j++)
	   {
	     XSSFCell cell=row.getCell(j);
	     if (cell==null)
	    	 testData[i][j]="";
	     else
	    	 testData[i][j]=formatter.formatCellValue(cell); 
	   }
	 }
	 
	workbook.close();
	return testData;
	 
  }

}
*/
