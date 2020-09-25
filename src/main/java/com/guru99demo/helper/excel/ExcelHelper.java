		package com.guru99demo.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.resource.ResourceHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		
		/**
		 * Using for loop
		 */
		FileInputStream file = null;
		DataFormatter formatter = new DataFormatter();
		
		try{
			// 2D array not initialized
			Object dataSets[][] = null;
			
			file = new FileInputStream(excelLocation);
			
			Workbook book = WorkbookFactory.create(file);
			
			Sheet sheet = book.getSheet(sheetName);
			
			// get the active row counts in the excel sheet
			int getRow = sheet.getLastRowNum();
			
			// get the active columns in row
			int getColumn = sheet.getRow(0).getLastCellNum();
			
			dataSets = new Object[getRow][getColumn];
			
			log.info("number of active rows are: "+getRow+"----"+
					"number of active columns in row: " +getColumn);
			
					for (int i = 0; i < getRow; i++) {
						for (int k = 0; k < getColumn; k++) {
					/*		switch(sheet.getRow(i+1).getCell(k).getCellTypeEnum()){
							case STRING:
								dataSets[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();	
								break;
							case NUMERIC:
								dataSets[i][k] = sheet.getRow(i + 1).getCell(k).getNumericCellValue();
								break;
							case BOOLEAN:
								dataSets[i][k] = sheet.getRow(i + 1).getCell(k).getBooleanCellValue();
								break;
							case FORMULA:
								dataSets[i][k] = sheet.getRow(i + 1).getCell(k).getCellFormula();
								break;
							default:
								System.out.println("no matching enum data type found");
								break;	
							}*/
							
							dataSets[i][k] = formatter.formatCellValue(sheet.getRow(i+1).getCell(k));											
						}
					}		
					return dataSets;					
		}catch(Exception e){
			e.printStackTrace();		
		}
		return null;
		
			
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		/**
		 * Using Iterator
		 */
		
		/*try {
			// 2D array not initialized
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));

			// create a workbook object/instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// get the sheet name from from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// get the active row counts in the excel sheet
			int getRow = sheet.getLastRowNum();

			// get the active columns in row
			int getColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[getRow][getColumn];

			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();

					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i][j] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i][j] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i][j] = cell.getCellFormula();
						break;
					default:
						System.out.println("no matching enum data type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		*/			
	}
	
	
	
		
	/*public static void main(String[]args){
		ExcelHelper excelhelper = new ExcelHelper();
		String Excel_Location = ResourceHelper.getResourcePath("resources/configFile/TestData.xlsx");
		System.out.println(Excel_Location);
		Object data = excelhelper.getExcelData(Excel_Location, "LoginDetails");
		System.out.println(data);		
	}*/
}
