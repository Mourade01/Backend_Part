package com.bpm.backendpart.services;

import java.io.File;
import java.util.HashSet;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.bpm.backendpart.entities.Excel;
import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.internal.c.a.ms.System.IO.Path;
  

@Service
public class CsvServiceImpl implements CcvService{

	
	
	
	
	@Override
	public void CompareFileCsv() throws Exception {
	
		String f1="C:\\Users\\Mourad\\Desktop\\ici\\mauritel.xlsx";
		String f2="C:\\Users\\Mourad\\Desktop\\ici\\mauritel.xlsx";
		
		Excel xl1 = new Excel(f1);
		Excel xl2 = new Excel(f2);
		
	
		
		xl1.setSheet(0);
		xl2.setSheet(0);
		
		int file1RC=xl1.getRowCount();
		int file2RC=xl2.getRowCount();
		
		
	
		if(file1RC==file2RC) {
			
			System.out.println("Row count for the two files is same");
			
		}
		else {
			
			System.out.println("Row count are diferent File1["+file1RC+"] ,File2["+file2RC+"] ");
			
			
		}
		
		if(file1RC==file2RC) {
			
			String Date_Transaction	 ="Date_Transaction";
			String Num_Client ="Num_Client";
			String status	="status";
			String TransactionID ="TransactionID";
			String Request ="Request";
			
			for(int i=1;i<=file1RC;i++) {
				
			
								
				String xl1DateTransaction= xl1.getCellData(i,Date_Transaction);
				
				String xl2DateTransaction= xl2.getCellData(i,Date_Transaction);
				
				
				

				
				String xl1NumClient= xl1.getCellData(i,Num_Client);
				String xl2NumClient= xl2.getCellData(i,Num_Client);
				
				String xl1status= xl1.getCellData(i,status );
				String xl2status= xl2.getCellData(i,status );
				
				String xl1TransactionID= xl1.getCellData(i,TransactionID);
				String xl2TransactionID= xl2.getCellData(i,TransactionID);
				
				String xl1Request= xl1.getCellData(i,Request);
				String xl2Request= xl2.getCellData(i,Request);
				
				
				
				System.out.println("balek");
				System.out.println(xl1NumClient);
				System.out.println(xl1DateTransaction);
			
				System.out.println("balek");
				
				
				
				if(xl1DateTransaction.equals(xl2DateTransaction) && 
						xl1NumClient.equals(xl2NumClient) &&
						xl1status.equals(xl2status) &&
						xl1TransactionID.equals(xl2TransactionID) &&
						xl1Request.equals(xl2Request)) {
					
					System.out.println("la ligne "+(i)+"is  matching in both excels");
					
				}
				
				else {
					System.err.println("la ligne "+(i)+"is not matching in both excels");
					
					System.out.println("------------------------------------------- ");
					System.out.println("Excel 1  rows values");
					
					System.out.println("DateTransaction :"+xl1DateTransaction);
					System.out.println("NumClient :"+xl1NumClient);
					System.out.println("status :"+xl1status);
					System.out.println("TransactionID :"+xl1TransactionID);
					System.out.println("Request :"+xl1Request);
					
					System.out.println("-------------------------------------------");
					System.out.println("Excel 2 rows values");
					
					System.out.println("DateTransaction :"+xl2DateTransaction);
					System.out.println("NumClient :"+xl2NumClient);
					System.out.println("status :"+xl2status);
					System.out.println("TransactionID :"+xl2TransactionID);
					System.out.println("Request :"+xl2Request);
					
					
				}
			
			}
			xl1.close();
			xl2.close();
			
		}
			
		}
		
		
		
}
		
		
		
		
		
	

				
				
				
