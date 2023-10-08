package auto;

import java.util.Map.Entry;
import java.util.*;

public class Demo {
	static int fact=1;
	public static void main(String[] args) {
		int n=5;
		int data = recurrsion(n);
		System.out.println(data);
	}

	public static int  recurrsion(int i) {
		if(i!=0) {
			fact=fact*i;
			i--;
			recurrsion(i);
		}
		return fact;
	}

}
