package m26_demo_DataDrivenTesting;
//1.Create Excel file-->2 columns-->UserName, Password
//2.Enter Data--> Add few data for UserName and Password
//3.Write Data--> Add new column status-->Add data pass/fail
//4.Read Data from Excel--> Display on Console

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class M26_Demo2_ReadWriteDataExcelFile 
{ 
  FileOutputStream fileWrite;
  FileInputStream fileRead;
  XSSFWorkbook workbook;
  XSSFSheet sheet;

  
  @Test
  public void ReadDataExcelFile() throws IOException
  {
	fileRead=new FileInputStream(new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Documents"
				+ "\\DataDrivenTesting\\DDTDemo2.xlsx")); 
	workbook=new XSSFWorkbook(fileRead);
	sheet=workbook.getSheet("Credentials");
	
	int rowCount=sheet.getLastRowNum();
	//System.out.println("rowCount: "+rowCount+" columnCount: "+columnCount);
	
	for(int i=1;i<=rowCount;i++)
	{
	  String userName=sheet.getRow(i).getCell(0).getStringCellValue();
	  String password=sheet.getRow(i).getCell(1).getStringCellValue();
	  System.out.println(userName+"----"+password);
	}
	
	sheet.getRow(0).createCell(2).setCellValue("Status");
	sheet.getRow(1).createCell(2).setCellValue("pass");
	sheet.getRow(2).createCell(2).setCellValue("pass");
	sheet.getRow(3).createCell(2).setCellValue("fail");
	sheet.getRow(4).createCell(2).setCellValue("pass");
	sheet.getRow(5).createCell(2).setCellValue("fail");
	
    fileWrite=new FileOutputStream(new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Documents"
			+ "\\DataDrivenTesting\\DDTDemo2.xlsx"));
	workbook.write(fileWrite);
	workbook.close();
	fileWrite.close();
	
  }


}
