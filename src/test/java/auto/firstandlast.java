package auto;

public class firstandlast {
	public static void main(String[] args) {
		String s1="hari ravi ramuji";
		String[] ch = s1.split(" ");
		for (int i = 0; i < ch.length; i++) {
			char[] c = ch[i].toCharArray();
			if(i==0 || i==ch[i].length()-1) {
				c[i]=(char) (c[i]-32);
			}
		}
		
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]+" ");
		}
	}

}
