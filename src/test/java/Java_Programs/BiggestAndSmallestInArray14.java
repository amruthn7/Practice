package Java_Programs;

public class BiggestAndSmallestInArray14 {

	public static void main(String[] args) {
		
		int[] ar= {5,8,6,5,7,1};
		
		int min=ar[0], max=ar[0];
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]<min) {
				min=ar[i];
			}else if(ar[i]>max) {
				max=ar[i];
			}
		}
		
		System.out.println("Biggest element: "+max);
		System.out.println("Smallest element: "+min);
	}

}
