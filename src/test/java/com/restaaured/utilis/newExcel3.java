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
public class newExcel3
{

  static XSSFWorkbook workbook;
  static XSSFSheet sheet;
  static FileInputStream ip;

// static Cell cell1;

  public static Object[][] read(String File, String SheetName) throws IOException,NullPointerException

   {
   
ip = new FileInputStream(File);
XSSFWorkbook wb = new XSSFWorkbook(ip);
XSSFSheet sh =wb.getSheet(SheetName);
Row row1 = sh.getRow(1);

int rowCount_phy = sh.getPhysicalNumberOfRows();
System.out.print(rowCount_phy);

int rowCount=sh.getLastRowNum()-sh.getFirstRowNum();
System.out.println("RowCount"+rowCount);
   int ColCount = row1.getLastCellNum();

System.out.println("Numeric String ColCount"+ColCount);


Object [][] excelDataType = new Object[rowCount][ColCount];
Object [][] excelDataValuereturn=new Object[rowCount][ColCount];


for(int i=1;i<=rowCount;i++)

{

for(int j=0;j<ColCount;j++)

{

excelDataType[i-1][j]=sh.getRow(i).getCell(j).getCellType();
// System.out.println("3.Cell Data type"+excelDataType[i-1][j]);
// System.out.println("4.Cell return type"+excelDataValuereturn[i][j]);

                   //   System.out.println(sh.getActiveCell());

       if (excelDataType[i-1][j]==CellType.NUMERIC)
{
Double a=sh.getRow(i).getCell(j).getNumericCellValue();
//System.out.println("5.Excel numeric value of a "+a);
Math.round(a);
  // System.out.println((int)Math.round(a));
excelDataValuereturn[i-1][j]=(int)Math.round(a);




}

else if (excelDataType[i-1][j]==CellType.STRING)
{
//System.out.println("2"+sh.getActiveCell());
excelDataValuereturn[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
// System.out.println("Excel String return after picking value Value"+excelDataValuereturn[i-1][j]);
}



if (excelDataType[i-1][j]==CellType.BOOLEAN)
{

excelDataValuereturn[i-1][j]=sh.getRow(i).getCell(j).getBooleanCellValue();
// System.out.println("Excel Boolean return Value"+excelDataValuereturn[i-1][j]);
// System.out.println("The value of i is"+i);
}


}


     }


return excelDataValuereturn;
}

}