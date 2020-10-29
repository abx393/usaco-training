/*
ID: abandar1
LANG: JAVA
PROG: prefix
 */
import java.io.*;
import java.util.*;
//imports
public class prefix2 {
	public int solve(String s, String[] primitives) {
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		int res = 0;
		for (int k = 0; k <= len; k++) {
			if (dp[k]) {
				for (String p : primitives) {
					int l = p.length();
					if (k + l  > len) continue;
					if (s.substring(k , k + l ).equals(p)) {
						dp[k + l] = true;
					}
				}
				res = k;
			}
		}
		
		return res;
	}
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		String problemName = "prefix";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));
		ArrayList<String> primitives = new ArrayList<String>();
	//shorter way of writing the in and out
		String line = f.readLine();
		while (!line.equals(".")) {
		//make sure the line doesnt equal nothing
			StringTokenizer st = new StringTokenizer(line);
		//if it doesnt, string tokenizer will split it into tokens
			while (st.hasMoreTokens()) {
				primitives.add(st.nextToken());
			}
			line = f.readLine();
		}
		StringBuilder sb = new StringBuilder();
		line = f.readLine();
		while (line != null) {
			sb.append(line);
			line = f.readLine();
			//making next line, for repeats
		}
		int res = (new prefix()).solve(sb.toString(), primitives.toArray(new String[0]));
		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		System.exit(0); // don't omit this!

		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/Math.pow(10, 3) + "s");
		
		System.exit(0); // don't omit this!
	}
}