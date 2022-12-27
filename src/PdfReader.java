import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {

	public String readPdf(File location) throws IOException {
		 
	      PDDocument document = Loader.loadPDF(location); 
	      
	      PDFTextStripper pdfStripper = new PDFTextStripper();
	      
	      String text = pdfStripper.getText(document);
	      
	      System.out.println("------------------------------------------*********************************************************");
	      
//	      System.out.println(text);
	      
	      document.close();
	      
	      return text;
	}
	
}
