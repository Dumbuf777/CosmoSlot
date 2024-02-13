package com.Cosmoslots.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSXData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		  File file = new File("D://Workbook.xlsx");
		  FileInputStream inputStream = new FileInputStream(file);
		  Workbook workbook = new XSSFWorkbook(inputStream);
		  Sheet sheet = workbook.getSheetAt(0);
		  int lastRow = sheet.getLastRowNum();
		  System.out.println("Last row- "+lastRow);
		  for(int i=0; i<=lastRow; i++){
		  Row row = sheet.getRow(i);
		  int lastCell = row.getLastCellNum();
		  for(int j=0; j<lastCell; j++){
		  Cell cell = row.getCell(j);
		  String value = cell.getStringCellValue();
		  System.out.println(value);
		  }
		  System.out.println();
		  }
		  }
		  

	}


