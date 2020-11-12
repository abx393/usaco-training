/*
ID: abandar1
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix {
	public static void main(String[] args) throws IOException {
		//TreeSet<String> ts = new TreeSet<String>();
		ArrayList<String> primitives = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("prefix.in"));
		String line = br.readLine();
		StringTokenizer st;
		while (!line.equals(".")) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) primitives.add(st.nextToken());
			line = br.readLine();
		}
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			line = br.readLine();
			if (line == null) break;
			sb.append(line);
		}
		String seq = sb.toString();
		br.close();
		boolean[] reachable = new boolean[seq.length() + 1];
		//ArrayList<String> primitives = new ArrayList<String>(ts);
		System.out.println(primitives);
		System.out.println(seq);
		Collections.sort(primitives);
		
		reachable[0] = true;
		int ans = 0;
		for (int i = 0; i < seq.length(); i++){
			if (!reachable[i]) continue;
			for (int len = 1; len <= 10; len++) {
				if (i + len <= seq.length() && Collections.binarySearch(primitives, seq.substring(i, i + len)) >= 0) {
					reachable[i+len] = true;
					ans = i + len;
				} 
			}
		}
		//System.out.println(Arrays.toString(reachable));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		out.println(ans);
		out.close();
	}
}
