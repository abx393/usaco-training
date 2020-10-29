/*
ID: abandar1
LANG: JAVA
TASK: concom
*/

import java.util.*;
import java.io.*;
	
public class concom {
	public static int[][] own = new int[100][100];
	public static boolean[][] control = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("concom.in"));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		StringTokenizer st;
		for (int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			own[c1-1][c2-1] = p;
			if (p>50) {
				control[c1-1][c2-1] = true;
				q.add(new int[] {c1-1, c2-1});
			}
		}
		br.close();
		
		while (!q.isEmpty()){
			int[] pair = q.removeFirst();
			for (int i=0; i<100; i++){
				own[pair[0]][i]+=own[pair[1]][i];
				if (own[pair[0]][i]>50 && !control[pair[0]][i]) {
					q.add(new int[] {pair[0], i});
					control[pair[0]][i] = true;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		for (int i=0; i<100; i++){
			for (int j=0; j<100; j++){
				if (control[i][j] && i!=j) {
					out.println((i+1) + " " + (j+1));
				}
			}
		}
		out.close();
	}
}
