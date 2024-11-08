package chapter22_03;

import java.util.Scanner;

public class Chapter22_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter String s1; ");
		String string1 = scan.next();
		
		System.out.print("Enter String s2; ");
		String string2 = scan.next();
		
		System.out.print("Matched at Index " + StringSubString(string1, string2));
		
	}
	
	//O(n)
	public static int StringSubString(String s1, String s2) {
		
		boolean matching = false;
		int match = 0, current = 0;
		char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
		
		for (int i = 0; i < array1.length; i++) {
			
			if(array1[i] == array2[0] && matching == false) {
				
				match = i;
				current = 1;
				matching = true;
				
			} else if (array1[i] == array2[current] && matching == true) {
				
				current++;
				
			} else {
				
				match = 0;
				current = 0;
				matching = false;
				
			}
			
			if (current == array2.length && matching == true) {
					
				return match;
			
			}
		}
		
		return 0;
		
	}

}
