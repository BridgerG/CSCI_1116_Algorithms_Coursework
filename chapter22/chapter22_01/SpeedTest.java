package chapter22_01;

public class SpeedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abdfghtsaieasncmxkat";
		String current = "";
		
		while (current.length() < 100) {
			
			current += a;
		
		}
		
		MCIOS(current, 100);
		
		a = current;
		
		while (current.length() < 1000) {
			
			current += a;
		
		}
		
		MCIOS(current, 1000);
		
		a = current;
		
		while (current.length() < 10000) {
			
			current += a;
		
		}
		
		MCIOS(current, 10000);
		
		a = current;
		
		while (current.length() < 100000) {
			
			current += a;
		
		}
		
		MCIOS(current, 100000);
		
		
		a = current;
		
		while (current.length() < 1000000) {
			
			current += a;
		
		}
		
		MCIOS(current, 1000000);
		
		a = current;
		
		while (current.length() < 10000000) {
			
			current += a;
		
		}
		
		MCIOS(current, 10000000);
		
	}

	public static String MCIOS (String s, int amount) {
		
		long startTime = System.currentTimeMillis();
		
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
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Excucution time for n = " + amount + " is " + (endTime - startTime) + " milliseconds");
		return largest;
	}
}
