package Java_Programs;


public class ReverseTheSentence11 {

	public static void main(String[] args) {
		
		String st = "i am from bangalore";
		String[] str = st.split(" ");
		
		for (int i = str.length-1; i >=0 ; i--) {
			System.out.print(str[i]+" ");
		}
	}

}
