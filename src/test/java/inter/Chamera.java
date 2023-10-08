package inter;

public class Chamera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String datee="10/05/2023"; //10-5-23
		String date = datee.replace("/", "-");
		char[] d = date.toCharArray();
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i]);
			if(d[i]=='-' && d[i+1]=='0')
				System.out.print(d[i+2]);
			if(d[i]=='-' && d[i+1]=='2') {
				System.out.print(d[i+2]);
			}
		}
	}

}
