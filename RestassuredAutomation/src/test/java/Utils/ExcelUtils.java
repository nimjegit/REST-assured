package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String SheetName) {
		try {
		
		 workbook = new XSSFWorkbook(excelPath);
		 sheet = workbook.getSheet(SheetName);
		 
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();}
		
	}	
	
	public static void getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Total no. of rows" +rowCount);
	}

	public static void getCellValue(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
	}
	
}
