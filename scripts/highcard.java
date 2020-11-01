import java.io.*;
import java.util.*;

public class highcard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> elsie = new ArrayList<Integer>();
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		for (int i=1; i<=2*n; i++) bessie.add(i);
		for (int i=0; i<n; i++){
			int x = Integer.parseInt(br.readLine());
			elsie.add(x);
			bessie.remove((Integer) x);
		}
		br.close();
		Collections.sort(elsie);
		System.out.println(bessie.toString());
		System.out.println(elsie.toString());
		int ans = 0;
		int j=0;
		a: for (int i=0; i<n; i++){
			if (j==n) break a;
			while (bessie.get(j)<elsie.get(i)){
				j++;
				if (j==n) break a;
			}
			ans++;
			j++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		out.println(ans);
		out.close();
	}
}
