package com.restaaured.utilis;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class newExcel2 {
	
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


	int ColCount = row.getLastCellNum();
	
	System.out.println("Total Row" + rowCount);

	Object [][] excelData = new Object[rowCount][ColCount];
	 

	for(int i=1;i<=rowCount;i++)

	{

	for(int j=0;j<row.getLastCellNum();j++)

	{
		
			

	excelData[i-1][j]=new DataFormatter().formatCellValue(sh.getRow(i).getCell(j));
	

	}

	}
  // wb.close();
	return excelData;

	

	}


}


/*String data;

if(((XSSFCell) excelData[i][j]).getCellType()==CellType.STRING) 
    data = ((XSSFCell) excelData[i][j]).getStringCellValue(); 
    
else if(((XSSFCell) excelData[i][j]).getCellType()==CellType.NUMERIC) 
    data = String.valueOf(((XSSFCell) excelData[i][j]).getNumericCellValue());

else if(((XSSFCell) excelData[i][j]).getCellType()==CellType.BOOLEAN) 
	 data = String.valueOf(((XSSFCell) excelData[i][j]).getBooleanCellValue());*/
