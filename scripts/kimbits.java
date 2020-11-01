/*
ID: abandar1
LANG: JAVA
TASK: kimbits
*/

/*
 * Non-Dynamic Programming Approach
 */

import java.io.*;
import java.util.*;

public class kimbits {
	public static long ones = 0;
	public static void main(String[] args) throws IOException {
		long init = System.nanoTime();
		BufferedReader br = new BufferedReader(new FileReader("kimbits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		long i = Long.parseLong(st.nextToken());
		br.close();
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		
		long count = 0;
		StringBuilder number = new StringBuilder("");
		for (int j=0; j<n; j++) number.append("0");
		for (long j=0; j<(long)Math.pow(2, n); j++){
			if (ones<=len){
				count++;
			}
			if (count==i) {
				out.println(number.reverse().toString());
				break;
			}
			number = inc(number);
		}
		out.close();
		System.out.println((System.nanoTime()-init)/100000 + " ns");
	}
	public static StringBuilder inc(StringBuilder s){
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='0') {
				s.replace(i, i+1, "1");
				ones++;
				break;
			} else {
				s.replace(i, i+1, "0");
				ones--;
			}
		}
		return s;
	}
}
