package com.crm.autodesk.GenericLibrary;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods 
 * @author SHRUTHI
 *
 */
public class ExcelFileUtilities 
{
/**
 * This method reads data from the excel file
 * @throws Throwable 
 *  
 */
	public String getDataFromExcelFile(String sheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}
	
	public int getIntDataFromExcelFile(String sheetName,int rownum, int cellnum) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		double value = cell.getNumericCellValue();
		int number = (int)value;
		return number;
	}
}
