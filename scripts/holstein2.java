/*
ID: abandar1
LANG: JAVA
TASK: holstein
*/

import java.util.*;
import java.io.*;

public class holstein2 {
	public static int v, g;
	public static int[] req;
	public static int[][] feeds;
	public static ArrayList<Integer> res = new ArrayList<Integer>();
	public static int minSum = Integer.MAX_VALUE;
	public static int[] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
		v = Integer.parseInt(br.readLine());
		req = new int[v];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<v; i++){
			req[i] = Integer.parseInt(st.nextToken());
		}
		temp = req;
		g = Integer.parseInt(br.readLine());
		feeds = new int[g][v];
		
		for (int i=0; i<15; i++) {
			res.add(0);
		}
		for (int i=0; i<g; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<v; j++){
				feeds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		dfs();
		//System.out.println(Arrays.toString(new int[4]));
		//System.out.println(res.size());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		out.print(res.size());
		for (int i: res){
			out.print(" " + (i+1));
		}
		out.println();
		//System.out.println(Arrays.toString(req));
		out.close();
	}
	public static void dfs(){
		for (int i=g-1; i>=0; i--){
			//System.out.println(Arrays.toString(req));
			dfs(i, new ArrayList<Integer>(), 0);
		}
	}
	public static void dfs(int i, ArrayList<Integer> path, int sum){
		path.add(i);
		//subtracts the vitamins received from the vitamins required
		add(req, feeds[i], -1); 
		int temp = sum(feeds[i]);
		sum += temp;
		if (nonpositive(req)) {
			if (path.size()<res.size() || (path.size()==res.size() && sum < minSum)){
				res = path;
				minSum = sum;
			}
		}
		else {
			for (int j=i+1; j<g; j++){
				dfs(j, path, sum);
			}
			path.remove((Integer) i);
		}
		//reverses the changes made
		add(req, feeds[i], 1);
		sum -= temp;
		
	}
	public static void add(int[] a, int[] b, int factor){
		for (int i=0; i<Math.min(a.length, b.length); i++){
			a[i] += b[i] * factor;
		}
	}
	public static boolean nonpositive(int[] a){
		for (int i:a){
			if (i>0) return false;
		}
		return true;
	}
	public static int sum(int[] a){
		int res = 0;
		for (int i: a) res += i;
		return res;
	}
}
