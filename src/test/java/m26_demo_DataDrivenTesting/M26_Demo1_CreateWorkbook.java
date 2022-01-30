package m26_demo_DataDrivenTesting;
//1.Apache POI-->MAven Dependencies-->poi & poi ooxml-->pom.xml
//2.create new Workbook and WorkSheet

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class M26_Demo1_CreateWorkbook 
{ 
  FileOutputStream fileWrite;
  XSSFWorkbook workbook;
  XSSFSheet sheet;
  @Test
  public void newWorkbook() throws IOException
  {
	fileWrite=new FileOutputStream(new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Documents\\"
			+ "DataDrivenTesting\\DDTDemo1.xlsx"));
	//C:\Users\Training1.WIN-NFDCINOH1RK\Documents\DataDrivenTesting\DataDrivenTesting.xlsx
	workbook=new XSSFWorkbook();
	sheet=workbook.createSheet("credentials");
	
	//sheet=workbook.getSheet("TestData");
	//sheet.getRow(0).getCell(0).setCellValueImpl(13);
	
	workbook.write(fileWrite);
	workbook.close();
	fileWrite.close();
  }
 
}
