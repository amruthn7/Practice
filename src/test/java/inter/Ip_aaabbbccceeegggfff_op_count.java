package inter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ip_aaabbbccceeegggfff_op_count {

	public static void main(String[] args) {

		String s = "aaababbccceeeggfff";
		char[] ch = s.toCharArray();
		int count=0;
		Map<Character, Integer> map= new HashMap<Character, Integer>();
		for (int i = 0; i < ch.length; i++) {
			map.put(ch[i], count);
		}
		for (Entry<Character, Integer> m : map.entrySet()) {
			count=0;
			for (int j = 0 ; j < s.length(); j++) {
				if(m.getKey() == s.charAt(j)) {
					count++;
				}
			}
			map.put(m.getKey(), count);
		}
	
//		for (int k = 0; k <ch.length ; k++) {
//			int count=0;
//			for (int i = 0; i < s.length() ; i=i+count) {
//				count=1;
//				for (int j = i+1 ; j < s.length(); j++) {
//					if(s.charAt(i) == s.charAt(j)) {
//						count++;
//					}else {
//						break;
//					}
//				}
//			}
//			map.put(ch[k], count);
//		}
		
		for ( Entry<Character, Integer> m : map.entrySet()) {
			System.out.print(m.getKey()+""+m.getValue()+" ");
		}
	}
}
