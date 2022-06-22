package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtils 

{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	/*@DataProvider(name="dataValue")
	public Object[][] passdata(){
		//create 2D array name data with 3 rows and 2 column
		Object[][] data = new Object[2][3];
		//we have input data 	
		data[0][0]="@bcdefg";
		data[0][1]="@bcdefg";
		data[0][2]="@bcdefg";
		
		data[1][0]="@bcdefg";
		data[1][1]="@bcdefgh";	
		data[1][2]="@bcdefgh";
		
		for(int i=0;i<data.length;i++) {
			
			for(int j=0;j<data[i].length;i++) {
                System.out.print(data[i][j] + "\t");

			}
            System.out.println("");

		}
		
		return data;
		
	}	*/
	
	@DataProvider(name="ChangePwdData")
	public Object[][] getchangePwdData(Method m) throws IOException {

		File src=new File("C:\\Users\\karth\\eclipse-workspace\\JomboneTest\\src\\test\\java\\com\\testData\\CA_LoginData.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(5);
		
		
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

				data[i-1][j]=r.getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			
				
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
		
		
			return data;
		
		}
	

	
	@DataProvider(name="InvalidPassword")
	public Object[][] getData(Method m) throws IOException {

		File src=new File("C:\\Users\\karth\\eclipse-workspace\\JomboneTest\\src\\test\\java\\com\\testData\\CA_LoginData.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(0);
		
		
		// how many total rows in my excel sheet
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total Row Count: " +rowCount);
		
		int rows = rowCount + 1;
		System.out.println("Total No Of Rows: "+rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cell count: "+cellCount);

		String data[][] = new String [rowCount][cellCount];
		for(int i=1; i<rowCount+1; i++) {
		try{
				Row r=sheet.getRow(i);
				
			for(int j=0; j<cellCount; j++) {
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (r.getCell(j)!= null) {

				data[i-1][j]=r.getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			
				else {
					System.out.println("Null value detected in the cell");
				}
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
		}catch(NullPointerException NPE) {
				System.out.println("Null Value");
			}
		}
			return data;
		
		}
	
	@DataProvider(name="InvalidEmail")
	public Object[][] invalidEmail(Method m) throws IOException {

		File src=new File("C:\\Users\\karth\\eclipse-workspace\\JomboneTest\\src\\test\\java\\com\\testData\\CA_LoginData.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(2);
		
		
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

				data[i-1][j]=r.getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			
				
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
		
		
			return data;
		
		}
	
	@DataProvider(name="InvalidEmailPassword")
	public Object[][] getData2(Method m) throws IOException {

		File src=new File("C:\\Users\\karth\\eclipse-workspace\\JomboneTest\\src\\test\\java\\com\\testData\\CA_LoginData.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(3);
		
		
		// how many total rows in my excel sheet
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total Row Count: " +rowCount);
		
		int rows = rowCount + 1;
		System.out.println("Total No Of Rows: "+rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cell count: "+cellCount);

		String data[][] = new String [rowCount][cellCount];
		for(int i=1; i<rowCount+1; i++) {
		try{
				Row r=sheet.getRow(i);
				
			for(int j=0; j<cellCount; j++) {
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (r.getCell(j)!= null) {

				data[i-1][j]=r.getCell(j).getStringCellValue();
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			
				else {
					System.out.println("Null value detected in the cell");
				}
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
		}catch(NullPointerException NPE) {
				System.out.println("Null Value");
			}
		}
			return data;
		
		}
	
	
	@DataProvider(name="companyLogin")
	public Object[][] compLogin(Method m) throws IOException {

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
				
				//Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			}
			
		}
			return data;
		
		}

	
	
}
