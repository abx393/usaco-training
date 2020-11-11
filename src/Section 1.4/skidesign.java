/*
ID: abandar1
LANG: JAVA
TASK: skidesign
 */

import java.util.*;
import java.io.*;

public class skidesign {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		int min = Integer.MAX_VALUE;
		Arrays.sort(heights);
		int minElev = heights[0];
		int maxElev = heights[n - 1];
		for (int i = minElev; i <= maxElev - 17; i++) {
			int cost = 0;
			for (int h : heights) {
				if (h < i) {
					cost += (h-i) * (h-i);
				} else if (h > i + 17) {
					cost += Math.pow(h - i - 17, 2);
				}
			}
			min = Math.min(cost, min);
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		out.println(min);
		out.close();
	}
}
