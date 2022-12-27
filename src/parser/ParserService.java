package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserService{


	public List<String> parseString(String str) {
		
		str = str.trim();
		str = str.replace("\r", " **").replace("\n", "--");
//		String[] strA = str.split("\r\n");
//		List<String>s = Arrays.asList(strA);
		System.out.println(str);
		
		System.out.println((int)'1'+" "+str.length()+" "+(int)'9');
		int ci = 49;
		
		for(int i=0; i<=str.length(); i++) {
			if((int)str.charAt(i) ==  ci && str.charAt(++i) == '.' && str.charAt(i+1) == ' ') {
				ci++;
				i = i+2;
				
				String address = "";
				List<String> addressList = new ArrayList<String>(); 
				
				while(i < str.length()) {
					
					if(str.charAt(i) == 'P' && str.charAt(i+1) == 'h' && str.charAt(i+2) == 'o' && str.charAt(i+3) == 'n' && str.charAt(i+4) == 'e') {
						addressList.add(address);
						address = "";
						
						i = i+7;
						
						String phone = "";
						
						while(i < str.length()) {
							if((((int)str.charAt(i))>=48 && ((int)str.charAt(i)) < 58) && str.charAt(i+1) == '.' && (((int)str.charAt(i+2))>=48 && ((int)str.charAt(i+2)) < 58)) {
								addressList.add(phone);
								phone = "";
								phone += str.charAt(i) +""+str.charAt(i+1)+""+str.charAt(i+2);
								addressList.add(phone);
								phone = "";
								break;
							}else if(((int)str.charAt(i))>= 48 && ((int)str.charAt(i)) < 58) {
								phone += str.charAt(i);
							}else if(str.charAt(i) == ',' && str.charAt(i+1) == ' ' && (((int)str.charAt(i+2))>=48 && ((int)str.charAt(i+2)) < 58)) {
								addressList.add(phone);
								phone = "";
								i = i+2;
								while(i < str.length()) {
									if((((int)str.charAt(i))>=48 && ((int)str.charAt(i)) < 58) && str.charAt(i+1) == '.' && (((int)str.charAt(i+2))>=48 && ((int)str.charAt(i+2)) < 58)) {
										addressList.add(phone);
										phone = "";
										phone += str.charAt(i) +""+str.charAt(i+1)+""+str.charAt(i+2);
										addressList.add(phone);
										phone = "";
										break;
									}else if(((int)str.charAt(i))>=48 && ((int)str.charAt(i)) < 58) {
										phone += str.charAt(i);
									}
									i++;
								}
							} 
							i++;
						}
						
					}else {
						
						address += str.charAt(i++);
						
					}
					
				}
				System.out.println(addressList);
				
			}else {
				i++;
			}
			if(ci == 57) {
				ci = 49;
			}
		}
		
		
		
		
//		for(int i=0; i<strA.length ; i++) {
//			if(!strA[i].equals(" ")) {
//				
//				System.out.println(strA[i]+"******-----*********" +strA.length);
//				
//				
//			}else {
//				System.out.println(" */////-* ");
//			}
//		}
		return null;
	}

	
	
}
