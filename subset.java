/*
ID: abandar1
LANG: JAVA
TASK: subset
*/

import java.util.*;
import java.io.*;
	
public class subset {
	public static long[][] sums;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		int n = 39; //Integer.parseInt(br.readLine());
		//br.close();
		int sum = n*(n+1)/2;
		//System.out.println(sum);
		if (sum%2!=0) {out.println(0); out.close(); return;}
		sums = new long[n+1][sum/2+1];
		for (int i=0; i<sums.length; i++) Arrays.fill(sums[i], -1);
		sums[0][0]=1;
		solve(n, sum/2);
		System.out.println("recursive dp solution: " + sums[n][sum/2]/2);
		out.close();
	}
	
	public static long solve(int n, int k){
		if (sums[n][k]>=0) return sums[n][k];
		if (n==0) return sums[n][k] = 0; 
		
		//if the max number is greater than the desired sum, you can't use it
		if (n>k) return sums[n][k] = solve(n-1, k);
		return sums[n][k] = solve(n-1,k-n) + solve(n-1,k);
	}
}
