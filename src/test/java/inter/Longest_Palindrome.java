package inter;

public class Longest_Palindrome {

	public static void main(String[] args) {
		String str="asdradeedar";
	
		if(str.isEmpty()) {
			System.out.println("string in empty");
		}
		
		int n = str.length();
		int longestSoFar = 0, startIndex = 0, endIndex = 0;
		boolean[][] palindrom = new boolean[n][n];

		for(int i = 0; i< n; i++) {
			palindrom[i][i] = true;
			for(int j = 0; j < i; j++) {
				if(str.charAt(i) == str.charAt(j) && (i-j<=2 || palindrom[i-1][j+1])) {
					palindrom[i][j] = true;
					if(i-j+1 > longestSoFar) {
						longestSoFar = i-j+1;
						startIndex = j;
						endIndex = i;
					}  
				}
			}
		}
		System.out.println(str.substring(startIndex, endIndex+1));
	}
}

