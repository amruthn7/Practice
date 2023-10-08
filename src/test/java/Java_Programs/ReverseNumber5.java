package Java_Programs;

public class ReverseNumber5 {

	public static void main(String[] args) {
		int n=4686;
		int rev=0;
		
		while(n!=0) {
			int d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		
		System.out.println(rev);
	}

}
