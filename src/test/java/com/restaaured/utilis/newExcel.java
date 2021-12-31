package com.restaaured.utilis;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xxsf.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.format.CellTextFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import java.lang.Math;
public class newExcel
{

  static XSSFWorkbook workbook;
  static XSSFSheet sheet;
  static FileInputStream ip;

//static Cell cell1;

  public static Object[][] read(String File, String SheetName) throws IOException

   {
   
ip = new FileInputStream(File);
XSSFWorkbook wb = new XSSFWorkbook(ip);
XSSFSheet sh =wb.getSheet(SheetName);
//XSSFRow row = sheet.getRow(0);
//XSSFCell cell_x;
Row row1 = sh.getRow(1);
Cell cell1=row1.getCell(0);
 
int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
System.out.println("RowCount"+rowCount);

int ColCount = row1.getLastCellNum();

System.out.println("ColCount"+ColCount);
//Object [][] excelDataValue = new Object[rowCount+1][ColCount];

Object [][] excelDataType = new Object[rowCount+1][ColCount];
Object [][] excelDataValuereturn=new Object[rowCount+1][ColCount];


for(int i=0;i<rowCount+1;i++)

{

for(int j=0;j<ColCount;j++)

{
System.out.println("i equal"+i);
System.out.println("Row Count"+rowCount);
System.out.println("j equal"+j);


//excelData[i-1][j]=sh.getRow(i).getCell(j).
//System.out.println(excelData[i-1][j]);
excelDataType[i][j]=sh.getRow(i).getCell(j).getCellType();
System.out.println("Cell Data type"+excelDataType[i][j]);
//DataFormatter formatter=new DataFormatter();
//String data="";

if (excelDataType[i][j]==CellType.NUMERIC)
{
Double a=sh.getRow(i).getCell(j).getNumericCellValue();
System.out.println("Excel numeric value of a "+a);
Math.round(a);
   System.out.println((int)Math.round(a));
excelDataValuereturn[i][j]=(int)Math.round(a);

System.out.println("return value after converting to string"+excelDataValuereturn[i][j]);


}

if (excelDataType[i][j]==CellType.STRING)
{
excelDataValuereturn[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
System.out.println("Excel String Value"+excelDataValuereturn[i][j]);
}



if (excelDataType[i][j]==CellType.BOOLEAN)
{
//excelDataValue[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
//System.out.println("Excel String Value"+excelDataValue[i][j]);
excelDataValuereturn[i][j]=sh.getRow(i).getCell(j).getBooleanCellValue();
System.out.println("Excel Boolean Value"+excelDataValuereturn[i][j]);
}

System.out.println("j loop ending and 1");
}
System.out.println("i loop ending and2");
     }
System.out.print("Deciding the return statement n 3");
return excelDataValuereturn;
}

}




