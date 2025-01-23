package com.ohrm.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {
//static we can directly call it using classname, without creating object
public static Object[][] getData(String FilePath, String Usersheet) throws IOException {
	   //file name
	
	
		XSSFWorkbook wb= new XSSFWorkbook(FilePath);
		XSSFSheet sheet= wb.getSheet(Usersheet);  //sheet name
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();  //getPhysicalNumberOfRows will give rows where data entry is there
		int colCount = sheet.getRow(0).getLastCellNum(); 
		
		Object[][] data= new Object[rowCount][colCount];
		
		for(int row= 0; row<rowCount; row++) {
			for(int col=0; col<colCount; col++) {
			  data[row][col] = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		}
		return data;
		
	} 

}

