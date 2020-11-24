/*
ID: abandar1
LANG: JAVA
TASK: gift1
 */

import java.io.*;
import java.util.*;

public class gift1 {
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner(new File("gift1.in"));
		final int numPeople = sc.nextInt();
		String[] names = new String[numPeople];

		Map<String, Integer> money = new HashMap<String, Integer>();
		
		for (int i = 0; i < numPeople; i++) {
			names[i] = sc.next();
			money.put(names[i], 0); // balance of each person is initialized to 0
		}		
		
		for (int i = 0; i < numPeople; i++) {
			String giverName = sc.next(); 
			int moneyAmount = sc.nextInt();
			
			int receivers = sc.nextInt(); // number of gift receivers
			for (int j=0; j<receivers; j++){
				// add money to the receivers account
				String name = sc.next();
				int balanceNow = money.get(name);
				money.put(name, moneyAmount / receivers + balanceNow);
			}
			
			// take money away from the giver
			int giverBalance = money.get(giverName);
			if (receivers > 0) {
				if (moneyAmount % receivers != 0) {
					money.put(giverName,giverBalance - (moneyAmount / receivers * receivers)); 
                } else {
					money.put(giverName, giverBalance - moneyAmount);
                }
            }
		}
		PrintStream out = new PrintStream("gift1.out");
		for (String name : names) {
		    System.out.println(name + " " + money.get(name));
			out.println(name + " " + money.get(name));
		}
		
		out.close();
		sc.close();
	}
}
