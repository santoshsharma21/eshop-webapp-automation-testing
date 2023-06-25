/**
 * 
 */
package com.eshop.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Santosh Sharma
 *
 */
public class ExcelUtils {
	
	public FileInputStream fileInput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public String path;
	
	public ExcelUtils(String path){
		this.path = path;
	}
	
	// returns number of rows
	public int getRowCount(String sheetname) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetname);
		int nrows = sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return nrows;
	}
	
	// return number of cells in particular row
	public int getCellCount(String sheetname, int rownum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int ncells = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return ncells;
	}
	
	// return data from excel
	public String getCellData(String sheetname, int rownum, int cellnum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		// data formater
		DataFormatter dataFormatter = new DataFormatter();
		String data;
		
		try {
			data = dataFormatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}
		return data;		
	}

}
