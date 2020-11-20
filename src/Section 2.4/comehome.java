/*
ID: abandar1
LANG: JAVA
TASK: comehome
*/

import java.io.*;
import java.util.*;

public class comehome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("comehome.in"));
		int p = Integer.parseInt(br.readLine());
		int[][] adj = new int[52][52];
		for (int[] i : adj) Arrays.fill(i, Integer.MAX_VALUE);
		boolean[] visited = new boolean[52];

		StringTokenizer st;
		for (int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int[] node = new int[2];
			for (int j=0; j<2; j++) {
				node[j] = st.nextToken().charAt(0);
				if (node[j]>=65 && node[j]<=90) node[j] -= 39;
				else node[j] -= 97;
			}
			adj[node[0]][node[1]] = adj[node[1]][node[0]] = 
                                    Math.min(adj[node[0]][node[1]], Integer.parseInt(st.nextToken())); 
		}
		br.close();
		
		// Djikstra's Algorithm
		int[] dist = new int[52];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[51] = 0;
		int numVisited = 0;

		while (numVisited < 52) {
			numVisited++;
			
			int vertex = 0;
			long minDist = Integer.MAX_VALUE;
			for (int i=0; i<dist.length; i++) {
				if (!visited[i] && dist[i] <= minDist) {
					minDist = dist[i];
					vertex = i;
				}
			}
			visited[vertex] = true;
			
			for (int i=0; i<adj[vertex].length; i++) {
				if (adj[vertex][i] < Integer.MAX_VALUE) {
                    dist[i] = Math.min(dist[i], dist[vertex] + adj[vertex][i]);
                }
			}
		}
		
		char minPasture = 'A';
		int minDist = Integer.MAX_VALUE;
		System.out.println(Arrays.toString(dist));
		System.out.println(('R' - 39) + " " + dist['R' - 39]);
		for (int i=26; i<51; i++) {
			if (dist[i] < minDist) {
				minDist = dist[i];
				minPasture = (char) (i+39);
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
		out.println(minPasture + " " + minDist);
		out.close();
		
	}
}
