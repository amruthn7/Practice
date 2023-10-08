package inter;


public class ArmStrongNumber {

	public static void main(String[] args) {
		int num=153;
		int temp=num;
		int sum=0;
		int count = countDigit(num);
		
		while(num!=0) {
		int d = num%10;
		sum=sum+power(d, count);
		num=num/10;
		}
		
		if(sum==temp) {
			System.out.println("Armstrong number");
		}else {
			System.out.println("not armstrong number");
		}
	}
	
	public static int power(int n, int p) {
		int pow=1;
		for (int i = 1; i <=p; i++) {
			 pow=pow*n;
		}
		return pow;
	}
	
	public static int countDigit(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=n/10;
		}
		return count;	
	}
}
