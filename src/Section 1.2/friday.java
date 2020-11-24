/*
 ID: abandar1
 LANG: JAVA
 PROB: friday
 */

import java.util.*;
import java.io.*;

public class friday {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("friday.in"));
		int yrs = sc.nextInt(); //get N (number of years) from the file
		sc.close();
		
		int d=2; //day of the week
		// initialized to Monday, January 1st, 1900
		int[] result = {0,0,0,0,0,0,0};
		for (int year=1900; year<1900 +yrs; year++){
			for (int mo=1; mo<=12; mo++){
				int days = calcDays(mo, year);
				for (int day=01; day<=days; day++){
					
					if (day==13) result[d]++;
					d=(d+1)%7;
				}
			}
		}
		
		String output = result[0] + "";
		for (int i=1; i<result.length; i++){
			output+= " " + result[i];
		}
		
		//System.out.print(output);
		PrintWriter out = new PrintWriter(new FileWriter("friday.out"));
		out.write(output+"\n");
		//out.newLine();
		out.close();
	}
	static int calcDays(int mo, int year){ 
		//calculates the number of days in a particular month
		if (year%100==0){
			if (year%400==0) {
				if (mo==2){
					return 29;
				}
			}
			else {
				if (mo==2) return 28;
			}
		}
		if (year%4==0){
			if (mo==2){
				return 29;
			}
		}
		switch (mo){
			case 1: return 31;
			case 2: return 28;
			case 3: return 31; 
			case 4: return 30; 
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
			default: return 30;
		
		}
		
	}
}
