package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtils_Admin 

{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	@DataProvider(name="companyLogin")
	public Object[][] getData(Method m) throws IOException {

		File src=new File("C:\\Users\\karth\\eclipse-workspace\\JomboneTest\\src\\test\\java\\com\\testData\\CA_LoginData.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(4);
		
		
		// how many total rows in my excel sheet
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total Row Count: " +rowCount);
		
		int rows = rowCount + 1;
		System.out.println("Total No Of Rows: "+rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cell count: "+cellCount);

		String data[][] = new String [rowCount][cellCount];

		
		for(int i=1; i<rowCount+1; i++) {
				Row r=sheet.getRow(i);
				
			for(int j=0; j<cellCount; j++) {
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			
					
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
			return data;
		
		}
	
	
	/*public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	

	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	

	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	*/
}
