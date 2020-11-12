/*
ID: abandar1
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;
	
public class nocows {
    public static int MOD = 9901;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("nocows.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		br.close();
		
		int[][] dp = new int[k+1][n+1];
		
		// base case
		for (int i=1; i<=k; i++) dp[i][1] = 1; 
		
		// recursive case
		for (int i=1; i<=k; i++) {
			for (int j=3; j<=n; j+=2) {
				for (int m=1; m<=j-1; m+=2) {
					dp[i][j] = (dp[i][j] + dp[i-1][m] * dp[i-1][j-m-1]) % MOD;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		out.println((dp[k][n] - dp[k-1][n] + MOD) % MOD);
		out.close();
	}
}
