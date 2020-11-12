/*
ID: abandar1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
	public static int n, b, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		br.close();
		
		int[] res = new int[n];
		res[0] = 0;
		int index = 1;
		outer: for (int i = 1; i < Math.pow(2, b) && index < n; i++) {
			for (int j : res){
				if (dist(i, j) < d) continue outer;
			}
			res[index] = i;
			index++;
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		out.print(res[0]);
		for (int i = 1; i < n; i++) {
			if (i % 10 == 0) out.print("\n" + res[i]);
			else out.print(" " + res[i]);			
		}
		out.println();
		out.close();
	}
	
	// Returns hamming distance
	public static int dist(int i, int j){
		int res = 0;
		for (int k = 0; k < b; k++) {
			int bit1 = 1 << k & i;
			int bit2 = 1 << k & j;
			if (bit1 != bit2) res++;
		}
		return res;
	}
}
