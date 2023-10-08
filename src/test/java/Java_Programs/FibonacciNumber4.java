package Java_Programs;

public class FibonacciNumber4 {

	public static void main(String[] args) {
		int n=10;
		
		int fib1=0,fib2=1,fib3;
		System.out.print(fib1+" "+fib2);
		
		for (int i = 0; i <=n; i++) {
			fib3=fib1+fib2;
			System.out.print(" "+fib3+" ");
			fib2=fib3;
			fib1=fib2;
		}
	}

}
