/*
ID: abandar1
LANG: JAVA
TASK: barn1
 */

import java.util.*;
import java.io.*;

public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] stalls = new int[c];
		int[] gaps = new int[c-1]; // records intervals of cowless stalls
		
		for (int i = 0; i < stalls.length; i++) {
			stalls[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(stalls);
		int firstCow = stalls[0];
		int lastCow = stalls[stalls.length - 1];
		
		for (int i = 0; i < gaps.length; i++) {
			gaps[i] = stalls[i+1] - stalls[i] - 1;
		}
		
		System.out.println("first occupied stall: " + firstCow);
		System.out.println("last occupied stall: " + lastCow);
		
		int minStalls = lastCow - firstCow + 1; // the solution if m=1
		System.out.println("m=1: " + minStalls);
		Arrays.sort(gaps);

		for (int i = 0; i < m-1 && i < c-1; i++) {
			minStalls -= gaps[c - 2 - i];
			System.out.println("m=" + (i+2) + ": " + minStalls);
		}
		out.println(minStalls);
		out.close();
	}
}
