package Java_Programs;

public class HallowBox8 {

	public static void main(String[] args) {

		int n=7;
		
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <n ; j++) {
				if(i==1 || j==1 || j==n || i==n ) {
				//if(i==0|| j==0|| j==i || j==n-1 || i==n-1|| i+j==n-1) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}	
			}
			System.out.println();
		}
	}

}
