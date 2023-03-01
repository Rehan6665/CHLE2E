package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;


	public ExcelUtils(String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public int getColoumnCount() {


		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Number of Rows: "+	columnCount);
		return columnCount;

	} 
	
	public int getRowCount() {


		int rowCount = sheet.getPhysicalNumberOfRows();
		//System.out.println("Number of Rows: "+	rowCount);
		return rowCount;

	} 

	public String getCellStringData(int rowNum, int colNum) {
		String stringData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();				
		//System.out.println(stringData);
		return stringData;


	}

	public double getCellNumericData(int rowNum, int colNum) {

		double numericData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println(numericData);
		return numericData;


	} 	
	
	public CellType getCellType(int rowNum, int colNum) {
		
		CellType type = sheet.getRow(rowNum).getCell(colNum).getCellType();
		return type;

		
	


	} 	
	

}

