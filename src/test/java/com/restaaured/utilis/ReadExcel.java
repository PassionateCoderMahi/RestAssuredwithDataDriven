package com.restaaured.utilis;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 static FileInputStream ip;
	
	public static Object[][] read(String File, String SheetName) throws IOException

	{

	ip = new FileInputStream(File);
	XSSFWorkbook wb = new XSSFWorkbook(ip);
	XSSFSheet sh =wb.getSheet(SheetName);


	Row row = sh.getRow(1);

	int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	System.out.println("Total Row" + rowCount);

	int ColCount = row.getLastCellNum();

	Object [][] excelData = new Object[rowCount][ColCount];

	 

	for(int i=1;i<=rowCount;i++)

	{

	for(int j=0;j<row.getLastCellNum();j++)

	{

	excelData[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();  

	}

	}

	return excelData;

	 

	}

	


}
