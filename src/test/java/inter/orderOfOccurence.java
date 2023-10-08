package inter;

public class orderOfOccurence {

	public static void main(String[] args) {
		String st= "vishwas";
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);//v
			int count=0;
			for (int j = 0; j < st.length(); j++) {
				char ch1 = st.charAt(j);//v
				if(ch==ch1) {
					if(j<i) {
						break;
					}
					count++;
				}
			}
			if(count>=1) {
				System.out.print(ch+""+count+" ");
			}

		}
	}

}
