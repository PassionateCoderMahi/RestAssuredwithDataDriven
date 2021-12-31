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


public class copy4 {
	
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

	Object [][] excelData = new Object[rowCount+1][ColCount];
	Object [][] excelDataValuereturn=new Object[rowCount+1][ColCount];
	 

	for(int i=0;i<rowCount+1;i++)

	{

	for(int j=0;j<row.getLastCellNum();j++)

	{
		
		if(((XSSFCell) excelData[i][j]).getCellType()==CellType.STRING) 
			excelDataValuereturn[i][j] = ((XSSFCell) excelData[i][j]).getStringCellValue(); 
		//break;
	    
	else if(((XSSFCell) excelData[i][j]).getCellType()==CellType.NUMERIC) 
		excelDataValuereturn[i][j] = String.valueOf(((XSSFCell) excelData[i][j]).getNumericCellValue());
		//break;

	else if(((XSSFCell) excelData[i][j]).getCellType()==CellType.BOOLEAN) 
		excelDataValuereturn[i][j] = String.valueOf(((XSSFCell) excelData[i][j]).getBooleanCellValue());
		//break;
			

	//excelData[i-1][j]=new DataFormatter().formatCellValue(sh.getRow(i).getCell(j));
	

	}

	}
  // wb.close();
	return excelDataValuereturn;

	

	}


}


//String data;


