package chapter22_01;

import java.util.Scanner;

public class Chapter22_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String a = scan.next();
		
		System.out.print("Maximum Consecutive Substring is " + MCIOS(a));
		
		
		

	}

    /**Time complexity
     * T(n) = c + 3c * n
     * T(n) = 0(n)
     * 
     * Answer: 0(n)
     * 
     */
	public static String MCIOS (String s) {
				
		char c[] = s.toCharArray();
		
		char current = c[0];
		String largest = "", storage = Character.toString(current);
		Boolean skip = false;
		
		for(int i = 1; c.length > i; i++) {
			
			if(current < c[i]) {
				
				storage += c[i];				
				
			} else {
				
				skip = true;
				
			}
			
			if (storage.toCharArray().length > largest.toCharArray().length) {
				
				largest = storage;

				
			} else if (skip) {
				
				storage = Character.toString(c[i]);
				skip = false;

			}
			
			current = c[i];
			
		}
				
		return largest;
	}
}
