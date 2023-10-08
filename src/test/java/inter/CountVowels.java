package inter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

public class CountVowels {

	public static void main(String[] args) {

		String str = "im feeling sleepy";
		String v="aeiouAEIOU";
		String[] st = str.split(" ");
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		for (int i = 0; i < st.length; i++) {
			for (int j = 0; j <st[i].length(); j++) {
				char cha = st[i].charAt(j);
				set.add(cha);
			}
		}
		int count=0;
		for (Character ch: set) {
			//System.out.print(ch);

			if(ch=='a' ||ch=='e' ||ch=='i' ||ch=='o' ||ch=='u') {
				count++;
			
			System.out.println(ch+" "+count);
			}
		}
		

	}
}



