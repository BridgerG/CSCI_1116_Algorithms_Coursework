package chapter21_07;

public class WordOccurrence implements Comparable<WordOccurrence>{

	String key = null;
	int value = 0;
	
	WordOccurrence() {
		
	}
	
	WordOccurrence (String key, int value) {
		
		this.key = key;
		this.value = value;
		
	}
	
	public String getKey() {
		
		return key;
		
	}
	
	public int getValue() {
		
		return value;
	}
	
	public void setValue(int value) {
		
		this.value = value;
	}

	@Override
	public int compareTo(WordOccurrence o) {

		if (getValue() > o.getValue()) {
			
			return 1;
			
		} else if (getValue() < o.getValue()) {
			
			return -1;
			
		} else {
			
			return 0;
			
		}
	}

	
}
