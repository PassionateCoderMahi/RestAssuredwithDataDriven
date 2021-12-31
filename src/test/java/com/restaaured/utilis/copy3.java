package com.restaaured.utilis;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class copy3 {

	 //Variables
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 
	 
	 //Constructor - same as class name
	 public copy3(String excelpath, String sheetname)
	 {
	  try {
	   
	   workbook = new XSSFWorkbook(excelpath);
	   sheet = workbook.getSheet(sheetname);
	   
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
	 
	 /*
	 public static void main(String args[])
	 {
	  getRowCount();
	  getCellDataString(1,1);
	 }
	 */
	 
	 
	 public static int getRowCount()
	 { 
	  int rowCount = 0;  
	  rowCount = sheet.getPhysicalNumberOfRows();
	  //System.out.println("Number of rows : " + rowCount);   
	  return rowCount; 
	         
	 }
	 
	 public static int getColumnCount()
	 {
	  int colCount = 0; 
	  colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	  //System.out.println("Number of rows : " + colCount);
	  return colCount;
	 }
	 
	 
	/* public String getCellDataString(int rownum, int colnum)
	 { 
	  String cellData1 = "";
	  cellData1 = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
	  System.out.println("CellValue1 : " + cellData1);  
	  return cellData1;   
	 }
	 */
	 
	 
	 
	 public String getCellDataString(int rownum,int colnum) throws IOException
		{
			
			XSSFRow row=sheet.getRow(rownum);
			XSSFCell cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			//DataFormatter formatter = new DataFormatter();
			//String strValue = formatter.formatCellValue(cell);
			
			 String data="";
			try{
			
			data= formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			
			
			}
			catch(Exception e)
			{
				data="";
			}
			workbook.close();
			
			return data;
		}
	 
	 
	 
	 public static double getCellDataNumeric(int rownum, int colnum)
	 {  
	   double cellData2 = 0;
	   cellData2 = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
	   //System.out.println("CellValue2 : " + cellData2);
	   return cellData2;
	 }
	


	 
	 
	 public static Object[][] testData(String excelpath, String sheetname) throws IOException
	 {
	  
		 copy3 excel = new copy3(excelpath,sheetname);
	  
	  int rowCount = copy3.getRowCount();
	  
	  int colCount = copy3.getColumnCount();
	  
	  
	  //Create the Object
	  Object data [][] = new Object [rowCount-1] [colCount];
	  
	  for (int i=1; i<= rowCount; i++)  
	  {   
	   for (int j=0; j <= colCount; j++)
	   {
	    String cellData = excel.getCellDataString(i, j);
	    System.out.println(cellData + " | ");
	    data [i-1][j] = cellData; //Store the value in the object array
	   } 
	   
	    System.out.println();
	    
	 }
	  return data;
	 }

	
}

