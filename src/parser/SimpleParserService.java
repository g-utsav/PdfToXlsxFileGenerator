package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleParserService implements Parser{

	@Override
	public List<List<String>> parseString(String str) {
		
		str = str.trim();
		int ci = 49;
//		System.out.println(str);
		
		List<List<String>> aList = new ArrayList<>(); 
		for(int i=0; i<str.length(); i++) {
			if((int)str.charAt(i) ==  ci && str.charAt(++i) == '.' && str.charAt(i+1) == ' ') {
				i = i+2;
				ci++;
				String address = "";
				List<String> addressList = new ArrayList<String>(); 
				for(;i<str.length(); i++) {
					address += str.charAt(i);
					
					if((((int)str.charAt(i))>=48 && ((int)str.charAt(i)) < 58) && str.charAt(i+1) == '.' && (((int)str.charAt(i+2))>=48 && ((int)str.charAt(i+2)) < 58)) {
						address += str.charAt(i+1)+""+str.charAt(i+2) +" Km";
						addressList.add(address);
						address = "";
						aList.add(addressList);
						addressList = new ArrayList<String>();
						break;
					}
				}
//				System.out.println(addressList);
			}
			
		}
		
		
		return aList;
	}



}
