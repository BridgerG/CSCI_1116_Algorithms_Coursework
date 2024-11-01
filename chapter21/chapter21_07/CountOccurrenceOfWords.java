package chapter21_07;

import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		WordOccurrence[] map2 = new WordOccurrence [40];
		int a = 0;

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, a);
					map2[a] = new WordOccurrence(key, 1);
					a++;
					
				}
				else {
					int value = map.get(key);
					map2[value].setValue(map2[value].getValue() + 1);
					
				}
			}
		}
		
		WordOccurrence[] tbp = new WordOccurrence [map.size()];
		
		for (int i = 0; i < tbp.length; i++) {
			
			tbp[i] = map2[i];
			
		}
		
		int  num = 0;
		
		for (int i = 0; i < tbp.length; i++) {
			
			boolean change = false;
			num = i;
			WordOccurrence current = map2[i];

			for (int w = i; w < tbp.length - 1; w++) {
				
				if(current.compareTo(map2[w]) == 1) {
					
					
				} else if (current.compareTo(map2[w]) == -1) {
					
					current = (map2[w]);
					num = w;
					change = true;
					
				}
				
			}
			
			if (change == false) {
				
				tbp[i] = map2[i];
				
			} else {
			
				tbp[i] = current;
				current = map2[i];
				map2[i] = map2[num];
				map2[num] = current;
			
			}
			
		}
		

		

		for(int i = 0; i < tbp.length; i++) {
			
			System.out.println(tbp[i].getKey() + "\t" + tbp[i].getValue());
		}
		// Display key and value for each entry
		//map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
}

