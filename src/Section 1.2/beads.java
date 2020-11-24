/*
ID: abandar1
LANG: JAVA
PROB: beads
 */

import java.io.*;
import java.util.Scanner;

public class beads {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("beads.in"));
		PrintStream out = new PrintStream("beads.out");
		
	       final int N = Integer.parseInt(sc.nextLine());

	       String necklaceBeads = sc.nextLine();
	 
	       int maxBeads = 0;
	 
	       for (int i = 0; i < N; i++) {
	 
	           int count = 0;

	           String straightNecklaceBeads = necklaceBeads.substring(i + 1)
	 
	                   + necklaceBeads.substring(0, i + 1);

	            char colorCheck = ' ';
	            for (int j = 0; j < straightNecklaceBeads.length(); j++) {
	                if (straightNecklaceBeads.charAt(j) == 'w')
	                    count++;
	                else if (colorCheck == ' ') {
	                    colorCheck = straightNecklaceBeads.charAt(j);
	                    count++;
	                } else {
	                     if (straightNecklaceBeads.charAt(j) == colorCheck)
	                        count++;
	                     else 
	                       break;
	               }
	            }

	            colorCheck = ' ';
	            
	             for (int j = (straightNecklaceBeads.length() - 1); j >= 0; j--) {
	                if (straightNecklaceBeads.charAt(j) == 'w')
	                    count++;
	                else if (colorCheck == ' ') {
	                    colorCheck = straightNecklaceBeads.charAt(j);
	                    count++;
	                } else {
	                    if (straightNecklaceBeads.charAt(j) == colorCheck) 
	                        count++;
	                    else        
	                       break;
	               }
	            }
	            maxBeads = Math.max(maxBeads, count);
	        }

	          if (maxBeads > N)
	           maxBeads = N;
	           out.println(maxBeads);
	           sc.close();
	           out.close();
	           System.exit(0);
	    
	}
}
