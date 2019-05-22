import java.io.*;
import java.util.*;

public class balancing {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
	
	}
}
