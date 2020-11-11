import java.io.*;
import java.util.*;

public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[][] ps = new int[3][n + 1];
		int[] sums = new int[3];

		for (int i = 1; i <= n; i++) {
			sums[Integer.parseInt(br.readLine()) - 1]++;
			for (int j = 0; j < 3; j++) ps[j][i] = sums[j];
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 2; j++) out.print(ps[j][b] - ps[j][a - 1] + " ");
			out.print(ps[2][b] - ps[2][a - 1]);
			out.println();
		}

		br.close();
		out.close();
	}
}
