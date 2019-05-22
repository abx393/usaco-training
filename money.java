/*
ID: abandar1
LANG: JAVA
TASK: money
*/

import java.util.*;
import java.io.*;

public class money {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("money.in"));
		Scanner sc = new Scanner(new File("money.in"));

		int v = sc.nextInt();
		int n = sc.nextInt();
		int[] coins = new int[v+1];
		for (int i=1; i<=v; i++){
			coins[i] = sc.nextInt();
		}
		long[][] numWays = new long[v+1][n+1];
		numWays[0][0] = 1;
		
		// numWays[v][n] = numWays[v-1][n-coins[v]] + numWays[v-1][n]
		for (int i=1; i<=v; i++){
			for (int j=0; j<=n; j++){
				numWays[i][j] += numWays[i-1][j];
				int k=1;
				while (j>=k*coins[i]){
					numWays[i][j] += numWays[i-1][j-k*coins[i]];
					k++;
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		out.println(numWays[v][n]);
		out.close();
	}
}
