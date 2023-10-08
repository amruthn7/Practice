package Java_Programs;

public class UpperAndLowerCase12 {

	public static void main(String[] args) {

		String st = "I Am From Bangalore";
		char[] ch = st.toCharArray();
		for (int i = 0; i < st.length(); i++) {
			
			if(ch[i]>='a' && ch[i]<='z') {
				ch[i]=(char)(ch[i]-32);
			}else if(ch[i]>='A' && ch[i]<='Z') {
				ch[i]=(char)(ch[i]+32);
			}
		}
		
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
		}	
	}

}
