/*
ID: abandar1
LANG: JAVA
TASK: cowtour
*/

import java.util.*;
import java.io.*;

public class cowtour2 {
	public static int n;
	public static int[][] pos;
	public static int[] components;
	public static ArrayList<ArrayList<Integer>> compList;
	public static double[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowtour.in"));
		n = Integer.parseInt(br.readLine());
		
		pos = new int[n][2];
		graph = new double[n][n];
		components = new int[n];
		compList = new ArrayList<ArrayList<Integer>>();
		compList.add(new ArrayList<Integer>());
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) pos[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				if (s.charAt(j) == '1') graph[i][j] = graph[j][i] = dist(i, j);
				else if (i!=j) graph[i][j] = graph[j][i] = Integer.MAX_VALUE;
			}
		}
		int comp = 0;
		for (int i=0; i<n; i++) {
			if (components[i] > 0) continue;
			comp++;
			dfs(i, comp);
		}
		shortestPaths();
		double res = Integer.MAX_VALUE;
		double diameter;
		double maxDist=0;
		double[] minDiameter = new double[n+1];
		Arrays.fill(minDiameter, Integer.MAX_VALUE);
		/*
		for (int a=1; a<compList.size(); a++){
			for (int b=1; b<compList.size(); b++){
				if (a==b) continue;
				diameter=Integer.MAX_VALUE;
				
				//System.out.println(diameter);
				for (int c: compList.get(a)){
					for (int d: compList.get(b)){
						double longest = 0;
						for (int e: compList.get(a)){
							for (int f: compList.get(b)){
								double dist1 = graph[e][c];
								double middleDist = dist(c, d);
								double dist2 = graph[d][f];
								
								longest = Math.max(longest, dist1+middleDist+dist2);
								//if (dist1+middleDist+dist2>20.6 && dist1+middleDist+dist2<20.7) System.out.println(c + " " + d + " " + e + " " + f);
							}
						}
						//System.out.println(shortest);
						diameter = Math.min(diameter, longest);
					}
				}
				for (int elem: new int[] {a, b}){
					if (minDiameter[elem]==Integer.MAX_VALUE) {
						for (int pasture1: compList.get(elem)){
							for (int pasture2: compList.get(elem)){
								diameter=Math.max(diameter, graph[pasture1][pasture2]);
							}
						}
					} else {
						diameter=Math.max(diameter, minDiameter[elem]);
					}
				}
				
				
				//System.out.println(diameter);
				
				//System.out.println(diameter);
				//if (diameter==0) System.out.println(a + " " + b);//System.out.println(diameter);
				res = Math.min(res, diameter);
			}
		}
		*/
		boolean[][] visited = new boolean[n+1][n+1];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (graph[i][j]<Integer.MAX_VALUE) continue;
				//if (visited[components[i]][components[j]]) continue;
				visited[components[i]][components[j]] = true;
				double middleDist = dist(i, j);
				double totalDist;
				//ArrayList<Integer> temp = compList.get(components[i]);
				//temp.addAll(compList.get(components[j]));
				
				/*for (int x: compList.get(components[i])){
					for (int y: compList.get(components[j])){
						totalDist = graph[i][x] + middleDist+graph[j][y];
						maxDist = Math.max(totalDist, maxDist);
					}
				}*/
				for (int x: compList.get(components[i])){
					for (int y: compList.get(components[i])){
						totalDist = graph[x][y];
						maxDist = Math.max(totalDist, maxDist);
					}
				}
				
				for (int x: compList.get(components[j])){
					for (int y: compList.get(components[j])){
						totalDist = graph[x][y];
						maxDist = Math.max(totalDist, maxDist);
					}
				}
				
				for (int x=0; x<n; x++){
					for (int y=0; y<n; y++){
						if (graph[x][i]==Integer.MAX_VALUE || graph[j][y]==Integer.MAX_VALUE) continue;
						totalDist = graph[x][i]+middleDist+graph[j][y];
						maxDist = Math.max(totalDist, maxDist);
					}
				}
				
				res = Math.min(maxDist, res);
				maxDist = 0;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
		out.printf("%.6f\n", res);
		out.close();
	}

	// Returns Euclidean distance
	public static double dist(int i, int j){
		int dx = Math.abs(pos[i][0]-pos[j][0]);
		int dy = Math.abs(pos[i][1]-pos[j][1]);
		return Math.sqrt(dx*dx + dy*dy);
	}

	// Determines connected components
	public static void dfs(int i, int comp) {
		components[i] = comp;
		if (compList.size()<comp+1) compList.add(new ArrayList<Integer>());
		compList.get(comp).add(i);
		
		for (int j=0; j<n; j++){
			if (components[j]==0 && graph[i][j]<Integer.MAX_VALUE) dfs(j, comp);
		}
		
	}

	public static void print(){
		for (double[] i: graph) System.out.println(Arrays.toString(i));
	}

	// Floyd-Warshall Algorithm
	public static void shortestPaths(){
		for (int w=0; w<n; w++) { //intermediate vertex
			for (int u=0; u<n; u++) {
				for (int v=0; v<n; v++) {
					graph[u][v] = Math.min(graph[u][v], graph[u][w]+graph[w][v]);
				}
			}
		}
	}
}
