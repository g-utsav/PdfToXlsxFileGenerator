
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectFile {
	
	public File getAbsoluteFileLocation() {
		
		JFileChooser chooser = new JFileChooser();
		
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose PDF file.", "pdf");
	    
	    chooser.setFileFilter(filter);
	    
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	        System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
	    }
	   
	    return chooser.getSelectedFile();
		
	}
	
	public String getFolder() {
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		
		chooser.showSaveDialog(null);

        return chooser.getSelectedFile().getAbsolutePath();
	}
	
	public String setFileName(Scanner sc) {
		
		System.out.println("Enter the name of the File to Save : ");
		String s =  sc.nextLine();
		return s;
		
	}
	
}
