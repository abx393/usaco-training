/*
ID: abandar1
LANG: JAVA
TASK: agrinet
*/

import java.io.*;
import java.util.*;

public class agrinet {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("agrinet.in"));
		int n = sc.nextInt();
		int[][] graph = new int[n][n];
		
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++) graph[i][j] = sc.nextInt();
		}
		sc.close();
		int[] dist = new int[n];
		int[] source = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(source, Integer.MAX_VALUE);
		boolean[] intree = new boolean[n];
		
		int treesize = 1;
		int treecost = 0;
		intree[0] = true;
		for (int i=0; i<n; i++){
			if (graph[0][i] > 0) {
				dist[i] = graph[0][i];
				source[i] = 0;
			}
		}
		
		while (treesize< n){
			int minDist = Integer.MAX_VALUE;
			int minNode = 0;
			for (int i=0; i<n; i++) {
				if (!intree[i] && dist[i]<minDist) {
					minDist = dist[i];
					minNode = i;
				}
			}
			treesize++;
			treecost += dist[minNode];
			intree[minNode] = true;
			
			for (int i=0; i<n; i++){
				if (graph[i][minNode]==0) continue;
				if (dist[i]>graph[i][minNode]){
					dist[i] = graph[i][minNode];
					source[i] = minNode;
				}
			}
			
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
		out.println(treecost);
		out.close();
	}
}
