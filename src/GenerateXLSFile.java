import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GenerateXLSFile {

	public void generateSpreadSheet(String filename, List<String> rows, List<List<String>> data) {
		try   
		{  
		
		
		HSSFWorkbook workbook = new HSSFWorkbook();  
		 
		HSSFSheet sheet = workbook.createSheet("Un-Named");     
		
		HSSFRow rowhead = sheet.createRow((short)0);  

		for(int j=0; j<rows.size(); j++) {
			rowhead.createCell(j).setCellValue(rows.get(j));
		}
		
		for(int i=0; i<data.size(); i++) {
			
			HSSFRow row = sheet.createRow((short)i+1);  
			
			for(int j=0; j<rows.size(); j++) {
				if(data.get(i).size() > j) {
					row.createCell(j).setCellValue(data.get(i).get(j));					
				}else {
					row.createCell(j).setCellValue("");
				}
			}
			
		} 
		
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut);  
		 
		fileOut.close();  
		
		workbook.close();  
		
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
	}
	
	public List<String> setRows(Scanner sc) {
		
		System.out.println("Enter the number of Rows ");
		int len = sc.nextInt();
		List<String> rows  = new ArrayList<>();
		System.out.println("Enter the Name of the Rows : ");
		sc.nextLine();
		for(int i=0; i<len; i++) {
			rows.add(sc.nextLine());
		}
		
		return rows;
	}
	
}
