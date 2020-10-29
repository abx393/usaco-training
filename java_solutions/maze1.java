/*
ID: abandar1
LANG: JAVA
TASK: maze1
*/

import java.util.*;
import java.io.*;

public class maze1 {
	public static int w, h;
	public static boolean[][][] graph;
	public static int[][][] dists;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("maze1.in"));
		w = sc.nextInt();
		h = sc.nextInt();
		sc.nextLine();
		graph = new boolean[h][w][4];
		ArrayList<Integer> exits = new ArrayList<Integer>();
		for (int i=0; i<2*h+1; i++){
			String s = sc.nextLine() + "";
			for (int j=0; j<2*w+1; j++){
				if (i%2==0 && j%2==0) continue;
				if (i%2==1 && j%2==1) continue;
				if (i%2==1) {
					if (s.charAt(j)=='|') {
						if (j/2<w) graph[i/2][j/2][3] = true;
						if (j/2-1>=0) graph[i/2][j/2-1][1] = true;
					} else {
						if (j==0){
							exits.add(i/2);
							exits.add(j);
							graph[i/2][j/2][3] = true;
						} else if (j==w*2){
							exits.add(i/2);
							exits.add(j/2-1);
							graph[i/2][j/2-1][1] = true;
						}
					}
				} else if (j%2==1) {
					if (s.charAt(j)=='-'){
						if (i/2<h) graph[i/2][j/2][0] = true;
						if (i/2-1>=0) graph[i/2-1][j/2][2] = true;
					} else {
						if (i==0) {
							exits.add(i);
							exits.add(j/2);
							graph[i/2][j/2][0] = true;
						} else if (i==h*2){
							exits.add(i/2-1);
							exits.add(j/2);
							graph[i/2-1][j/2][2] = true;
						}
					}
				}
			}
		}
		sc.close();
		int res = 0;
		dists =  new int[h][w][2];
		
		dfs(exits.get(0), exits.get(1), 1, 0); 
		dfs(exits.get(2), exits.get(3), 1, 1);
		for (int i=0; i<h; i++){
			for (int j=0; j<w; j++){
				res = Math.max(res, Math.min(dists[i][j][0], dists[i][j][1]));
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		out.println(res);
		out.close();
		
	}
	public static void dfs(int x, int y, int dist, int index){
		if (dists[x][y][index]!=0 && dist>=dists[x][y][index]) return;
		dists[x][y][index] = dist;
		if (!graph[x][y][0]) dfs(x-1, y, dist+1, index); 
		if (!graph[x][y][1]) dfs(x, y+1, dist+1, index);
		if (!graph[x][y][2]) dfs(x+1, y, dist+1, index);
		if (!graph[x][y][3]) dfs(x, y-1, dist+1, index);
	}
}