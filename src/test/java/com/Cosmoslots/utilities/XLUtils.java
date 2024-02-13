package com.Cosmoslots.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
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
	
	
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow irow = null;
	public static XSSFCell icell = null;
	
	// key as a column_name and value as a index of column_name
		public static Map<String, Integer> columnAndRowMapper = new HashMap<String, Integer>();

		/**
		 * This method <code>loadExcelFile</code> is used to load the excel file.
		 *
		 * @param xlFilePath
		 * @param sheetName
		 * @throws Exception
		 */
		public static void loadExcelFile(String xlFilePath, String sheetName) throws Exception {
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			irow = sheet.getRow(0);

			// load all the column name with index in columnAndRowMapper from specific file
			if (irow != null) {
				for (int i = 0; i < irow.getLastCellNum(); i++) {
					if (!ApplicationTestUtils.isEmpty(irow.getCell(i).getStringCellValue().trim())) {
						columnAndRowMapper.put(irow.getCell(i).getStringCellValue().trim(), i);
					}
				}
			}
			fis.close();

		}

		/**
		 * This method <code>getCellData</code> is used to get the column value from
		 * specific row and column name
		 * 
		 * @param rowNum
		 * @param colName
		 * @return
		 */
		public static String getCellData(int rowNum, String colName) {
			int col_Num = -1;

			try {

				if (!ApplicationTestUtils.isEmptySheet(columnAndRowMapper.get(colName))) {
					col_Num = columnAndRowMapper.get(colName);
				}

				irow = sheet.getRow(rowNum);
				if (col_Num != -1) {
					icell = irow.getCell(col_Num);
					return icell.getStringCellValue();
				}
				return "";

//				if (cell.getCellTypeEnum() == CellType.STRING)
//					return cell.getStringCellValue();
//				else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
//					String cellValue = String.valueOf(cell.getNumericCellValue());
//					if (HSSFDateUtil.isCellDateFormatted(cell)) {
//						DateFormat df = new SimpleDateFormat("dd/MM/yy");
//						Date date = cell.getDateCellValue();
//						cellValue = df.format(date);
//					}
//					return cellValue;
//				} else if (cell.getCellTypeEnum() == CellType.BLANK)
//					return "";
//				else
//					return String.valueOf(cell.getBooleanCellValue());

			} catch (Exception e) {
				return "row " + rowNum + " or column " + col_Num + " does not exist  in Excel";
			}
		}
	
	
}
