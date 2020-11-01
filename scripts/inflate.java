/*
ID: abandar1
LANG: JAVA
TASK: inflate
*/

import java.io.*;
import java.util.*;

public class inflate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inflate.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] points = new int[n];
		int[] len = new int[n];
		for (int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			points[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] maxpoints = new int[m+1];
		for (int i=1; i<=m; i++){
			for (int j=0; j<n; j++){
				if (i<len[j]) continue;
				maxpoints[i] = Math.max(maxpoints[i], maxpoints[i-len[j]]+points[j]);
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		out.println(maxpoints[m]);
		out.close();
	}
}
