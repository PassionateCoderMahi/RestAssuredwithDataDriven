package com.restaaured.utilis;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcelcopy2 {

	 //Variables
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 
	 
	 //Constructor - same as class name
	 public ReadExcelcopy2(String excelpath, String sheetname)
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
	 
	 
	 public String getCellDataString(int rownum, int colnum)
	 { 
	  String cellData1 = "";
	  cellData1 = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
	  System.out.println("CellValue1 : " + cellData1);  
	  return cellData1;   
	 }
	 
	 
	 public static double getCellDataNumeric(int rownum, int colnum)
	 {  
	   double cellData2 = 0;
	   cellData2 = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
	   //System.out.println("CellValue2 : " + cellData2);
	   return cellData2;
	 }
	


	 
	 
	 public static Object[][] testData(String excelpath, String sheetname)
	 {
	  
		 ReadExcelcopy2 excel = new ReadExcelcopy2(excelpath,sheetname);
	  
	  int rowCount = ReadExcelcopy2.getRowCount();
	  
	  int colCount = ReadExcelcopy2.getColumnCount();
	  
	  
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

