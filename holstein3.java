import java.io.*;
import java.util.*;

public class holstein3 {
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
	
		g = Integer.parseInt(br.readLine());
		temp = new int[v];
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
		
		dfs(0, new ArrayList<Integer>());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		
		System.out.print(res.size());
		for (int i: res){
			System.out.print(" " + (i+1));
		}
		System.out.println();
		//System.out.println(Arrays.toString(req));
		out.close();
	}
	public static void dfs(int i, ArrayList<Integer> path){
		if (i==g) {
			System.out.println(res);
			for (int j=0; j<path.size(); j++){
				for (int k=0; k<v; k++){
					temp[k] += feeds[path.get(j)][k];
				}
			}
			if (greater(temp, req) && path.size()<res.size()) res = path;
			temp = new int[v];
			return;
			
		}
		dfs(i+1, path);
		path.add(i);
		dfs(i+1, path);
		
		path.remove((Integer) i);
	}
	public static void add(int[] a, int[] b, int factor){
		for (int i=0; i<Math.min(a.length, b.length); i++){
			a[i] += b[i] * factor;
		}
	}
	public static boolean greater(int[] a, int[] b){
		for (int i=0; i<a.length; i++){
			if (a[i] < b[i]) return false;
		}
		return true;
	}
	public static int sum(int[] a){
		int res = 0;
		for (int i: a) res += i;
		return res;
	}
}
