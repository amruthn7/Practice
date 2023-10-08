package Java_Programs;

public class OccurencesOfString10 {

	public static void main(String[] args) {
		String s="java";
		  String st = s.toLowerCase();
		
		
		for (int i = 0; i < st.length(); i++) {
			int count=0;
			 char[] ch=st.toCharArray();
			for (int j = 0; j < ch.length; j++) {
				if(ch[i]==ch[j]) {
					if(i>j) {
						break;
					}count++;
				}
			}
			if(count>=1) {
				System.out.println(ch[i]+""+count);
			}
		}
		
	}

}
