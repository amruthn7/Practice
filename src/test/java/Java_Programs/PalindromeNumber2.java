package Java_Programs;

public class PalindromeNumber2 {

	public static void main(String[] args) {

		int n=12321;
		int temp = n;
		int rev=0;

		while(n!=0) {
			int d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		if(temp==rev) {
			System.out.println("Given number is palindrome");
		}else {
			System.out.println("Given number is not palindrome");
		}
	}

}
