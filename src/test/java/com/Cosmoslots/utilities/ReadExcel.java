/**
 * 
 */
package com.Cosmoslots.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author shrikrushna.sonkar
 *
 */
public class ReadExcel {

	/**
	 * 
	 */
	public ReadExcel() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

}
