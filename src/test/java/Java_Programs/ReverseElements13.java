package Java_Programs;

import java.util.Iterator;

public class ReverseElements13 {

	public static void main(String[] args) {

		String[] str= {"java", "Api", "selenium", "Appium"};
		
		for (int i = 0; i < str.length; i++) {
			char[] ch = str[i].toCharArray();
			String rev="";
			for (int j = 0; j < ch.length; j++) {
				rev=str[i].charAt(j)+rev;
			}
			str[i]=rev;
		}
		
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+" ");
		}
	}

}
