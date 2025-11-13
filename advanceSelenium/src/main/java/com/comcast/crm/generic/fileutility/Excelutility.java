				package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excelutility {
public String getStringDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException {
		
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).toString();
		wb.close();
		return data;

	}
	
	
	
	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.close();
		boolean data = wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		wb.close();
		return data;
	}
	
	
	public double getNumberDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);	
		double data = wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		wb.close();
		return data;

	}
	
	public LocalDateTime getDateAndTimeFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		LocalDateTime data = wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
		wb.close();
        return data;
		
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);	
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
     	return rowCount;
				
	}
	
	public void setDataIntoExcel(String sheetName, int rowIndex, int colIndex,String data) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet(sheetName);

	
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			cell = row.createCell(colIndex);
		}
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./TestData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	public int getCellCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int cellCount = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		wb.close();
		return cellCount;

	}

}
