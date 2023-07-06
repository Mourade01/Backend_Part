package com.bpm.backendpart.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {
	
	
	String path="";
	FileInputStream fis =null;
	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;
	HashMap<String,Integer> colNumbers=null;
	int rowCount=0;
	//String xlFilepath
	
	
	public Excel (String path) {
		
		try {
			
			this.path=path;
			fis = new FileInputStream(new File(this.path));
			wb =new XSSFWorkbook(fis);
			
			
			
		} catch (Exception e) {
			
			System.out.println("Exception occured nnnnnnnnnn");
			
		}
		
		
	}
	
	public void getColNumbsMap(int rowNum) {
		
		this.colNumbers=new HashMap<String,Integer>();
		Row row = sheet.getRow(rowNum);
		Iterator<Cell> cells = row.cellIterator();
		int colNumber=0;
		while(cells.hasNext()) {
			Cell cell =cells.next();
			String cellValue=cell.getStringCellValue();
			this.colNumbers.put(cellValue, colNumber);
			colNumber++;
			
		}
	}
	
	
	
	public void setSheet(int sheetNum) {
		sheet =wb.getSheetAt(sheetNum);
		getColNumbsMap(0);
		rowCount=sheet.getLastRowNum();
					
	}
	public void setSheet(String  sheetName) {
		sheet =wb.getSheet(sheetName);
		getColNumbsMap(0);
		rowCount=sheet.getLastRowNum();
					
	}
	
	
	public int getRowCount() {
		return rowCount;
	}
	
	
	
	public String getCellData(int rowNum,String colName) {
	

		String value="";                                   
	
		

		int colNum =this.colNumbers.get(colName); 
		value=getCellData(rowNum,colNum);
	
		
	
		return value;
		
	}
	
	
	
	
	public String getCellData(int rowNum,int colNum) {
		
		
		String value="";
		XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
	
		//if(cell.getCellType()==CellType.FORMULA) {
			
	
		
			//String formula =cell.getCellFormula();
			//if(formula.startsWith("INDIRECT")) {
			//	String formulaString=formula.substring(formula.indexOf("\"")+1 
				//		String[] values =formulaString.split(",");
				//for(int p=0;p<values.length;p++) {
					//System.out.println("value["+p+"] =>"+values[p]);         
					
				//}
				//value =formulaString;
				
			//}
			
		 if(cell.getCellType()==CellType.STRING){
				value=cell.getStringCellValue();
				
			}
		 
		 else if(cell.getCellType()==CellType.NUMERIC) {
			 
			 value= ""+cell.getNumericCellValue();
			 
		 }
		 
 else if(cell.getCellType()==CellType.BOOLEAN) {
			 
			 value= ""+cell;
			 
		 }
			
	
		
		
		
		 return value;
		
		
		
	}
		public void close() {
			try {
				if(wb!=null) {
					fis.close();
					wb.close();
				}
				
			}catch(Exception e) {
				
			}
			
		}
	
	

	
	
	
	

}
