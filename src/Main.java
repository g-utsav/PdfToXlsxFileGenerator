import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import parser.Parser;
import parser.ParserService;
import parser.SimpleParserService;

public class Main {

	public static void start(Parser parserUserDefined) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			SelectFile selectAPdfFile = new SelectFile();
				
			File location = selectAPdfFile.getAbsoluteFileLocation();
			
			PdfReader pdfReader = new PdfReader();
		
			String pdfText = pdfReader.readPdf(location);
			
			Parser parser= new SimpleParserService();
			
			if(parserUserDefined != null) {
				 parser = parserUserDefined;
				
			}
			GenerateXLSFile generate = new GenerateXLSFile();
			
			List<String> rows = generate.setRows(sc);
			
			List<List<String>> addressList = parser.parseString(pdfText);
			
//			System.out.println(addressList);
			
			String documentAddress = selectAPdfFile.getFolder();
			
			documentAddress += "\\"+selectAPdfFile.setFileName(sc)+".xlsx";
			
			
			generate.generateSpreadSheet( documentAddress, rows, addressList );
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
		
	}
}
