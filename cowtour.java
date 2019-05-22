/*
ID: abandar1
LANG: JAVA
TASK: cowtour
*/

import java.util.*;
import java.io.*;

public class cowtour {
	public static int n;
	public static int[][] pos;
	public static int[] field;
	public static double[][] graph;
	public static double[] farthest;
	public static double[] diameter;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowtour.in"));
		n = Integer.parseInt(br.readLine());
		
		pos = new int[n][2];
		graph = new double[n][n];
		field = new int[n];
		farthest = new double[n];
		diameter = new double[n+1];
		StringTokenizer st;
		for (int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) pos[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<n; i++){
			String s = br.readLine();
			for (int j=0; j<n; j++){
				if (s.charAt(j)=='1') graph[i][j] = graph[j][i] = dist(i, j);
				else if (i!=j) graph[i][j] = graph[j][i] = Integer.MAX_VALUE;
			}
		}
		br.close();
		
		int comp = 0;
		for (int i=0; i<n; i++) {
			if (field[i]>0) continue;
			comp++;
			dfs(i, comp);
		}
		shortestPaths();
		
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (field[i]==field[j]) {
					farthest[i] = Math.max(farthest[i], graph[i][j]);
					diameter[field[i]] = Math.max(farthest[i], diameter[field[i]]);
				}
			}
		}
		//System.out.println(Arrays.toString(field));
		//System.out.println(Arrays.toString(diameter));
		double minDiam = Integer.MAX_VALUE;
		double newDiam;
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				//find the diameter of the new field when path from i to j is created
				if (field[i]==field[j]) continue;
				newDiam = Math.max(diameter[field[i]], 
						  Math.max(diameter[field[j]], 
						  farthest[i]+dist(i, j)+farthest[j]));
				minDiam = Math.min(minDiam, newDiam);
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
		out.printf("%.6f\n", minDiam);
		out.close();
		//System.out.println(minDiam);
		
	}
	public static double dist(int i, int j){
		int dx = Math.abs(pos[i][0]-pos[j][0]);
		int dy = Math.abs(pos[i][1]-pos[j][1]);
		return Math.sqrt(dx*dx + dy*dy);
	}
	public static void dfs(int i, int comp) {
		field[i] = comp;
		for (int j=0; j<n; j++){
			if (field[j]==0 && graph[i][j]<Integer.MAX_VALUE) dfs(j, comp);
		}
	}
	public static void shortestPaths(){
		for (int w=0; w<n; w++){ //intermediate vertex
			for (int u=0; u<n; u++){
				for (int v=0; v<n; v++){
					graph[u][v] = Math.min(graph[u][v], graph[u][w]+graph[w][v]);
				}
			}
		}
	}
}