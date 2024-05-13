package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum ,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/testscript1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String	data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		System.out.println(data);
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/testscript1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount =wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum ,int cellNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testdata/testscript1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./testdata/testscript1.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
