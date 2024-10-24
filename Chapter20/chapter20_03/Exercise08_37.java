package chapter20_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise08_37 {
	  
	public static void main(String[] args) {
   
		String[][] stateCapital = {
		{"Alabama", "Montgomery"},
		{"Alaska", "Juneau"},
		{"Arizona", "Phoenix"},
		{"Arkansas", "Little Rock"},
		{"California", "Sacramento"},
		{"Colorado", "Denver"},
		{"Connecticut", "Hartford"},
		{"Delaware", "Dover"},
		{"Florida", "Tallahassee"},
		{"Georgia", "Atlanta"},
		{"Hawaii", "Honolulu"},
		{"Idaho", "Boise"},
		{"Illinois", "Springfield"},
		{"Indiana", "Indianapolis"},
		{"Iowa", "Des Moines"},
		{"Kansas", "Topeka"},
		{"Kentucky", "Frankfort"},
		{"Louisiana", "Baton Rouge"},
		{"Maine", "Augusta"},
		{"Maryland", "Annapolis"},
		{"Massachusettes", "Boston"},
		{"Michigan", "Lansing"},
		{"Minnesota", "Saint Paul"},
		{"Mississippi", "Jackson"},
		{"Missouri", "Jefferson City"},
		{"Montana", "Helena"},
		{"Nebraska", "Lincoln"},
		{"Nevada", "Carson City"},
		{"New Hampshire", "Concord"},
		{"New Jersey", "Trenton"},
		{"New York", "Albany"},
		{"New Mexico", "Santa Fe"},
		{"North Carolina", "Raleigh"},
		{"North Dakota", "Bismarck"},
		{"Ohio", "Columbus"},
		{"Oklahoma", "Oklahoma City"},
		{"Oregon", "Salem"},
		{"Pennsylvania", "Harrisburg"},
		{"Rhode Island", "Providence"},
		{"South Carolina", "Columbia"},
		{"South Dakota", "Pierre"},
		{"Tennessee", "Nashville"},
		{"Texas", "Austin"},
		{"Utah", "Salt Lake City"},
		{"Vermont", "Montpelier"},
		{"Virginia", "Richmond"},
		{"Washington", "Olympia"},
		{"West Virginia", "Charleston"},
		{"Wisconsin", "Madison"},
		{"Wyoming", "Cheyenne"}
		};
		
		ArrayList<ArrayList> list = new ArrayList<>();
		
		for(int i = 0; i < stateCapital.length; i++) {
			
			ArrayList<String> a = new ArrayList<String>();
			a.add(stateCapital[i][0]);
			a.add(stateCapital[i][1]);
			list.add(a);
			
		}
		
		Collections.shuffle(list);
		
		Scanner input = new Scanner(System.in);
    
		int correctCount = 0;

		while (list.size() != 0) {
			// Prompt the user with a question
			ArrayList a = list.get(0);
			list.remove(0);
			
			System.out.print("What is the capital of " + a.get(0) + "? ");
			String capital = input.nextLine().trim().toLowerCase();
			
			if (capital.toLowerCase().equals(((String) a.get(1)).toLowerCase())) {
				System.out.println("Your answer is correct");
				correctCount++;
			} else {
				
				System.out.println("The correct answer should be " + a.get(1));
				
			}
			
		}

		System.out.println("The correct count is " + correctCount);
	}
}